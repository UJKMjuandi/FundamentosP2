public class Soldado {
	private String nombre;
	private int fila;
	private int columna;
	private int nivelVida;
	// Zona de sets
	public void setNombre(String n){
		nombre = n;
	}
	public void setFila(int f){
		fila = f;
	}
	public void setColumna(int c){
		columna = c;
	}
	public void setNivelVida(int vida){
		nivelVida = vida;
	}
	// Zona de gets
	public String getNombre(){
		return nombre;
	}
	public int getFila(){
		return fila;
	}
	public int getColumna(){
		return columna;
	}
	public int getNivelVida(){
		return nivelVida;
	}
}