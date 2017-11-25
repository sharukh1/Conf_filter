/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MusicDataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Inspiron
 */
public class DbConnect {
    static Connection con = null;

    public static Connection server() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/music", "root", "root");

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DbConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }

    public DbConnect() {
        System.out.println("connection extablished");
    }
    
    
   public int check(String username){
       String un = username;
       ResultSet rs=null;
       int i=0;
        try {
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery("select * from login where username='" + un + "'");
         while(rs.next()){
            i++;
        }
        } catch (SQLException ex) {
            Logger.getLogger(DbConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       return i;
   }
   
   public int login_enter(String username,String password){
       String un = username;
       String p = password;
       int rs = 0;
       try {
            Statement stmt = con.createStatement();
            rs = stmt.executeUpdate("insert into login (idlogin,username,password,type) values(0,'"+un+"','"+p+"','user')");
        } catch (SQLException ex) {
            Logger.getLogger(DbConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
       return rs;
   }
    
    
    public int register(String name,int age,String gender,String country,String username){
       int rs = 0;
        try {
            String n=name;
            int a=age;
            String g=gender;
            String c=country;
            String un=username;
            
            
            Statement stmt = con.createStatement();
            rs = stmt.executeUpdate("insert into register (idregister,idlogin,name,age,gender,idcountry) values(0,(select idlogin from login where username='" + un + "'),'"+n+"','"+a+"','"+g+"',(select idcountry from country where cname='"+c+"'))");
        } catch (SQLException ex) {
            Logger.getLogger(DbConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rs;
    }
    
     public int login(String username,String password){
       String un = username;
       String p = password;
       ResultSet rs=null;
       int i=0;
        try {
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery("select * from login where username='" + un + "' and password='"+p+"'");
         while(rs.next()){
            i++;
        }
        } catch (SQLException ex) {
            Logger.getLogger(DbConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       return i;
   }
     
     public int movie(String n, String d, String t, String l) {
         String name=n;
         String description = d;
         String duration = t;
         String language = l;
        int rs = 0;
        try {

            Statement stmt = con.createStatement();
            rs = stmt.executeUpdate("insert into movie (idmovie,mname,description,mduration,idlanguage) values(0,'" + name + "','" + description + "','" + duration + "',(select idlanguage from language where lname='" + language + "'))");
        } catch (SQLException ex) {
            Logger.getLogger(DbConnect.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;
    }
     
     public int songs(String n,String m, String d, String s, String p) {
         String name=n;
         String mn=m;
         String duration = d;
         String singer = s;
         String path = p;
        int rs = 0;
        try {

            Statement stmt = con.createStatement();
            rs = stmt.executeUpdate("insert into song (idsong,idmovie,sname,sduration,singer,path) values(0,(select idmovie from movie where mname='" + mn + "'),'" + name + "','" + duration + "','" + singer + "','"+ path+"')");
        } catch (SQLException ex) {
            Logger.getLogger(DbConnect.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;
    }
     
     
         public ResultSet getSongName() {
        ResultSet rs = null;
        try {

            Statement stmt = con.createStatement();
            rs = stmt.executeQuery("select mname from movie");
        } catch (SQLException ex) {
            Logger.getLogger(DbConnect.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;
    }

    public Map getSongList(String l) {
        String language = l;
        ResultSet rs = null;
        ResultSet rs1 = null;
        ResultSet rs2 = null;
        int idm = 0;
        int idlang = 0;
        Map<Integer, String> map = new HashMap<>();
         Map<String, ResultSet> map2 = new HashMap<>();
        String mname = null;
        try {

            Statement stmt = con.createStatement();

            rs1 = stmt.executeQuery("select idlanguage from language where lname='" + language + "'");
            while (rs1.next()) {
                idlang = rs1.getInt(1);
            }
            System.out.println("   >>" + idlang);

            rs2 = stmt.executeQuery("select idmovie,mname from movie where idlanguage='" + idlang + "'");
            while (rs2.next()) {
                idm = rs2.getInt(1);
                mname = rs2.getString(2);
                System.out.println("m" + idm + "n" + mname);
                map.put(idm, mname);
                

            }
            System.out.println("new " + map);
            for (Map.Entry<Integer, String> e : map.entrySet()) {
                String name = e.getValue();
                int id = e.getKey();
                Statement stmt1 = con.createStatement();
                rs = stmt.executeQuery("select sname,sduration,singer,path from song where idmovie='" + id + "'");
                map2.put(name, rs);
}
            System.out.println("last "+map2);
        } catch (SQLException ex) {
            Logger.getLogger(DbConnect.class.getName()).log(Level.SEVERE, null, ex);
        }

          return  map2;
    }

}
