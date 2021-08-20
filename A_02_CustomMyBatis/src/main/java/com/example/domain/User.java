package com.example.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Avarice
 * <p>
 * 用户持久层接口
 */
public class User implements Serializable {
    private Integer ID;
    private String USERNAME;
    private Date BIRTHDAY;
    private String SEX;
    private String ADDRESS;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getUSERNAME() {
        return USERNAME;
    }

    public void setUSERNAME(String USERNAME) {
        this.USERNAME = USERNAME;
    }

    public Date getBIRTHDAY() {
        return BIRTHDAY;
    }

    public void setBIRTHDAY(Date BIRTHDAY) {
        this.BIRTHDAY = BIRTHDAY;
    }

    public String getSEX() {
        return SEX;
    }

    public void setSEX(String SEX) {
        this.SEX = SEX;
    }

    public String getADDRESS() {
        return ADDRESS;
    }

    public void setADDRESS(String ADDRESS) {
        this.ADDRESS = ADDRESS;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + ID +
                ", username='" + USERNAME + '\'' +
                ", birthday=" + BIRTHDAY +
                ", sex='" + SEX + '\'' +
                ", address='" + ADDRESS + '\'' +
                '}';
    }
}
