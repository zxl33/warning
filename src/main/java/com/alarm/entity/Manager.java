package com.alarm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 张小莲
 * @date 2017年8月12日
 * @version $Revision$
 */
@Entity
@Table(name = "manager")
public class Manager {

	@Id
	@GeneratedValue
	@Column(name = "manager_id")
	private Integer manager_id;
	@Column(name = "manager_name")
	private String name;
	@Column(name = "manager_email")
	private String email;
	@Column(name = "manager_password")
	private String password;

	public Integer getManager_id() {
		return manager_id;
	}

	public void setManager_id(Integer manager_id) {
		this.manager_id = manager_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
