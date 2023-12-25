import java.util.ArrayList;
import java.util.List;

public class VideoJuego3 {
    public static void main(String[] args) {
        int filas = 10;
        int columnas = 10;
        List<List<Soldado>> tablero = new ArrayList<>(filas);

        for (int i = 0; i < filas; i++) {
            tablero.add(new ArrayList<>());
            for (int j = 0; j < columnas; j++) {
                int ejercito = i % 2;
                Soldado soldado = crearSoldado(i * columnas + j, ejercito);
                tablero.get(i).add(soldado);
            }
        }

        imprimirTablero(tablero);

        for (int i = 0; i < tablero.size(); i++) {
            List<Soldado> ejercito = tablero.get(i);
            ordenarPorBurbuja(ejercito);
            System.out.println("Ranking de poder (Burbuja) del Ejército " + i + ": " + ejercito);
            
            ordenarPorQuicksort(ejercito, 0, ejercito.size() - 1);
            System.out.println("Ranking de poder (Quicksort) del Ejército " + i + ": " + ejercito);
        }

        int sumaTotalEjercito0 = calcularSumaTotalPuntosVida(tablero.get(0));
        int sumaTotalEjercito1 = calcularSumaTotalPuntosVida(tablero.get(1));

        if (sumaTotalEjercito0 > sumaTotalEjercito1) {
            System.out.println("¡El Ejército 0 gana la batalla!");
        } else if (sumaTotalEjercito1 > sumaTotalEjercito0) {
            System.out.println("¡El Ejército 1 gana la batalla!");
        } else {
            System.out.println("¡La batalla termina en empate!");
        }
    }

    private static void imprimirTablero(List<List<Soldado>> tablero) {
    	 for (List<Soldado> filaSoldados : tablero) {
             for (Soldado soldado : filaSoldados) {
                 System.out.print(" ______________ ");
             }
             System.out.println();
             for (Soldado soldado : filaSoldados) {
                 System.out.print("|" + soldado + "|");
             }
             System.out.println();

             // Imprimir fila inferior de la celda
             for (Soldado soldado : filaSoldados) {
                 System.out.print("|______________|");
             }
             System.out.println();
         }
    }

    private static void ordenarPorBurbuja(List<Soldado> soldados) {
        int n = soldados.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (soldados.get(j).getPuntosVida() < soldados.get(j + 1).getPuntosVida()) {
                    Soldado temp = soldados.get(j);
                    soldados.set(j, soldados.get(j + 1));
                    soldados.set(j + 1, temp);
                }
            }
        }
    }

    private static void ordenarPorQuicksort(List<Soldado> soldados, int inicio, int fin) {
        if (inicio < fin) {
            int indicePivote = particionQuicksort(soldados, inicio, fin);
            ordenarPorQuicksort(soldados, inicio, indicePivote - 1);
            ordenarPorQuicksort(soldados, indicePivote + 1, fin);
        }
    }

    private static int particionQuicksort(List<Soldado> soldados, int inicio, int fin) {
        Soldado pivote = soldados.get(fin);
        int i = inicio - 1;

        for (int j = inicio; j < fin; j++) {
            if (soldados.get(j).getPuntosVida() >= pivote.getPuntosVida()) {
                i++;
                Soldado temp = soldados.get(i);
                soldados.set(i, soldados.get(j));
                soldados.set(j, temp);
            }
        }

        Soldado temp = soldados.get(i + 1);
        soldados.set(i + 1, soldados.get(fin));
        soldados.set(fin, temp);

        return i + 1;
    }

    private static int calcularSumaTotalPuntosVida(List<Soldado> soldados) {
        int suma = 0;
        for (Soldado soldado : soldados) {
            suma += soldado.getPuntosVida();
        }
        return suma;
    }

    private static Soldado crearSoldado(int indice, int ejercito) {
        String nombre = Soldado.generarNombre(indice, ejercito);
        int puntosVida = Soldado.generarPuntosVida();
        int fila = indice / 5; 
        int columna = indice % 5;
        return new Soldado(nombre, puntosVida, fila, columna);
    }
}