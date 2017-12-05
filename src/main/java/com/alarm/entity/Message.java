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
@Table(name = "message")
public class Message {

	private Integer message_id;
	private Integer assembly_id;
	private Integer continue_time;
	private String last_time;
	private Integer times;
	private String level;
	private String server_type;
	private String service_type;
	private String room;
	private String group;
	private Boolean action;
	private String action_reason;
	private String action_describe;

	@Id
	@Column(name = "message_id")
	@GeneratedValue
	public Integer getMessage_id() {
		return message_id;
	}

	public void setMessage_id(Integer message_id) {
		this.message_id = message_id;
	}

	@Column(name = "assembly_id")
	public Integer getAssembly_id() {
		return assembly_id;
	}

	public void setAssembly_id(Integer assembly_id) {
		this.assembly_id = assembly_id;
	}

	@Column(name = "continue_time")
	public Integer getContinue_time() {
		return continue_time;
	}

	public void setContinue_time(Integer continue_time) {
		this.continue_time = continue_time;
	}

	@Column(name = "last_time")
	public String getLast_time() {
		return last_time;
	}

	public void setLast_time(String last_time) {
		this.last_time = last_time;
	}

	@Column(name = "times")
	public Integer getTimes() {
		return times;
	}

	public void setTimes(Integer times) {
		this.times = times;
	}

	@Column(name = "level")
	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	@Column(name = "server_type")
	public String getServer_type() {
		return server_type;
	}

	public void setServer_type(String server_type) {
		this.server_type = server_type;
	}

	@Column(name = "service_type")
	public String getService_type() {
		return service_type;
	}

	public void setService_type(String service_type) {
		this.service_type = service_type;
	}

	@Column(name = "room")
	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	@Column(name = "group")
	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	@Column(name = "action")
	public Boolean getAction() {
		return action;
	}

	public void setAction(Boolean action) {
		this.action = action;
	}

	@Column(name = "action_reason")
	public String getAction_reason() {
		return action_reason;
	}

	public void setAction_reason(String action_reason) {
		this.action_reason = action_reason;
	}

	@Column(name = "action_describe")
	public String getAction_describe() {
		return action_describe;
	}

	public void setAction_describe(String action_describe) {
		this.action_describe = action_describe;
	}

}
