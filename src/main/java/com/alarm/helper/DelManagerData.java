package com.alarm.helper;

/**
 * Created by baiqy on 2017/8/2.
 */
public class DelManagerData {
    private String del ;
    private String start;
    private String pageIndex;
    private String limit;

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public String getDel() {
        return del;
    }
    public void setDel(String del) {
        this.del = del;
    }

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
}
