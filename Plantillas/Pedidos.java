package Plantillas;

public class Pedidos 
{
	private int id_mesa;
	private int gambas;
	private int croquetas;
	private int quesos;
	private int ensaladilla;
	private int patatas;
	private String estado;
	
	public int getId_mesa() {
		return id_mesa;
	}
	public void setId_mesa(int id_mesa) {
		this.id_mesa = id_mesa;
	}
	public int getGambas() {
		return gambas;
	}
	public void setGambas(int gambas) {
		this.gambas = gambas;
	}
	public int getCroquetas() {
		return croquetas;
	}
	public void setCroquetas(int croquetas) {
		this.croquetas = croquetas;
	}
	public int getQuesos() {
		return quesos;
	}
	public void setQuesos(int quesos) {
		this.quesos = quesos;
	}
	public int getEnsaladilla() {
		return ensaladilla;
	}
	public void setEnsaladilla(int ensaladilla) {
		this.ensaladilla = ensaladilla;
	}
	public int getPatatas() {
		return patatas;
	}
	public void setPatatas(int patatas) {
		this.patatas = patatas;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public Pedidos(int id_mesa, int gambas, int croquetas, int quesos, int ensaladilla, int patatas, String estado) {
		super();
		this.id_mesa = id_mesa;
		this.gambas = gambas;
		this.croquetas = croquetas;
		this.quesos = quesos;
		this.ensaladilla = ensaladilla;
		this.patatas = patatas;
		this.estado = estado;
	}
	@Override
	public String toString() {
		return 	"Mesa: " + id_mesa + 
                " | Gambas: " + gambas + 
                " | Croquetas: " + croquetas + 
                " | Quesos: " + quesos + 
                " | Ensaladilla: " + ensaladilla + 
                " | Patatas: " + patatas;
	}
	
	
}
