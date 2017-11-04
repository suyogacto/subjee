package com.suyoga.subjee.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the central_file database table.
 * 
 */
@Entity
@Table(name="central_file")
@NamedQuery(name="CentralFile.findAll", query="SELECT c FROM CentralFile c")
public class CentralFile implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="file_id")
	private int fileId;

	@Column(name="file_name")
	private String fileName;

	@Column(name="file_path")
	private String filePath;

	//bi-directional many-to-one association to CentralProduct
	@ManyToOne
	@JoinColumn(name="file_ref_id")
	private CentralProduct centralProduct;

	public CentralFile() {
	}

	public int getFileId() {
		return this.fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return this.filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public CentralProduct getCentralProduct() {
		return this.centralProduct;
	}

	public void setCentralProduct(CentralProduct centralProduct) {
		this.centralProduct = centralProduct;
	}

}