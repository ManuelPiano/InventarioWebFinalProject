
package DAO;

import Model.Categoria;
import java.util.List;

public class productoDAO {
    public List<Producto> Listar();
    public List<Producto> Listar2();
    public Producto editarPro(int id_pro_edit);
    public boolean guardarPro(Producto producto);
    public boolean borrarPro(int id_pro_borrar);
}
