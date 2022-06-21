
package DAO;

import Factory.ConexionDB;
import Factory.FactoryConexionDB;
import Model.Categoria;
import Model.Producto;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class productoDAOImplementar  implements productoDAO {

    ConexionDB conn;
    public productoDAOImplementar(){
    }
    @Override
    public List<Producto> Listar() {
        this.conn = FactoryConexionDB.open(FactoryConexionDB.MySQL);
        StringBuilder miSQL = new StringBuilder();
        miSQL.append("SELECT * FROM tb_producto;");
        List<Producto> lista = new ArrayList<>();
        try{
            ResultSet resultadoSQL = (ResultSet) this.conn.consultaSQL(miSQL.toString());
            while(resultadoSQL.next()){
                Producto producto = new Producto();
                producto.setId_producto(resultadoSQL.getInt("id_producto"));
                producto.setNom_producto(resultadoSQL.getString("nom_producto"));
                producto.setStock(resultadoSQL.getFloat("stock"));
                producto.setPrecio(resultadoSQL.getFloat("precio"));
                producto.setUnidad_medida(resultadoSQL.getString("unidad_medida"));
                producto.setEstado(resultadoSQL.getInt("estado"));
                lista.add(producto);
            }
        }catch(Exception ex){
            
        }finally{
            this.conn.cerrarConexion();
        }
        return lista;
    }

    @Override
    public List<Producto> Listar2() {
        this.conn = FactoryConexionDB.open(FactoryConexionDB.MySQL);
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Producto editarPro(int id_pro_edit) {
        this.conn = FactoryConexionDB.open(FactoryConexionDB.MySQL);
        Producto producto = new Producto();
        StringBuilder miSQL = new StringBuilder();
        miSQL.append("SELECT * FROM tb_producto WHERE id_producto = ").append(id_pro_edit);
        try{
            ResultSet resultadoSQL = (ResultSet) this.conn.consultaSQL(miSQL.toString());
            while(resultadoSQL.next()){
                producto.setId_producto(resultadoSQL.getInt("id_producto"));
                producto.setNom_producto(resultadoSQL.getString("nom_producto"));
                producto.setEstado(resultadoSQL.getInt("estado_producto"));
            }
        }catch(Exception ex){
            
        }finally{
            this.conn.cerrarConexion();
        
        }
        return producto;

        }
//-----------
    @Override
    public boolean guardarPro(Producto producto) {
        this.conn = FactoryConexionDB.open(FactoryConexionDB.MySQL);
        boolean guarda = false;
        try{
            if (producto.getId_producto() == 0) {
                StringBuilder miSQL = new StringBuilder();
                miSQL.append("INSERT INTO tb_producto(nom_producto, estado_producto) VALUES('");
                miSQL.append(producto.getNom_producto() + "', ").append(producto.getEstado());
                miSQL.append(");");
                this.conn.ejecutarSQL(miSQL.toString());
                
            }else if(producto.getId_producto() > 0){
                StringBuilder miSQL = new StringBuilder();
                miSQL.append("UPDATE tb_producto SET id_producto = ").append(producto.getId_producto());
                miSQL.append(", nom_producto = '").append(producto.getNom_producto());
                miSQL.append("', estado_producto = ").append(producto.getEstado());
                miSQL.append(" WHERE id_producto = ").append(producto.getId_producto()).append(";");
                this.conn.ejecutarSQL(miSQL.toString());
            }
            guarda = true;
        } catch (Exception e) {
            
        }finally{
            this.conn.cerrarConexion();
        }
        return guarda;
            }

    @Override
    public boolean borrarPro(int id_pro_borrar) {
        this.conn = FactoryConexionDB.open(FactoryConexionDB.MySQL);
        boolean borra = false;
        try{
            StringBuilder miSQL = new StringBuilder();
            miSQL.append("DELETE FROM tb_producto WHERE id_producto = ").append(id_pro_borrar);
            this.conn.ejecutarSQL(miSQL.toString());
            borra = true;
        } catch (Exception e) {
     }finally{
            this.conn.cerrarConexion();
        }
        return borra;
        
            
        }
}
  
    

