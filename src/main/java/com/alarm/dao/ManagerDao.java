package com.alarm.dao;

import java.util.List;

import com.alarm.entity.Manager;

public interface ManagerDao {

	//管理员列表
	public List<Manager> getAllManager();

	//根据管理员名查询具体的信息
	public Manager getManagerByName(String name);

	//增加管理员
	public void addManager(Manager manager);

	//删除管理员
	public void deleteManager(Manager manager);
	
	//验证登录
	public Manager checkManager(Manager manager);
}
