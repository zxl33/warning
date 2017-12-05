package com.alarm.controller;

import com.alarm.dao.*;
import com.alarm.entity.Manager;
import com.alarm.entity.Temp;
import com.alarm.helper.AddManager;
import com.alarm.helper.DelManagerData;
import com.alarm.helper.DelTemp;
import com.alarm.helper.PageIndex;
import com.alarm.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import com.gdui.test.service.ManagerDaoImpl;


@Controller
@RequestMapping(value = "/manager")
public class AlertController {
    @Autowired
    private ManagerService managerService;
    @Autowired
    private ManagerDao managerDao;
    @Autowired
    private TempDao tempDao;
    @Autowired
    private TempService tempService;

//    private ManagerDaoImpl managerDaoImpl;

    private ArrayList<Manager> managers = new ArrayList<Manager>();
    private ArrayList<Temp> tempss = new ArrayList<Temp>();
    @RequestMapping(value = "/manager")
    public String Manager() {
        //业务逻辑处理
        return "/manager";
    }

//    @RequestMapping(value = "manager.data")
//    @ResponseBody
//    public ArrayList<Manager> returnManager() {
//        //业务逻辑处理
//        Manager manager1 = new Manager();
//        manager1.setName("1");manager1.setEmail("1");manager1.setPassword("1");
//        this.managers.add(manager1);
//        return this.managers;
//    }
    @RequestMapping(value = "/manager.data")
    @ResponseBody
    public Map<String, Object> returnManager(PageIndex pageIndex) {
        //业务逻辑处理
        ArrayList<Manager> resData = new ArrayList<Manager>();
        List allData = new ArrayList<Manager>();
        allData = managerDao.getAllManager();
        if (allData.size() == 0) {
            return null;
        }
        for (int i=pageIndex.getStart();i<pageIndex.getStart()+pageIndex.getLimit() && i < allData.size();i++) {
//            System.out.println(2);
            resData.add((Manager)(allData.get(i)));
        }
        Map<String , Object> map = new HashMap<String , Object>();
//        map.put("rows",allData.subList(pageIndex.getStart(),pageIndex.getLimit()));
        map.put("rows",resData);
        map.put("results",allData.size());
        map.put("hasError" , false); //是否存在错误)
        return map;
    }

//    @RequestMapping(value = "manager.getData", method = RequestMethod.POST)
//    @ResponseBody
//    public HashMap<String,Object> returnManager1(PageIndex pageIndex) {
//        //业务逻辑处理
//        Integer beginIndex = pageIndex.getLimit()*pageIndex.getPageIndex();
//        ArrayList<Manager> returnManagers = new ArrayList<Manager>();
//        HashMap<String , Object> map = new HashMap<String , Object>();
//        if (this.managers.size() < pageIndex.getLimit()) {
//            map.put("rows",this.managers);
//            map.put("results",this.managers.size());
//            map.put("hasError" , false); //是否存在错误)
//            return map;
//        }
//        for (Integer i = beginIndex;i< pageIndex.getLimit() && i < this.managers.size();i++) {
//            returnManagers.add(this.managers.get(i));
//        }
//        map.put("rows",returnManagers);
//        map.put("results",this.managers.size());
//        map.put("hasError" , false); //是否存在错误)
////        System.out.println(returnManagers.get(1));
//        return map;
//    }

//    @RequestMapping(value = "manager.getData.void", method = RequestMethod.POST)
//    @ResponseBody
//    public ArrayList<Manager> returnManager2() {
//        //业务逻辑处理
//        return  this.managers;
//        }
    @RequestMapping(value = "/manager.getData.void", method = RequestMethod.POST)
    @ResponseBody
    public List returnManager2() {
        //业务逻辑处理
        List allData = new ArrayList<Manager>();
        allData = managerDao.getAllManager();
        return  allData;
        }


//    @RequestMapping(value = "manager.delData", method = RequestMethod.POST)
//    @ResponseBody
//    public HashMap<String,Object> returnDelManager(DelData delData) {
//        //业务逻辑处理
//        for (int i = 0; i < managers.size(); i++) {
//            if (managers.get(i).getName().equals(delData.getDel())) {
//                this.managers.remove(i);
//                break;
//            }
//        }
//        Integer beginIndex = Integer.parseInt(delData.getLimit())*Integer.parseInt(delData.getPageIndex());
//        ArrayList<Manager> returnManagers = new ArrayList<Manager>();
//        HashMap<String , Object> map = new HashMap<String , Object>();
//        if (this.managers.size() < Integer.parseInt(delData.getLimit())) {
//            map.put("rows",this.managers);
//            map.put("results",this.managers.size());
//            map.put("hasError" , false); //是否存在错误)
//            return map;
//        }
//        for (Integer i = beginIndex;i< beginIndex+Integer.parseInt(delData.getLimit()) && i < this.managers.size();i++) {
//            returnManagers.add(this.managers.get(i));
//        }
//        map.put("rows",returnManagers);
//        map.put("results",this.managers.size());
//        map.put("hasError" , false); //是否存在错误)
////        System.out.println(returnManagers.get(1));
//        return map;
//    }

