package com.example.fundtransfer.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="User")
public class User extends Perpetual {

    @Column
    @Access(AccessType.FIELD)

    private  String name;

     @Column
     @Access(AccessType.FIELD)
     private String address;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Column
     @Access(AccessType.FIELD)
     private Date date;

     @Column
     @Access(AccessType.FIELD)
    private int age;


    public double getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(double accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Column
    @Access(AccessType.FIELD)
    private double accountNumber;

   /* public Set<UserTran> getUserTrans() {
        return userTrans;
    }

    public void setUserTrans(Set<UserTran> userTrans) {
        this.userTrans = userTrans;
    }*/

    @Column
    // @NaturalId
    @Access(AccessType.FIELD)
    private String email;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


   /* @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="EMPLOYEE_ID")
    private Set<UserTran> userTrans;
*/
     @Column
     @Access(AccessType.FIELD)
     private int phone;

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    @Column
    @Access(AccessType.FIELD)
    private long amount;


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }



    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

}
