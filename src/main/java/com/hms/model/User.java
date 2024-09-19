package com.hms.model;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Getter
@Setter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int mid;

    private String username;
    private String password;
    private String fullName;
    private String phone;
    private int age;
    private String sex;
    private String address;
    private String userType;

    // Default constructor
    public User() { }

    // Constructor with phone only
    public User(String phone) {
        this.phone = phone;
    }

    // Constructor with all fields
    public User(String username, String password, String fullName, String phone, int age, String sex, String address, String userType) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.phone = phone;
        this.age = age;
        this.sex = sex;
        this.address = address;
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "User{" +
                "phone='" + phone + '\'' +
                ", fullName='" + fullName + '\'' +
                '}';
    }
    //    @Override
////    public String toString() {
////        return "User{" +
////                "username='" + username + '\'' +
////                ", fullName='" + fullName + '\'' +
////                ", phone='" + phone + '\'' +
////                ", age=" + age +
////                ", sex=" + sex +
////                ", address='" + address + '\'' +
////                ", userType='" + userType + '\'' +
////                '}';
////    }


}
