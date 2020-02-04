package com.app.cafehideout.ui.login.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Apoorv Vardhman on 03-02-2020
 *
 * @Email :  apoorv.vardhman@gmail.com
 * @Author :  Apoorv Vardhman (developerapoorv.xyz)
 * @Linkedin :  https://in.linkedin.com/in/apoorv-vardhman
 * Contact :  +91 8434014444
 */
public class LoginModel {
    @SerializedName("id")
    private int id;

    @SerializedName("empcode")
    private String empcode;

    @SerializedName("empname")
    private String empname;

    @SerializedName("dob")
    private String dob;

    @SerializedName("gender")
    private String gender;
    @SerializedName("contactno")
    private String contactno;

    @SerializedName("emailid")
    private String emailid;
    @SerializedName("fathername")
    private String fathername;

    public LoginModel(int id, String empcode, String empname, String dob, String gender, String contactno, String emailid, String fathername) {
        this.id = id;
        this.empcode = empcode;
        this.empname = empname;
        this.dob = dob;
        this.gender = gender;
        this.contactno = contactno;
        this.emailid = emailid;
        this.fathername = fathername;
    }

    public int getId() {
        return id;
    }

    public String getEmpcode() {
        return empcode;
    }

    public String getEmpname() {
        return empname;
    }

    public String getDob() {
        return dob;
    }

    public String getGender() {
        return gender;
    }

    public String getContactno() {
        return contactno;
    }

    public String getEmailid() {
        return emailid;
    }

    public String getFathername() {
        return fathername;
    }
}
