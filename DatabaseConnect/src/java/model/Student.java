/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author kminh
 */
public class Student {

    private String rollNumber;
    private String firstName;
    private String lastName;
    private String date;
    private String gender;
    private String english1;
    private String english2;
    private String english3;
    private String english4;
    private int specId;

    public Student() {
    }

    public Student(String rollNumber, String firstName, String lastName, String date, String gender, String english1, String english2, String english3, String english4, int specId) {
        this.rollNumber = rollNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.date = date;
        this.gender = gender;
        this.english1 = english1;
        this.english2 = english2;
        this.english3 = english3;
        this.english4 = english4;
        this.specId = specId;
    }
    
    public Student(String rollNumber, String firstName, String lastName, Date date, String gender, String english1, String english2, String english3, String english4, int specId) {
        this.rollNumber = rollNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.date = date.toString();
        this.gender = gender;
        this.english1 = english1;
        this.english2 = english2;
        this.english3 = english3;
        this.english4 = english4;
        this.specId = specId;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEnglish1() {
        return english1;
    }

    public void setEnglish1(String english1) {
        this.english1 = english1;
    }

    public String getEnglish2() {
        return english2;
    }

    public void setEnglish2(String english2) {
        this.english2 = english2;
    }

    public String getEnglish3() {
        return english3;
    }

    public void setEnglish3(String english3) {
        this.english3 = english3;
    }

    public String getEnglish4() {
        return english4;
    }

    public void setEnglish4(String english4) {
        this.english4 = english4;
    }

    public int getSpecId() {
        return specId;
    }

    public void setSpecId(int specId) {
        this.specId = specId;
    }
    
    

}
