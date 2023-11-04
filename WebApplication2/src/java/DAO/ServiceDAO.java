/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.Service;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class ServiceDAO extends DBContext {
    
    public ServiceDAO() {
    }

    public ArrayList<Service> findServiceByName(String key) {
        ArrayList<Service> result = new ArrayList<>();
        String sql = "SELECT * FROM tblservice205 WHERE name LIKE ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "%" + key + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Service service = new Service();
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
    public Service getService(int id) {
        Service result = new Service();
        String sql = "SELECT * FROM tblservice205 WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Service service = new Service();
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
