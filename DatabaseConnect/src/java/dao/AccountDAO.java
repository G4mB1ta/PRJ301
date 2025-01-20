/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;


import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Account;

/**
 *
 * @author kminh
 */

public class AccountDAO {
    
    public static ArrayList<Account> getAccounts() {
        DBContext db = DBContext.getInstance();

        ArrayList<Account> accounts = new ArrayList<>();

        try {
            String sql = """
                SELECT * FROM Accounts
                """;
            
            PreparedStatement statement = db.getConnection().prepareStatement(sql);
            ResultSet rs =  statement.executeQuery();
            while (rs.next()) {
                Account account = new Account(
                    rs.getString("accountId"),
                    rs.getString("password"),
                    rs.getInt("roleId"));
                accounts.add(account);
            }

        } catch (SQLException e) {
            return null;
        }

        if (accounts.isEmpty()) {
            return null;
        }
        else {
            return accounts;
        }
    }
}
