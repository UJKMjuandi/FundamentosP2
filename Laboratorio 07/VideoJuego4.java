public class VideoJuego4 {
    public static void main(String[] args) {
        int filas = 10;
        int columnas = 10;
        Soldado[][] tablero = new Soldado[filas][columnas];

        Soldado[] soldados01 = new Soldado[genNumSol()];
        Soldado[] soldados02 = new Soldado[genNumSol()];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                int ejercito = i % 2;
                Soldado soldado = crearSoldado(i * columnas + j, ejercito);
                tablero[i][j] = soldado;
            }
        }

        imprimirTablero(tablero);

        for (int i = 0; i < filas; i++) {
            Soldado[] ejercito = tablero[i];
            ordenarPorBurbuja(ejercito);
            ordenarPorQuicksort(ejercito, 0, ejercito.length - 1);
        }

        int sumaTotalEjercito0 = calcularSumaTotalPuntosVida(tablero[0]);
        int sumaTotalEjercito1 = calcularSumaTotalPuntosVida(tablero[1]);

        if (sumaTotalEjercito0 > sumaTotalEjercito1) {
            System.out.println("¡El Ejército 0 gana la batalla!");
        } else if (sumaTotalEjercito1 > sumaTotalEjercito0) {
            System.out.println("¡El Ejército 1 gana la batalla!");
        } else {
            System.out.println("¡La batalla termina en empate!");
        }
    }

    private static void imprimirTablero(Soldado[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                imprimirCasilla(tablero[i][j]);
            }
            System.out.println(); // Agregar salto de línea después de cada fila
        }
    }

    private static void imprimirCasilla(Soldado soldado) {
    	 System.out.print("| " + soldado.getNombre() + " ");
    }

    private static void ordenarPorBurbuja(Soldado[] soldados) {
        int n = soldados.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (soldados[j].getPuntosVida() < soldados[j + 1].getPuntosVida()) {
                    Soldado temp = soldados[j];
                    soldados[j] = soldados[j + 1];
                    soldados[j + 1] = temp;
                }
            }
        }
    }

    private static void ordenarPorQuicksort(Soldado[] soldados, int inicio, int fin) {
        if (inicio < fin) {
            int indicePivote = particionQuicksort(soldados, inicio, fin);
            ordenarPorQuicksort(soldados, inicio, indicePivote - 1);
            ordenarPorQuicksort(soldados, indicePivote + 1, fin);
        }
    }

    private static int particionQuicksort(Soldado[] soldados, int inicio, int fin) {
        Soldado pivote = soldados[fin];
        int i = inicio - 1;

        for (int j = inicio; j < fin; j++) {
            if (soldados[j].getPuntosVida() >= pivote.getPuntosVida()) {
                i++;
                Soldado temp = soldados[i];
                soldados[i] = soldados[j];
                soldados[j] = temp;
            }
        }

        Soldado temp = soldados[i + 1];
        soldados[i + 1] = soldados[fin];
        soldados[fin] = temp;

        return i + 1;
    }

    private static int calcularSumaTotalPuntosVida(Soldado[] soldados) {
        int suma = 0;
        for (Soldado soldado : soldados) {
            suma += soldado.getPuntosVida();
        }
        return suma;
    }

    private static Soldado crearSoldado(int indice, int ejercito) {
        String nombre = Soldado.generarNombre(indice, ejercito);
        int puntosVida = Soldado.generarPuntosVida();
        int fila = indice / 10;
        int columna = indice % 10;
        return new Soldado(nombre, puntosVida, fila, columna);
    }

    public static int genNumSol() {
        return (int) (Math.random() * 10 + 1);
    }
}