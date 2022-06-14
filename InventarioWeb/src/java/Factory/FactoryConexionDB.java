/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Factory;

/**
 *
 * @author manuelpiano31
 */
public class FactoryConexionDB {
    public static final int MySQL = 1;
    public static String[] configMySQL = {"bd_inventario", "root", ""};
    
    public static ConexionDB open(int tipoBD){
        switch(tipoBD){
            case FactoryConexionDB.MySQL:
                return new MySQLConexionFactory (configMySQL);
            default:
                return null;
        }
    }
    
    public static void main(String[] args) {
        FactoryConexionDB objeto = new FactoryConexionDB();
        open(1);
    }
}
