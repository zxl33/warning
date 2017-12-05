package com.alarm.helper;

/**
 * Created by baiqy on 2017/8/3.
 */
public class AddManager {
    private String name = null;
    private String email = null;
    private String password = null;
    private String start = null;
    private String pageIndex = null;
    private String limit = null;

//    public AddManager(String name, String email, String password, String start, String pageIndex) {
//        this.name = name;
//        this.email = email;
//        this.password = password;
//        this.start = start;
//        this.pageIndex = pageIndex;
//    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(String pageIndex) {
        this.pageIndex = pageIndex;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

}