    @RequestMapping(value = "/manager.delData", method = RequestMethod.POST)
    @ResponseBody
    public HashMap<String,Object> returnDelManager(DelManagerData delManagerData) {
        //业务逻辑处理
        Manager deleted = (Manager)(managerDao.getManagerByName(delManagerData.getDel()));
        System.out.println(deleted.getPassword());
        if (deleted != null) {
            managerService.deleteManager(deleted);
        }
        List allData = new ArrayList<Manager>();
        allData = managerService.getAllManager();
        Integer beginIndex = Integer.parseInt(delManagerData.getLimit())*Integer.parseInt(delManagerData.getPageIndex());
        ArrayList<Manager> returnManagers = new ArrayList<Manager>();
        HashMap<String , Object> map = new HashMap<String , Object>();
        if (allData.size() < Integer.parseInt(delManagerData.getLimit())) {
            map.put("rows",allData);
            map.put("results",allData.size());
            map.put("hasError" , false); //是否存在错误)
            return map;
        }
        for (Integer i = beginIndex;i< beginIndex+Integer.parseInt(delManagerData.getLimit()) && i < allData.size();i++) {
            returnManagers.add((Manager) (allData.get(i)));
        }
        map.put("rows",returnManagers);
        map.put("results",this.managers.size());
        map.put("hasError" , false); //是否存在错误)
//        System.out.println(returnManagers.get(1));
        return map;
    }

    @RequestMapping(value = "/manager.addData", method = RequestMethod.POST)
    @ResponseBody
    public HashMap<String,Object> returnAddManager(AddManager addManager) {
        //业务逻辑处理
        Manager manager = new Manager();
        manager.setName(addManager.getName());
        manager.setEmail(addManager.getEmail());
        manager.setPassword(addManager.getPassword());
        managerService.addManager(manager);
        Integer beginIndex = Integer.parseInt(addManager.getLimit())*Integer.parseInt(addManager.getPageIndex());
        ArrayList<Manager> returnManagers = new ArrayList<Manager>();
        HashMap<String , Object> map = new HashMap<String , Object>();
        List allData = managerDao.getAllManager();
        for (Integer i = beginIndex;i< beginIndex+Integer.parseInt(addManager.getLimit()) && i < allData.size();i++) {
            returnManagers.add((Manager) (allData.get(i)));
        }
        map.put("rows",returnManagers);
        map.put("results",allData.size());
        map.put("hasError" , false); //是否存在错误)
//        System.out.println(returnManagers.get(1));
        return map;
    }

    @RequestMapping(value = "/notification")
    public String notification() {
        return "/notificationTemplate";
    }

    @RequestMapping(value = "/notification.data", method = RequestMethod.POST)
    @ResponseBody
    public HashMap<String , Object>  returnNotifyTem(PageIndex pageIndex) {
        //业务逻辑处理
        ArrayList<Temp> resData = new ArrayList<Temp>();
        List allData = new ArrayList<Manager>();
        allData = tempDao.getAllTemp();
        if (allData.size() == 0) {
            return null;
        }
        for (int i=pageIndex.getStart();i<pageIndex.getStart()+pageIndex.getLimit() && i < allData.size();i++) {
//            System.out.println(2);
            resData.add((Temp)(allData.get(i)));
        }
        HashMap<String , Object> map = new HashMap<String , Object>();
//        map.put("rows",allData.subList(pageIndex.getStart(),pageIndex.getLimit()));
        map.put("rows",resData);
        map.put("results",allData.size());
        map.put("hasError" , false); //是否存在错误)
        return map;
    }

    @RequestMapping(value = "/notification.del", method = RequestMethod.POST)
    @ResponseBody
    public HashMap<String, Object> delNotifyTem(DelTemp delTemp) {
        //业务逻辑处理
        Temp deleted = tempDao.getTempByName(delTemp.getDel());
        if (deleted != null) {
            tempService.deleteTemp(deleted);
        }
        List allData = tempService.getAllTemp();
        Integer beginIndex = Integer.parseInt(delTemp.getLimit())*Integer.parseInt(delTemp.getPageIndex());
        ArrayList<Temp> returnNotification = new ArrayList<Temp>();
        HashMap<String , Object> map = new HashMap<String , Object>();
        for (Integer i = beginIndex;i< beginIndex+Integer.parseInt(delTemp.getLimit()) && i < allData.size();i++) {
            returnNotification.add((Temp) (allData.get(i)));
        }
        map.put("rows",returnNotification);
        map.put("results",allData.size());
        map.put("hasError" , false); //是否存在错误)
        return map;
    }

    @RequestMapping(value = "/notification.add", method = RequestMethod.POST)
    @ResponseBody
    public void addNotifyTem(Temp temp) {
        //业务逻辑处理
        tempService.addTemp(temp);
    }

    @RequestMapping(value = "/notification.check", method = RequestMethod.POST)
    @ResponseBody
    public Temp checkNotifyTem(Temp temp) {
        //业务逻辑处理
        return tempDao.getTempByName(temp.getName());
//        for (int i=0; i<notifications.size();i++) {
//            if(notification.getName() .equals( notifications.get(i).getName())) {
//                System.out.print(notification.getName());
//                return notifications.get(i);
//            }
//        }
//        return null;
    }

    @RequestMapping(value = "/notification.nameValidate", method = RequestMethod.POST)
    @ResponseBody
    public HashMap<String,Object> returnNotifyTem1(HttpServletRequest request) {
        //业务逻辑处理
        Temp n = (Temp)tempDao.getTempByName(request.getParameter("name"));
        HashMap<String,Object> res = new HashMap<String, Object>();
        if (n == null) {
            res.put("dul",false);
            return res;
        } else {
            res.put("dul", true);
            return res;
        }
    }
}
