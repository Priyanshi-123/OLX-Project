/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysite;

import static java.lang.Character.UnicodeBlock.forName;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author HP
 */
public class DbConnector {
    public Connection c;
    public DbConnector(){
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            c=DriverManager.getConnection("jdbc:derby://localhost:1527/project");
            System.out.println("Connected successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void display(DbConnector obj){
        try {
            Statement s = obj.c.createStatement();
            ResultSet rs=s.executeQuery("select * from address1");
            System.out.println("Roll No.\t\tStudent Name");
            while(rs.next()){
                System.out.print(rs.getString(1)+"\t\t");
                System.out.println(rs.getString(2));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        DbConnector obj=new DbConnector();
       // obj.display(obj);
    }
}
