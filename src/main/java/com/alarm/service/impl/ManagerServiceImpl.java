package com.alarm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alarm.dao.ManagerDao;
import com.alarm.entity.Manager;
import com.alarm.service.ManagerService;

@Service
public class ManagerServiceImpl implements ManagerService {

	@Autowired
	private ManagerDao managerDao;
	
	public List<Manager> getAllManager() {
		// TODO Auto-generated method stub
		List<Manager> list = managerDao.getAllManager();
		return list;
	}

	public Manager getManagerByName(String name) {
		// TODO Auto-generated method stub
		Manager mg = managerDao.getManagerByName(name);
		return mg;
	}

	public void addManager(Manager manager) {
		// TODO Auto-generated method stub
		managerDao.addManager(manager);
		return ;
	}

	public void deleteManager(Manager manager) {
		// TODO Auto-generated method stub
		managerDao.deleteManager(manager);
		return ;
	}

	public Manager checkManager(Manager manager) {
		// TODO Auto-generated method stub
		Manager mg = managerDao.checkManager(manager);
		return mg;
	}

}
