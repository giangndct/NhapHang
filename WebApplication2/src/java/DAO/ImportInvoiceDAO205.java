/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.ImportInvoice205;
import Entity.ImportInvoiceAccessary205;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class ImportInvoiceDAO205 extends DAO {

    public ImportInvoiceDAO205() {
        super();
    }

    public boolean addImportInvoice(ImportInvoice205 importInvoice) {
        String sqlAddImportInvoice = "INSERT INTO tblimportinvoice205 (createdDate,totalMoney, tblUserId, tblSupplierId) VALUES(?,?,?,?);";
        String sqlAddImportInvoiceAccessary = "INSERT INTO tblimportinvoiceaccessary205 (amount, price, tblImportInvoice205, tblAccessary205) VALUES(?,?,?,?);";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        try {
            if (importInvoice.getListAccessarys().size() == 0) {
                return false;
            }
            PreparedStatement ps = connection.prepareStatement(sqlAddImportInvoice, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, sdf.format(new Date()));
            ps.setFloat(2, (float) importInvoice.getTotalMoney());
            ps.setInt(3, importInvoice.getUser().getId());
            ps.setInt(4, importInvoice.getSupplier().getId());
            
            ps.executeUpdate();
            
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                importInvoice.setId(generatedKeys.getInt(1));
               
                for (ImportInvoiceAccessary205 br : importInvoice.getListAccessarys()) {
                    ps
                            = connection.prepareStatement(sqlAddImportInvoiceAccessary,
                                    Statement.RETURN_GENERATED_KEYS);
                    ps.setInt(1, br.getAmount());
                    ps.setFloat(2, (float) br.getPrice());
                    ps.setInt(3, importInvoice.getId());
                    ps.setInt(4, br.getAccessary().getId());
                    ps.executeUpdate();
                    generatedKeys = ps.getGeneratedKeys();
                    if (generatedKeys.next()) {
                        br.setId(generatedKeys.getInt(1));
                    }
                }
                return true;
            }
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
