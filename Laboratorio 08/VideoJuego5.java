import java.util.HashMap;
import java.util.Map;

public class VideoJuego5 {
    public static void main(String[] args) {
        int totalSoldados = 100; // 10 filas x 10 columnas
        Map<Integer, Soldado> soldadosMap = new HashMap<>();

        for (int i = 0; i < totalSoldados; i++) {
            int ejercito = i % 2;
            Soldado soldado = crearSoldado(i, ejercito);
            soldadosMap.put(i, soldado);
        }

        imprimirTablero(soldadosMap);

        int sumaTotalEjercito0 = calcularSumaTotalPuntosVida(soldadosMap, 0, totalSoldados / 2);
        int sumaTotalEjercito1 = calcularSumaTotalPuntosVida(soldadosMap, totalSoldados / 2, totalSoldados);

        determinarGanador(sumaTotalEjercito0, sumaTotalEjercito1);
    }

    private static void imprimirTablero(Map<Integer, Soldado> soldadosMap) {
        int columnas = 10;
        for (int i = 0; i < soldadosMap.size(); i++) {
            imprimirCasilla(soldadosMap.get(i));
            if ((i + 1) % columnas == 0) {
                System.out.println(); // Salto de línea después de cada fila
            }
        }
    }

    private static void imprimirCasilla(Soldado soldado) {
        System.out.print("| " + soldado.getNombre() + " ");
    }

    private static int calcularSumaTotalPuntosVida(Map<Integer, Soldado> soldadosMap, int inicio, int fin) {
        int suma = 0;
        for (int i = inicio; i < fin; i++) {
            suma += soldadosMap.get(i).getPuntosVida();
        }
        return suma;
    }

    private static void determinarGanador(int sumaTotalEjercito0, int sumaTotalEjercito1) {
        if (sumaTotalEjercito0 > sumaTotalEjercito1) {
            System.out.println("¡El Ejército 0 gana la batalla!");
        } else if (sumaTotalEjercito1 > sumaTotalEjercito0) {
            System.out.println("¡El Ejército 1 gana la batalla!");
        } else {
            System.out.println("¡La batalla termina en empate!");
        }
    }

    private static Soldado crearSoldado(int indice, int ejercito) {
        String nombre = Soldado.generarNombre(indice, ejercito);
        int puntosVida = Soldado.generarPuntosVida();
        return new Soldado(nombre, puntosVida, 0, 0);
    }
}