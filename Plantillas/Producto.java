package Plantillas;

public class Producto {
    private int id;
    private String nombre;
    private double precio;

    public Producto(int id, String nombre, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return id + " - " + nombre + " - " + precio + "€";
    }


    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
}

