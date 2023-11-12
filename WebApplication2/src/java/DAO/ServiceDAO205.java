/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.Service205;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class ServiceDAO205 extends DAO {
    
    public ServiceDAO205() {
    }

    public ArrayList<Service205> findServiceByName(String key) {
        ArrayList<Service205> result = new ArrayList<>();
        String sql = "SELECT * FROM tblservice205 WHERE name LIKE ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "%" + key + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Service205 service = new Service205();
                service.setId(rs.getInt("id"));
                service.setName(rs.getString("name"));
                service.setDescription("description");
                result.add(service);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("find:" + result.size());
        return result;
    }
    public Service205 getService(int id) {
        Service205 result = new Service205();
        String sql = "SELECT * FROM tblservice205 WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Service205 service = new Service205();
                service.setId(rs.getInt("id"));
                service.setName(rs.getString("name"));
                service.setDescription(rs.getString("description"));
                result = service;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
