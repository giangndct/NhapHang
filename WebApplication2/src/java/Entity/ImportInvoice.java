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
public class ImportInvoice{
    private int id;
    private Date createdDate;
    private double totalMoney;
    private Supplier supplier;
    private User user;
    private ArrayList<ImportInvoiceAccessary> listAccessarys;

    public ImportInvoice() {
        this.supplier = new Supplier();
        this.user = new User();
        this.listAccessarys = new ArrayList<>();
    }

    public ImportInvoice(int id, Date createdDate, double totalMoney, Supplier supplier, User user, ArrayList<ImportInvoiceAccessary> listAccessarys) {
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


    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList<ImportInvoiceAccessary> getListAccessarys() {
        return listAccessarys;
    }

    public void setListAccessarys(ArrayList<ImportInvoiceAccessary> listAccessarys) {
        this.listAccessarys = listAccessarys;
    }
    
    
}   
