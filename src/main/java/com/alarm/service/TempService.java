package com.alarm.service;

import java.util.List;

import com.alarm.entity.Temp;

public interface TempService {

	//模板列表
	public List<Temp> getAllTemp();

	//根据模板名查询具体的信息
	public Temp getTempByName(String name);

	//根据模板ID查询具体的信息
	public Temp getTempByID(Integer id);

	//增加模板
	public void addTemp(Temp temp);

	//删除模板
	public void deleteTemp(Temp temp);

	//根据类型查找模板名列表
	public List<String> findTempByType(Boolean type);

}
