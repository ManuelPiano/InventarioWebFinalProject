/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Factory;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author manuelpiano31
 */
public final class MySQLConexionFactory extends ConexionDB {

    public MySQLConexionFactory(String[] criterios) {
        this.parametros = criterios;
        this.open();
    }

    @Override
    public Connection open() {
    try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + this.parametros[0], this.parametros[1], this.parametros[2]);
        System.out.println("conexion satisfactoriamente hecha");
        }catch(Exception ex){
            System.out.println("Error de conexion laka");
            ex.printStackTrace();
        }
        return this.conexion;
    }

}
