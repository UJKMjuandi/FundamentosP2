
public class Soldado {
	private String nombre;
	private int nivelAtaque;
	private int nivelDefensa;
	private int nivelVida;
	private int velocidad;
	private String actitud;
	private int vidaActual;
	private boolean vive;
    private int posFila;
    private char posCol;
    private char figura;
	public Soldado(String n) {
		nombre = n;
	}
	public int atacar() {
		actitud = "ofensiva";
		return avanzar();
	}
	public void defender() {
		velocidad = 0;
		actitud = "defensiva";
	}
	public int avanzar() {
		return velocidad+1;
	}
	public void retroceder() {
		defender();
		actitud = "defensiva";
		velocidad = velocidad - 1; 
	}
	public void serAtacado() {
		nivelVida = nivelVida - 1;
	}
	public void huir() {
		actitud = "fuga";
	}
	public void morir() {
		actitud = "muerto";
		nivelVida = 0;
	}
	//sets
	public void setVidaActual(int a) {
		nivelVida = a;
	}
	public void setFila(int n){
        posFila = n;
    }
    public void setCol(char n){
        posCol = n;
    }
	//tres constructores sobrecargados
	public Soldado(String nom, char fig){
        nombre = nom;
        nivelAtaque = (int)(Math.random() * 5 + 1);
        nivelDefensa = (int)(Math.random() * 5 + 1);
        nivelVida = (int)(Math.random() * 5 + 1);
        vidaActual = nivelVida;
        velocidad = 0;
        actitud = "Defensiva";
        vive = true;
        posFila = (int)(Math.random() * 10 + 1);
        posCol = numCol();
        figura = fig;
    }
    public Soldado(String nom, int nivAtaq, int nivDef, int vid, char fig){
        nombre = nom;
        nivelAtaque = nivAtaq;
        nivelDefensa = nivDef;
        nivelVida = vid;
        vidaActual = vid;
        velocidad = 0;
        actitud = "Defensiva";
        vive = true;
        posFila = (int)(Math.random() * 10 + 1);
        posCol = numCol();
        figura = fig;
    }
    public Soldado(String nom, int nivAtaq, int nivDef, int nivVida, int nivAct, int vel, String act, boolean vivir, int pFila, char pCol, char fig){
        nombre = nom;
        nivelAtaque = nivAtaq;
        nivelDefensa = nivDef;
        nivelVida = nivVida;
        vidaActual = nivAct;
        velocidad = vel;
        actitud = act;
        vive = vivir;
        posFila = pFila;
        posCol = pCol;
        figura = fig;
    }
    public static char numCol(){
        String a = "abcdefghij";
        int n = (int)(Math.random() * a.length());
        char car = a.charAt(n);
        return car;
    }
    public String toString(){
        return "Nombre: " + nombre + " Vida:" + vidaActual + " Fila:" + posFila + " Columna:" + posCol + " Actitud:" + actitud;
    }
    //gets
    public String getNombre(){
        return nombre;
    }
    public int getAtaque(){
        return nivelAtaque;
    }
    public int getDefensa(){
        return nivelDefensa;
    }
    public int getNivVidAct(){
        return vidaActual;
    }
    public int getVida(){
        return nivelVida;
    }
    public int getVelocidad(){
        return velocidad;
    }
    public String getActitud(){
        return actitud;
    }
    public boolean getVive(){
        return vive;
    }
    public int getFila(){
        return posFila;
    }
    public char getColumna(){
        return posCol;
    }
    public char getFigura(){
        return figura;
    } 
}
