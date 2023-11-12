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
public class ImportInvoiceAccessary205 {

    private int id, amount;
    private float price;
    private Accessary205 accessary;

    public ImportInvoiceAccessary205() {
    }

    public ImportInvoiceAccessary205(int id, int amount, float price, Accessary205 accessary) {
        this.id = id;
        this.amount = amount;
        this.price = price;
        this.accessary = accessary;
    }

    public ImportInvoiceAccessary205(int amount, float price, Accessary205 accessary) {
        this.amount = amount;
        this.price = price;
        this.accessary = accessary;
    }

    public ImportInvoiceAccessary205(int amount, float price) {
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

    public Accessary205 getAccessary() {
        return accessary;
    }

    public void setAccessary(Accessary205 accessary) {
        this.accessary = accessary;
    }
    
    

}
