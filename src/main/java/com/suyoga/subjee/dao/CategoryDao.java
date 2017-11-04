package com.suyoga.subjee.dao;

import java.util.List;

import com.suyoga.subjee.json.Category;

public interface CategoryDao {
	 public List<Category> getCategory(int categoryid);
}
