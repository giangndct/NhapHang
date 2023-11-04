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
public class ImportInvoiceAccessary {

    private int id, amount;
    private float price;
    private Accessary accessary;

    public ImportInvoiceAccessary() {
    }

    public ImportInvoiceAccessary(int id, int amount, float price, Accessary accessary) {
        this.id = id;
        this.amount = amount;
        this.price = price;
        this.accessary = accessary;
    }

    public ImportInvoiceAccessary(int amount, float price, Accessary accessary) {
        this.amount = amount;
        this.price = price;
        this.accessary = accessary;
    }

    public ImportInvoiceAccessary(int amount, float price) {
        this.amount = amount;
        this.price = price;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Accessary getAccessary() {
        return accessary;
    }

    public void setAccessary(Accessary accessary) {
        this.accessary = accessary;
    }
    
    

}
