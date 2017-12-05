package com.alarm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 梁敏聪
 * @date 2017年8月12日
 * @version $Revision$
 */
@Entity
@Table(name = "model")
public class Temp {

	private Integer temp_id;
	private String name;
	private String content;
	private Boolean type;

	@Id
	@GeneratedValue
	@Column(name = "model_id")
	public Integer getTemp_id() {
		return temp_id;
	}

	public void setTemp_id(Integer temp_id) {
		this.temp_id = temp_id;
	}

	@Column(name = "model_name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "model_content")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "model_type")
	public Boolean getType() {
		return type;
	}

	public void setType(Boolean type) {
		this.type = type;
	}

}
