/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class Supplier{
    private int id;
    private String name,address,phone,bankAccount;

    public Supplier() {
    }

    public Supplier(int id, String name, String address, String phone, String bankAccount) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.bankAccount = bankAccount;
    }

    public Supplier(String name, String address, String phone,String bankAccount) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.bankAccount=bankAccount;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }
    
    
}
