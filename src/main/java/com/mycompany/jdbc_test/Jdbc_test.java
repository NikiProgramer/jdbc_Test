package com.mycompany.jdbc_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;

public class Jdbc_test {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/tes_jdbc";
        String username = "root";
        String password = "";
        
        try {
            Connection conn = DriverManager.getConnection(url,username,password);
            Statement stmt = conn.createStatement();
            stmt.execute("INSERT INTO `usuarios` (`id`, `nombre`) VALUES (NULL, 'Maria');");
            System.out.println("Usuario insertado en la Base de Datos");
            
            Jdbc_testuarios(stmt);
         
            stmt.executeUpdate("UPDATE `usuarios` SET `nombre` = 'Juan' WHERE `usuarios`.`id` = 38 ;");
            System.out.println("Usuario Actualizado");
            
            Jdbc_testuarios(stmt);
            
            stmt.execute("DELETE FROM `usuarios` WHERE `usuarios`.`nombre` = 'Juan'");
            System.out.println("Usuarios eliminado");
            
            Jdbc_testuarios(stmt);
            
        } catch (SQLException ex) {
            Logger.getLogger(Jdbc_test.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    private static void Jdbc_testuarios(Statement stmt) throws SQLException{
            ResultSet rs = stmt.executeQuery("SELECT * FROM usuarios");
            
            while(rs.next()){
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                System.out.println("Id: " + id );
                System.out.println("Nombre: " + nombre);
            }
        }
        
    }

