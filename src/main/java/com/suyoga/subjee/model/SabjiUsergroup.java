package com.suyoga.subjee.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the sabji_usergroups database table.
 * 
 */
@Entity
@Table(name="sabji_usergroups")
@NamedQuery(name="SabjiUsergroup.findAll", query="SELECT s FROM SabjiUsergroup s")
public class SabjiUsergroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int lft;

	@Column(name="parent_id")
	private int parentId;

	private int rgt;

	private String title;

	//bi-directional many-to-one association to SabjiUserUsergroupMap
	@OneToMany(mappedBy="sabjiUsergroup")
	private List<SabjiUserUsergroupMap> sabjiUserUsergroupMaps;

	public SabjiUsergroup() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLft() {
		return this.lft;
	}

	public void setLft(int lft) {
		this.lft = lft;
	}

	public int getParentId() {
		return this.parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public int getRgt() {
		return this.rgt;
	}

	public void setRgt(int rgt) {
		this.rgt = rgt;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<SabjiUserUsergroupMap> getSabjiUserUsergroupMaps() {
		return this.sabjiUserUsergroupMaps;
	}

	public void setSabjiUserUsergroupMaps(List<SabjiUserUsergroupMap> sabjiUserUsergroupMaps) {
		this.sabjiUserUsergroupMaps = sabjiUserUsergroupMaps;
	}

	public SabjiUserUsergroupMap addSabjiUserUsergroupMap(SabjiUserUsergroupMap sabjiUserUsergroupMap) {
		getSabjiUserUsergroupMaps().add(sabjiUserUsergroupMap);
		sabjiUserUsergroupMap.setSabjiUsergroup(this);

		return sabjiUserUsergroupMap;
	}

	public SabjiUserUsergroupMap removeSabjiUserUsergroupMap(SabjiUserUsergroupMap sabjiUserUsergroupMap) {
		getSabjiUserUsergroupMaps().remove(sabjiUserUsergroupMap);
		sabjiUserUsergroupMap.setSabjiUsergroup(null);

		return sabjiUserUsergroupMap;
	}

}