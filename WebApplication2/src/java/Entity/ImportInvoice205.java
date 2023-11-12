/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class ImportInvoice205{
    private int id;
    private Date createdDate;
    private double totalMoney;
    private Supplier205 supplier;
    private User205 user;
    private ArrayList<ImportInvoiceAccessary205> listAccessarys;

    public ImportInvoice205() {
        this.supplier = new Supplier205();
        this.user = new User205();
        this.listAccessarys = new ArrayList<>();
    }

    public ImportInvoice205(int id, Date createdDate, double totalMoney, Supplier205 supplier, User205 user, ArrayList<ImportInvoiceAccessary205> listAccessarys) {
        this.id = id;
        this.createdDate = createdDate;
        this.totalMoney = totalMoney;
        this.supplier = supplier;
        this.user = user;
        this.listAccessarys = listAccessarys;
    }
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }


    public Supplier205 getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier205 supplier) {
        this.supplier = supplier;
    }

    public User205 getUser() {
        return user;
    }

    public void setUser(User205 user) {
        this.user = user;
    }

    public ArrayList<ImportInvoiceAccessary205> getListAccessarys() {
        return listAccessarys;
    }

    public void setListAccessarys(ArrayList<ImportInvoiceAccessary205> listAccessarys) {
        this.listAccessarys = listAccessarys;
    }
    
    
}   
