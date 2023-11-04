/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.Accessary;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class AccessaryDAO extends DBContext {

    public AccessaryDAO() {
        super();
    }

    public ArrayList<Accessary> findPartByName(String key) {
        ArrayList<Accessary> result = new ArrayList<>();
        String sql = "SELECT * FROM tblaccessary205 WHERE name LIKE ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "%" + key + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Accessary accessary = new Accessary();
                accessary.setId(rs.getInt("id"));
                accessary.setName(rs.getString("name"));
                accessary.setCompany(rs.getString("company"));

                accessary.setDescription(rs.getString("description"));
                accessary.setPrice(rs.getFloat("price"));
                result.add(accessary);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("find:" + result.size());
        return result;
    }

    public Accessary getAccessary(int id) {
        Accessary result = new Accessary();
        String sql = "SELECT * FROM tblaccessary205 WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Accessary accessary = new Accessary();
                accessary.setId(rs.getInt("id"));
                accessary.setName(rs.getString("name"));
                accessary.setCompany(rs.getString("company"));
                accessary.setDescription(rs.getString("description"));
                accessary.setPrice(rs.getFloat("price"));
                result = accessary;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean addAccessary(Accessary accessary) {
        String sql = "INSERT INTO tblaccessary205(name, company, description, price ) VALUES( ?,  ?,  ?,?) ";
        try {
            PreparedStatement ps
                    = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, accessary.getName());
            ps.setString(2, accessary.getCompany());
            ps.setString(3, accessary.getDescription());
            ps.setFloat(4, (float) accessary.getPrice());
            ps.executeUpdate();

            //get id of the new inserted client
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                accessary.setId(generatedKeys.getInt(1));
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
