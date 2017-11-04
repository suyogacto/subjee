package com.suyoga.subjee.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the sabji_user_usergroup_map database table.
 * 
 */
@Entity
@Table(name="sabji_user_usergroup_map")
@NamedQuery(name="SabjiUserUsergroupMap.findAll", query="SELECT s FROM SabjiUserUsergroupMap s")
public class SabjiUserUsergroupMap implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	//bi-directional many-to-one association to SabjiUser
	@ManyToOne
	@JoinColumn(name="user_id")
	private SabjiUser sabjiUser;

	//bi-directional many-to-one association to SabjiUsergroup
	@ManyToOne
	@JoinColumn(name="group_id")
	private SabjiUsergroup sabjiUsergroup;

	public SabjiUserUsergroupMap() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public SabjiUser getSabjiUser() {
		return this.sabjiUser;
	}

	public void setSabjiUser(SabjiUser sabjiUser) {
		this.sabjiUser = sabjiUser;
	}

	public SabjiUsergroup getSabjiUsergroup() {
		return this.sabjiUsergroup;
	}

	public void setSabjiUsergroup(SabjiUsergroup sabjiUsergroup) {
		this.sabjiUsergroup = sabjiUsergroup;
	}

}