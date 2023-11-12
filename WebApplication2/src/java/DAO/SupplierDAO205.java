/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.Supplier205;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class SupplierDAO205 extends DAO {



    public ArrayList<Supplier205> findSupplierByName(String key) {
        ArrayList<Supplier205> result = new ArrayList<>();
        String sql = "SELECT * FROM tblsupplier205 WHERE name LIKE ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "%" + key + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Supplier205 supplier = new Supplier205();
                supplier.setId(rs.getInt("id"));
                supplier.setName(rs.getString("name"));
                supplier.setPhone(rs.getString("phone"));
                supplier.setAddress(rs.getString("address"));
                supplier.setBankAccount(rs.getString("bankaccount"));
                result.add(supplier);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public Supplier205 getSupplier(int id) {
        Supplier205 result = new Supplier205();
        String sql = "SELECT * FROM tblsupplier205  WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Supplier205 supplier = new Supplier205();
                supplier.setId(rs.getInt("id"));
                supplier.setName(rs.getString("name"));
                supplier.setPhone(rs.getString("phone"));
                supplier.setAddress(rs.getString("address"));
                supplier.setBankAccount(rs.getString("bankaccount"));
                result = supplier;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;

    }

    public boolean addSupplier(Supplier205 supplier) {
        String sql = "INSERT INTO tblsupplier205 (name,address, phone,bankAccount) VALUES(?, ?, ?, ?)";
        try {
            PreparedStatement ps
                    = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, supplier.getName());
            ps.setString(2, supplier.getAddress());
            ps.setString(3, supplier.getPhone());
            ps.setString(4, supplier.getBankAccount());
            ps.executeUpdate();

            //get id of the new inserted client
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                supplier.setId(generatedKeys.getInt(1));
                
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }
}
