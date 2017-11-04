package com.suyoga.subjee.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.suyoga.subjee.dao.CategoryDao;
import com.suyoga.subjee.json.Category;
import com.suyoga.subjee.model.CentralCategory;
import com.suyoga.subjee.model.CentralSubcategory;

@Repository
public class CategoryDaoImpl implements CategoryDao {
	private static final Logger logger = Logger.getLogger(CategoryDaoImpl.class);	
	@Autowired
	 SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Category> getCategory(int categoryid) {
		 List<Category>	categoryList=new ArrayList<Category>();
		 Session session = sessionFactory.openSession();
	      Transaction tx = null;
		  List<CentralCategory> category=null;
		  CentralCategory centralCat=null;
	  	   try {
			tx = session.beginTransaction();
			if(categoryid==0){
				category=session.createQuery("from CentralCategory").list();
				
				for (CentralCategory centralCategory : category) {
					List<CentralSubcategory> centralSubcategories=centralCategory.getCentralSubcategories();
					Category categoryJson=new Category();
					categoryJson.setCategoryName(centralCategory.getCategoryName());
					categoryJson.setId(centralCategory.getCategoryId());
					categoryJson.setCategoryDescription(centralCategory.getCategoryDescription());
					if(!centralSubcategories.isEmpty()){
					 categoryJson.setSubId(centralCategory.getCategoryId());
					}
					categoryList.add(categoryJson);
				}	
			}else{
				
				Query prod=session.createQuery("from CentralCategory where categoryId=:id");
				prod.setParameter("id", categoryid);
				centralCat=(CentralCategory) prod.uniqueResult();
				List<CentralSubcategory> centralSubcategories=centralCat.getCentralSubcategories();
				for (CentralSubcategory centralSubcategory : centralSubcategories) {
					Category categoryJson=new Category();	
					categoryJson.setCategoryName(centralSubcategory.getSubcategoryName());
					categoryJson.setId(centralCat.getCategoryId());
					categoryJson.setCategoryDescription(centralSubcategory.getSubcategoryDescription());
					categoryJson.setSubId(centralSubcategory.getSubcategoryId());
					categoryList.add(categoryJson);
				}
				
			}
			
			   tx.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			if (tx!=null) tx.rollback();
			e.printStackTrace();
			logger.warn(e.getMessage());
		}finally {
	         session.close(); 
	     }	
		return categoryList;
	}
	
	
	
}
