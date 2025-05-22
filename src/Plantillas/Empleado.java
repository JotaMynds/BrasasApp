package Plantillas;

public class Empleado {
    private int id;
    private String nombre;
    private String Ape1;
    private String Ape2;
    private int Edad;
    private String fecha;

    public Empleado(int id, String nombre, String Ape1, String Ape2, int Edad, String fecha) {
        this.id = id;
        this.nombre = nombre;
        this.Ape1 = Ape1;
        this.Ape2 = Ape2;
        this.Edad = Edad;
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return id + " - " + nombre + " " + Ape1 + " " + Ape2 + 
        		" - " + " Edad: " + Edad + " - Fecha de entrada: " + fecha;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getApe1() { return Ape1; }
    public String getApe2() { return Ape2; }
    public int getEdad() { return Edad; }


}

