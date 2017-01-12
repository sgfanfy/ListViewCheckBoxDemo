package com.fanfy.listviewcheckbox;

import java.io.Serializable;

/**
 * 功能：
 */
public class Person implements Serializable {
    private String Title; //每条item的数据
    private boolean isChecked; //每条item的状态

    public Person(String title) {
        Title = title;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }


    //    private boolean checkStatus;
//
//
//    public Person(String title,boolean ) {
//        Title = title;
//        this.checkStatus = false;
//    }
//
//    public String getTitle() {
//        return Title;
//    }
//
//    public void setTitle(String title) {
//        Title = title;
//    }
//
//    public boolean getCheckStatus() {
//        return checkStatus;
//    }
//
//    public void setCheckStatus(boolean checkStatus) {
//        this.checkStatus = checkStatus;
//    }
}
