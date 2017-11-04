package com.suyoga.subjee.dao.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.suyoga.subjee.controller.LoginController;
import com.suyoga.subjee.dao.ProductDao;
import com.suyoga.subjee.json.DeliverOrderProduct;
import com.suyoga.subjee.json.InvoiceDetails;
import com.suyoga.subjee.json.OrderInvoice;
import com.suyoga.subjee.json.PlaceOrder;
import com.suyoga.subjee.json.Product;
import com.suyoga.subjee.json.ProductDetails;
import com.suyoga.subjee.json.ProductList;
import com.suyoga.subjee.json.QuantityList;
import com.suyoga.subjee.json.ReturnOrderProduct;
import com.suyoga.subjee.json.UpdateInvoice;
import com.suyoga.subjee.model.CentralPrice;
import com.suyoga.subjee.model.CentralProduct;
import com.suyoga.subjee.model.SabjiCity;
import com.suyoga.subjee.model.SabjiInvoicedetail;
import com.suyoga.subjee.model.SabjiLocation;
import com.suyoga.subjee.model.SabjiOrder;
import com.suyoga.subjee.model.SabjiOrderProduct;
import com.suyoga.subjee.util.SubjeeResponseCodes;
import com.suyoga.subjee.util.SubjeeUtil;
@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	 SessionFactory sessionFactory;
	private static final Logger logger = Logger.getLogger(ProductDaoImpl.class);

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	@Override
	public List<Product> getProduct(int categoryid,int subCategoryId) {
		 List<Product> product=new ArrayList<Product>();
		 
		 ConcurrentHashMap<Integer , String> myMap = new ConcurrentHashMap<Integer , String>(); 
		 
		 Session session = sessionFactory.openSession();
	      Transaction tx = null;
	      List<CentralProduct> list =null;
	      
	      try {
			tx = session.beginTransaction();
			   List<Object[]> listMap=session.createSQLQuery("select * from sabji_quantity").list();
				for (Object[] objects : listMap) {
					
					myMap.put((Integer)objects[1], (String)objects[2]);
					
				}
			   
				/////list=session.createQuery("from CentralProduct where categoryId=:id").list();
				if(subCategoryId==0){
					Query prod=session.createQuery("from CentralProduct where categoryId=:id ORDER BY productCode ASC ");
					prod.setParameter("id", categoryid);				
					list=prod.list();
				}else{
					Query prod=session.createQuery("from CentralProduct where categoryId=:id and subcategoryId=:subId ORDER BY productCode ASC");
					prod.setParameter("id", categoryid);	
					prod.setParameter("subId", subCategoryId);
					list=prod.list();
				}			
				
				
				for (CentralProduct centralProduct : list) {
					DecimalFormat df = new DecimalFormat("0.000##");
					if(centralProduct.getProductWeight()!=null && (centralProduct.getProductWeight().compareTo(new BigDecimal(0)))>0){	
						
						Product productDetails=new Product();
						productDetails.setProductId(centralProduct.getProductId());
						productDetails.setProductCode(centralProduct.getProductCode());
						productDetails.setProductName(centralProduct.getProductName());
						productDetails.setBrandname(centralProduct.getBrandname());
					    List<CentralPrice>	centralPrice=centralProduct.getCentralPrices();
						for (CentralPrice centralPrice2 : centralPrice) {
							productDetails.setPrice(centralPrice2.getPriceValue());
							productDetails.setPriceMinQuantity(centralPrice2.getPriceMinQuantity());
							
							List<QuantityList> listQuantity=getQuantityList(centralPrice2.getPriceMinQuantity(),myMap);
	                       
							productDetails.setQuantityList(listQuantity);
						}
						
						product.add(productDetails);
						
					}
					}
					
			
				
				  tx.commit();	
				
				
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if (tx!=null) tx.rollback();
			logger.warn(e.getMessage());
		}finally {
	         session.close(); 
	     }
		 
		 
		 
		return product;
	}
	
	public List<QuantityList> getQuantityList(int priceMin, ConcurrentHashMap<Integer , String> myMap){
		
		List<QuantityList> listQuantity=new ArrayList<QuantityList>();
		int minQuantity=priceMin;
		
		int code=1;
		
		for(int i=1; i<5; i++){
			
		    QuantityList quantity=new QuantityList();
		   int counter=0; 
        	if(i==1){
        	   quantity.setQuantityValue(code);
		       quantity.setQuantity(myMap.get(minQuantity));	
		       
		    }else{
		    	
		    	minQuantity=2*minQuantity;
		    	code=2*code;
		    	quantity.setQuantityValue(code);
		    	if((myMap.get(minQuantity))==null){
		    		counter ++;	
		    	}
		    	quantity.setQuantity(myMap.get(minQuantity));	
		    	
		    }
        	if(counter<1){
        		listQuantity.add(quantity);	
        	}
        	
		   
		}
		
		 
		
		return  listQuantity;
	}
	
	
	
	
	
	
	 public OrderInvoice placeOrder(PlaceOrder placeOrder){
		 OrderInvoice orderInvoice=new OrderInvoice();
		 Session session = sessionFactory.openSession();
		 int zipcode=0;
		 
		
	      Transaction tx = null; 
	      
	      String invoiceNumber="";
	      try {
			tx = session.beginTransaction();
			String venderId="";
			 if(placeOrder.getZipcode()!=null && !placeOrder.getZipcode().equalsIgnoreCase("null") && !placeOrder.getZipcode().trim().equalsIgnoreCase("")){
				 zipcode=Integer.parseInt(placeOrder.getZipcode().trim());
			 }
		/*	if(placeOrder.getZipcode()==null || placeOrder.getZipcode().trim().equalsIgnoreCase("") || zipcode==0 || placeOrder.getZipcode().trim().length() > 6 || placeOrder.getZipcode().trim().length()< 6 ){
				 orderInvoice.setOrderNumber("");
				 orderInvoice.setMessage("ZipCode is not valid Please enter valid Zipcode");
			}else{	*/			
			List<Object[]> zipCode=session.createSQLQuery("select vendor_id , zipcode, minAmount, deliveryCharges  from sabji_location where zipcode="+zipcode+" and active is true ").list();
			for (Object[] objects : zipCode) {
				venderId= (String)objects[0];
				orderInvoice.setMinAmount(objects[2]!=null?(Integer)objects[2]:0);
				orderInvoice.setDeliveryCharges(objects[3]!=null?(Integer)objects[3]:0);
			}
			if(venderId!=null && !venderId.equals("") &&!zipCode.isEmpty()){
				
			invoiceNumber=createInvoiceNumber(placeOrder.getTotalAmount());
		
			SabjiOrder sabjiOrder=new SabjiOrder();
			//sabjiOrder.setOrderUserId(Integer.parseInt(placeOrder.getMobileNumber()));
			sabjiOrder.setOrderUserId(new BigInteger(placeOrder.getMobileNumber()));
			sabjiOrder.setOrderFullPrice(new BigDecimal(placeOrder.getTotalAmount()));
			sabjiOrder.setOrderBillingAddress(placeOrder.getBillingAddress());
			sabjiOrder.setOrderStatus("P");
			sabjiOrder.setOrderType(placeOrder.getPayMode());
			sabjiOrder.setOrderBillingMobile(new BigInteger(placeOrder.getBillingMobile()));
			sabjiOrder.setOrderInvoiceNumber(invoiceNumber);
			sabjiOrder.setOrderNumber(invoiceNumber);
			sabjiOrder.setOrderDate(new Date());
			sabjiOrder.setVenderId(venderId);
			sabjiOrder.setTimeSlot(placeOrder.getTimeSlot());
			sabjiOrder.setPromoCode(placeOrder.getPromocode());
			sabjiOrder.setDiscountAmount(new BigDecimal(placeOrder.getDiscountAmount()));
			session.save(sabjiOrder);
		     Query prod=session.createQuery("from SabjiOrder where orderInvoiceNumber=:id");
			 prod.setParameter("id", invoiceNumber);
			 sabjiOrder=(SabjiOrder) prod.uniqueResult();
			 
			 
			List<ProductList> productList=placeOrder.getProductList();
			
			for (ProductList productList2 : productList) {
				
				SabjiOrderProduct sabjiOrderProduct=new SabjiOrderProduct();
				sabjiOrderProduct.setSabjiOrder(sabjiOrder);
				sabjiOrderProduct.setOrderProductCode(productList2.getProductCode());
				sabjiOrderProduct.setOrderProductId(sabjiOrder.getOrderId());
				sabjiOrderProduct.setOrderProductName(productList2.getProductName());
				sabjiOrderProduct.setOrderProductQuantity(productList2.getQuantity());
				sabjiOrderProduct.setProductId(Integer.parseInt(productList2.getProductId()));
				sabjiOrderProduct.setOrderProductPrice(new BigDecimal(productList2.getPrice()));
				sabjiOrderProduct.setItemReturn(false);
				if(productList2.getBrandname()!=null && !productList2.getBrandname().equals("")){
					sabjiOrderProduct.setBrandname(productList2.getBrandname());	
				}else{
					sabjiOrderProduct.setBrandname("SUYOGA");
				}
				
				session.save(sabjiOrderProduct);				
			}
			///orderNumber=placeOrder.getInvoiceId();
		   tx.commit();
		   orderInvoice.setOrderNumber(invoiceNumber);
		   orderInvoice.setTotalPrice(placeOrder.getTotalAmount());	
			}else{
			 orderInvoice.setOrderNumber("");
			 //orderInvoice.setMessage(SubjeeUtil.subjeeErrMsg(SubjeeResponseCodes.SUBJEE008));
			 orderInvoice.setMessage("Software Update Required,Please update the App from Play Store.");
			}
			//}
		   
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			orderInvoice.setOrderNumber("");
			//orderInvoice.setMessage(SubjeeUtil.subjeeErrMsg(SubjeeResponseCodes.SUBJEE021));
			 orderInvoice.setMessage("Software Update Required,Please update the App from Play Store.");
			if (tx!=null) tx.rollback();
			logger.warn(e.getMessage());
		}finally {
	         session.close(); 
	     }
		 
		 return orderInvoice;
	 }
	 
	 public String createInvoiceNumber(String totalAmount){
		 
		 DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		 String requiredDate = df.format(new Date()).toString();
			Integer dateWiseOrder=0;
			 String invoiceNumber="SUG";
			 
			 Session session = sessionFactory.openSession();
		      Transaction tx = null; 		   
		      try {
				tx = session.beginTransaction();
				List<Object[]> list=session.createSQLQuery("select  invoice_name , orderNumber from sabji_invoicedetails  where invoice_date='"+requiredDate+"' and invoice_id=(select max(invoice_id) from sabji_invoicedetails  where invoice_date='"+requiredDate+"')").list();
				for (Object[] objects : list) {					
					dateWiseOrder=(Integer)objects[1];					
				} 	
				dateWiseOrder ++;
				
				 DateFormat df1 = new SimpleDateFormat("MMdd");
				 String invoiceDate = df1.format(new Date()).toString();
				 invoiceNumber=invoiceNumber+""+invoiceDate+"0"+dateWiseOrder;
				 SabjiInvoicedetail sabjiInvoicedetail=new SabjiInvoicedetail();
				 sabjiInvoicedetail.setInvoiceDate(new Date());
				 sabjiInvoicedetail.setInvoiceName(invoiceNumber);
				 sabjiInvoicedetail.setOrderNumber(dateWiseOrder);
				 sabjiInvoicedetail.setPrice(new BigDecimal(totalAmount));
				 session.save(sabjiInvoicedetail);
				 
				tx.commit();	
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					logger.warn(e.getMessage());
					if (tx!=null) tx.rollback();
				}finally {
			         session.close(); 
			     }
			
		
		 
		 return invoiceNumber;
	 }
	 
	 public List<InvoiceDetails> getInvoiceDetails(String orderUserId){
	   List<InvoiceDetails> details=new ArrayList<InvoiceDetails>();
		 
		 Session session = sessionFactory.openSession();		 
	      Transaction tx = null; 
	      List<SabjiOrder> list=null;
	      try {
			tx = session.beginTransaction();
			
			Query prod=session.createQuery("from SabjiOrder where orderUserId=:orderId order by orderId desc");
			prod.setParameter("orderId", BigInteger.valueOf(Long.parseLong(orderUserId)));		
			prod.setMaxResults(10);
			list=prod.list();
			for (SabjiOrder sabjiOrder : list) {
				InvoiceDetails invoiceDetails=new InvoiceDetails();
				invoiceDetails.setInvoiceNumber(sabjiOrder.getOrderInvoiceNumber());
				invoiceDetails.setTotalprice(String.valueOf(sabjiOrder.getOrderFullPrice()));
				invoiceDetails.setInvoiceStatus(sabjiOrder.getOrderStatus());
				invoiceDetails.setOrderId(sabjiOrder.getOrderId());
				invoiceDetails.setDeliveryTime(sabjiOrder.getTimeSlot());
				details.add(invoiceDetails);
			}			
			  tx.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.warn(e.getMessage());
			if (tx!=null) tx.rollback();
		}finally {
	         session.close(); 
	     }
	 return details;	 
	 }
	 public String updateInvoiceDetails(UpdateInvoice updateInvoice){
		 String message="";
		 Session session = sessionFactory.openSession();		 
	      Transaction tx = null;
	      try {
			tx = session.beginTransaction();
			int count= session.createSQLQuery("update sabji_order set order_status='C',order_feedback='"+updateInvoice.getReasonTocancel()+"' where order_id="+updateInvoice.getOrderId()+"").executeUpdate();
			if(count>0){
				message="update";	
			}else{
				message="NoDataFound";
			}
			  tx.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			message="DB Error";
			if (tx!=null) tx.rollback();
		}finally {
	         session.close(); 
	     }
	 return message;
	 }
	 public SabjiLocation getzipcodeDetails(int zipcode){
		 String message="";
		 
		 Session session = sessionFactory.openSession();		 
	      Transaction tx = null;
	      SabjiLocation sabjiLocation=null;
	      try {
			tx = session.beginTransaction();
			///Query prod=session.createQuery("from SabjiLocation where zipcode:=zipcode ");
			Query prod=session.createQuery("from SabjiLocation where zipcode=:zipcode");
			prod.setParameter("zipcode", zipcode);	
			sabjiLocation=(SabjiLocation) prod.uniqueResult();			
		   tx.commit();	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.warn(e.getMessage());
			
		if (tx!=null) tx.rollback();
		
		}finally {
	         session.close(); 
	     }
		 
	return sabjiLocation;	 
	 }
	 
	 public ProductDetails getproduct(int orderid){
		    List<DeliverOrderProduct> deliverOrderProductList = new ArrayList<DeliverOrderProduct>();
		    List<ReturnOrderProduct> returnOrderProductList = new ArrayList<ReturnOrderProduct>();
		    ProductDetails productDetails=new ProductDetails();
		    Session session = sessionFactory.openSession();
		    Transaction tx = null;
		    ///List<SabjiOrderProduct> list=null;
		    List<SabjiOrder> list=null;
		    List<Object[]> productListDetails= null;
		    String sql="";
			try {
				tx = session.beginTransaction();
				sql="select order_id,order_product_id,order_product_code,order_product_name,order_product_price,product_id,order_product_quantity,brand_name,item_return from sabji_order_product where order_id="+orderid+"";
				
				SQLQuery query = session.createSQLQuery(sql);
				
				productListDetails=query.list();
				if(productListDetails!=null && productListDetails.size()!=0){
					DecimalFormat df = new DecimalFormat("0.00##");
					for (Object[] row : productListDetails) {
						Boolean returnDetails=row[8]!= null ? (Boolean)row[8] : false;
						if(!returnDetails){
							DeliverOrderProduct deliverOrderProduct=new DeliverOrderProduct();	
							deliverOrderProduct.setOrderId(row[0]!= null ? (Integer)row[0] : 0);
							deliverOrderProduct.setOrderProductId(row[1]!= null ? (Integer)row[1] : 0);
							deliverOrderProduct.setOrderProductCode(row[2]!= null ? (String)row[2] : "");
							deliverOrderProduct.setOrderProductName(row[3]!= null ? (String)row[3] : "");
							deliverOrderProduct.setOrderProductPrice(row[4]!= null ? df.format(row[4])  : "");
							deliverOrderProduct.setProductId(row[5]!= null ? (Integer)row[5] : 0);
							deliverOrderProduct.setOrderProductQuantity(row[6]!= null ? (String)row[6] : "");
							deliverOrderProduct.setBrandName(row[7]!= null ? (String)row[7] : "");
							deliverOrderProductList.add(deliverOrderProduct);	
						}else{
							
							ReturnOrderProduct returnOrderProduct=new ReturnOrderProduct();	
							returnOrderProduct.setOrderId(row[0]!= null ? (Integer)row[0] : 0);
							returnOrderProduct.setOrderProductId(row[1]!= null ? (Integer)row[1] : 0);
							returnOrderProduct.setOrderProductCode(row[2]!= null ? (String)row[2] : "");
							returnOrderProduct.setOrderProductName(row[3]!= null ? (String)row[3] : "");
							returnOrderProduct.setOrderProductPrice(row[4]!= null ? df.format(row[4])  : "");
							returnOrderProduct.setProductId(row[5]!= null ? (Integer)row[5] : 0);
							returnOrderProduct.setOrderProductQuantity(row[6]!= null ? (String)row[6] : "");
							returnOrderProduct.setBrandName(row[7]!= null ? (String)row[7] : "");
							returnOrderProductList.add(returnOrderProduct);
						}
						
					}
					
					productDetails.setDeliverOrderProduct(deliverOrderProductList);
					productDetails.setReturnOrderProduct(returnOrderProductList);
				}
				
		
				
			  tx.commit();	
			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				logger.warn(e.getMessage());
	         if (tx!=null) tx.rollback();
				
			}finally {
		         session.close(); 
		     }
		    
		 return  productDetails;  
		 }
	 
	    @Override
		public List<Product> getSearch(String searchValue) {
			 List<Product> product=new ArrayList<Product>();
			 logger.info("Global Search Happening");
			 ConcurrentHashMap<Integer , String> myMap = new ConcurrentHashMap<Integer , String>(); 
			 
			 Session session = sessionFactory.openSession();
		      Transaction tx = null;
		      List<CentralProduct> list =null;
		      
		      try {
				tx = session.beginTransaction();
				   List<Object[]> listMap=session.createSQLQuery("select * from sabji_quantity").list();
					for (Object[] objects : listMap) {
						
						myMap.put((Integer)objects[1], (String)objects[2]);
						
					}
				   
					/////list=session.createQuery("from CentralProduct where categoryId=:id").list();
			
						Query prod=session.createQuery("from CentralProduct where productName like :searchValue ORDER BY productCode ASC ");
						prod.setParameter("searchValue", "%"+searchValue+"%");
						prod.setFirstResult(0);
						prod.setMaxResults(12);
						list=prod.list();
							
					
					
					for (CentralProduct centralProduct : list) {
						DecimalFormat df = new DecimalFormat("0.000##");
						if(centralProduct.getProductWeight()!=null && (centralProduct.getProductWeight().compareTo(new BigDecimal(0)))>0){	
							
							Product productDetails=new Product();
							productDetails.setProductId(centralProduct.getProductId());
							productDetails.setProductCode(centralProduct.getProductCode());
							productDetails.setProductName(centralProduct.getProductName());
							productDetails.setBrandname(centralProduct.getBrandname());
						    List<CentralPrice>	centralPrice=centralProduct.getCentralPrices();
							for (CentralPrice centralPrice2 : centralPrice) {
								productDetails.setPrice(centralPrice2.getPriceValue());
								productDetails.setPriceMinQuantity(centralPrice2.getPriceMinQuantity());
								
								List<QuantityList> listQuantity=getQuantityList(centralPrice2.getPriceMinQuantity(),myMap);
		                       
								productDetails.setQuantityList(listQuantity);
							}
							
							product.add(productDetails);
							
						}
						}
						
				
					
					  tx.commit();	
					
					
			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				logger.warn(e.getMessage());
				if (tx!=null) tx.rollback();
			}finally {
		         session.close(); 
		     }
			 
			 
			 
			return product;
		}
	 
}
