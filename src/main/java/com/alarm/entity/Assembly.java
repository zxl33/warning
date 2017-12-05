/**
 * @(#)Assembly.java 2017年8月7日
 * 
 * Copyright 2000-2017 by ChinanetCenter Corporation.
 *
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ChinanetCenter Corporation ("Confidential Information").  You
 * shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement
 * you entered into with ChinanetCenter.
 * 
 */

package com.alarm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 张小莲
 * @date 2017年8月7日
 * @version $Revision$
 */
@Entity
@Table(name = "assembly")
public class Assembly {
	private Integer id;
	private String zhName;
	private String enName;
	private String leaderName;
	private String leaderEmail;
	//0-false-无，1-true-有
	private Integer moveEmail;
	private Integer moveNote;
	private Integer moveApp;
	private Integer moveSignal;
	private Integer emailModelID;
	private Integer noteModelID;

	@Id
	@Column(name = "assembly_id", unique = true) //主键，唯一
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "zh_name", unique = true) //中文名唯一
	public String getZhName() {
		return zhName;
	}

	public void setZhName(String zhName) {
		this.zhName = zhName;
	}

	@Column(name = "en_name")
	public String getEnName() {
		return enName;
	}

	public void setEnName(String enName) {
		this.enName = enName;
	}

	@Column(name = "leader_name")
	public String getLeaderName() {
		return leaderName;
	}

	public void setLeaderName(String leaderName) {
		this.leaderName = leaderName;
	}

	@Column(name = "leader_email")
	public String getLeaderEmail() {
		return leaderEmail;
	}

	public void setLeaderEmail(String leaderEmail) {
		this.leaderEmail = leaderEmail;
	}

	@Column(name = "move_email") //是否邮件允许邮件提醒
	public Integer getMoveEmail() {
		return moveEmail;
	}

	public void setMoveEmail(Integer moveEmail) {
		this.moveEmail = moveEmail;
	}

	@Column(name = "move_note") //是否邮件允许短信提醒
	public Integer getMoveNote() {
		return moveNote;
	}

	public void setMoveNote(Integer moveNote) {
		this.moveNote = moveNote;
	}

	@Column(name = "move_app") //是否邮件允许APP提醒,保留项
	public Integer getMoveApp() {
		return moveApp;
	}

	public void setMoveApp(Integer moveApp) {
		this.moveApp = moveApp;
	}

	@Column(name = "move_signal") //是否邮件允许公众号提醒，保留项
	public Integer getMoveSignal() {
		return moveSignal;
	}

	public void setMoveSignal(Integer moveSignal) {
		this.moveSignal = moveSignal;
	}

	@Column(name = "email_model_id") //邮件模板id
	public Integer getEmailModelID() {
		return emailModelID;
	}

	public void setEmailModelID(Integer emailModelID) {
		this.emailModelID = emailModelID;
	}

	@Column(name = "note_model_id") //短信模板id
	public Integer getNoteModelID() {
		return noteModelID;
	}

	public void setNoteModelID(Integer noteModelID) {
		this.noteModelID = noteModelID;
	}

}
