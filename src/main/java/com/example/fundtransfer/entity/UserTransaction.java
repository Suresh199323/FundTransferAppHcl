package com.example.fundtransfer.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="UserTran")
public class UserTransaction extends Perpetual {


    @Column
    @Access(AccessType.FIELD)
    private  String email;

    @Column
    @Access(AccessType.FIELD)
    private String name;

    @Column
    @Access(AccessType.FIELD)
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Column
    @Access(AccessType.FIELD)
    private int age;

    @Column
    @Access(AccessType.FIELD)
    private String address;

    public double getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(double accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Column
    @Access(AccessType.FIELD)
    private double accountNumber;

    public Long getTransAmount() {
        return transAmount;
    }



    public void setTransAmount(Long transAmount) {
        this.transAmount = transAmount;
    }

    @Column
    @Access(AccessType.FIELD)
    private Long transAmount;

    /*@ManyToOne
    private User user;*/



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



   /* public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }*/



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
