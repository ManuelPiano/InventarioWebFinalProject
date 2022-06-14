/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author manuelpiano31
 */
public class Producto {
    private int id_producto;
    private String nom_producto;
    private int id_categoria;
    private float stock;
    private float precio;
    private String unidad_medida;
    private int estado;
    private Categoria categoria;
    
    public Producto() {
        this.id_producto = 0;
        this.categoria = new Categoria();
    }
    
    public Producto(int id_producto, String nom_producto, int id_categoria, float stock, float precio, String unidad_medida, int estado, Categoria categoria){
    this.id_producto = id_producto;
    this.nom_producto = nom_producto;
    this.id_categoria = id_categoria;
    this.stock = stock;
    this.precio = precio;
    this.unidad_medida = unidad_medida;
    this.estado = estado;
    this.categoria = categoria;
    
}

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getNom_producto() {
        return nom_producto;
    }

    public void setNom_producto(String nom_producto) {
        this.nom_producto = nom_producto;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public float getStock() {
        return stock;
    }

    public void setStock(float stock) {
        this.stock = stock;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getUnidad_medida() {
        return unidad_medida;
    }

    public void setUnidad_medida(String unidad_medida) {
        this.unidad_medida = unidad_medida;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
