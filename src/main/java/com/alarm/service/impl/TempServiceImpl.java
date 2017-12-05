package com.alarm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alarm.dao.TempDao;
import com.alarm.entity.Temp;
import com.alarm.service.TempService;

@Service
public class TempServiceImpl implements TempService {

	@Autowired
	private TempDao tempDao;

	public List<Temp> getAllTemp() {
		// TODO Auto-generated method stub
		List<Temp> list = tempDao.getAllTemp();
		return list;
	}

	public Temp getTempByName(String name) {
		// TODO Auto-generated method stub
		Temp tmp = tempDao.getTempByName(name);
		return tmp;
	}

	public void addTemp(Temp temp) {
		// TODO Auto-generated method stub
		tempDao.addTemp(temp);
	}

	public void deleteTemp(Temp temp) {
		// TODO Auto-generated method stub
		tempDao.deleteTemp(temp);
	}

	public List<String> findTempByType(Boolean type) {
		return tempDao.findTempByType(type);
	}

	//根据模板ID查询具体的信息
	public Temp getTempByID(Integer id) {
		return tempDao.getTempByID(id);
	}
}
