/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;

import DAO.CategoriaDAO;
import DAO.CategoriaDAOImplementar;
import Model.Categoria;
import java.util.List;

/**
 *
 * @author manuelpiano31
 */
public class Prueba {
    public static void main(String[] args) {
        Prueba evaluar = new Prueba();
        //evaluar.guardaCategoria();
        evaluar.listarCategorias();
        evaluar.eliminarCategoria();
        evaluar.listarCategorias();
        //evaluar.editarCategoria();
        
    }

    public void listarCategorias() {
        CategoriaDAO categoria = new CategoriaDAOImplementar();
        List<Categoria> listar = categoria.Listar();
        System.out.println("LISTADO DE CATEGORIAS");
        for(Categoria categoriaListar : listar){
            System.out.println("ID: " + categoriaListar.getId_categoria() + 
                    " NOMBRE: " + categoriaListar.getNom_categoria() + 
                    " ESTADO: " + categoriaListar.getEstado_categoria());
        }
    }

    private void editarCategoria() {
        CategoriaDAO categoria = new CategoriaDAOImplementar();
        Categoria cat_edit = categoria.editarCat(1);
        System.out.println("CATEGORIA A MODIFICAR");
        System.out.println("ID: " + cat_edit.getId_categoria() + 
                    " NOMBRE: " + cat_edit.getNom_categoria() + 
                    " ESTADO: " + cat_edit.getEstado_categoria());

    }

    private void guardaCategoria() {
        CategoriaDAO categoria = new CategoriaDAOImplementar(); 
        Categoria guarda_cat = new Categoria();
        guarda_cat.setNom_categoria("Bebidas Naturales"); //Cambiar nombre
        guarda_cat.setId_categoria(5); //Modificar la categoria registrada anteriormente
        guarda_cat.setEstado_categoria(1); //Estado 1
        categoria.guardarCat (guarda_cat);

    }

    private void eliminarCategoria() {
        CategoriaDAO categoria = new CategoriaDAOImplementar();
        categoria.borrarCat(2);
    }
    
}
