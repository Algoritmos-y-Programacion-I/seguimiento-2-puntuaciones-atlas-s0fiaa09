/* Análisis (completar)
Descripción del programa:permite gestionar y calcular los puntajes de un número variable de jugadores 
en varias rondas de un juego. Los usuarios ingresan la cantidad de jugadores y rondas, 
así como los puntajes obtenidos en cada ronda. Al final, el programa calcula el puntaje total 
y el promedio de cada jugador, y determina quién es el ganador basado en el mayor promedio.
Entradas: 
- Número de Jugadores: Un entero que representa la cantidad de jugadores (debe estar entre 1 y 10).
- Número de Rondas: Un entero que representa la cantidad de rondas (debe estar entre 1 y 5).
- Puntajes: Un entero para cada jugador en cada ronda (debe estar entre 0 y 100).
Salidas:
- Puntajes Finales: Muestra el puntaje total de cada jugador.
- Promedios: Muestra el promedio de puntajes de cada jugador.
- Ganador: Indica cuál jugador tiene el mayor promedio.
Ejemplo:
Ingrese el numero de jugadores (1-10): 
3
Ingrese la cantidad de rondas (1-5): 
2
Ingrese el puntaje en la ronda 1 del jugador 1: 
50
Ingrese el puntaje en la ronda 1 del jugador 2: 
70
Ingrese el puntaje en la ronda 1 del jugador 3: 
80
Ingrese el puntaje en la ronda 2 del jugador 1: 
60
Ingrese el puntaje en la ronda 2 del jugador 2: 
90
Ingrese el puntaje en la ronda 2 del jugador 3: 
70
Resultados finales:
Jugador 1 - Puntaje total : 110 - promedio: 55.0
Jugador 2 - Puntaje total : 160 - promedio: 80.0
Jugador 3 - Puntaje total : 150 - promedio: 75.0
El ganador es el jugador 2

*/

package ui; // No olvidar especificar el paquete / carpeta de nuestro programa

import java.util.Scanner; // Para poder usar Scanner, debemos importarlo

public class AtlasPuntuaciones {

	// Declaración del Escaner que nos ayudará en todo el programa
	private Scanner escaner;

	// Declaración de nuestras constantes a utilizar
	 static final int MAX_JUGADORES = 10;
	 static final int MAX_RONDAS = 5;
	 static final int MAX_PUNTAJE = 100;

	private  AtlasPuntuaciones() {
		escaner = new Scanner(System.in);
	}
	
	public void run()//entrada de datos, mensajes al usuario y mostrar salidas
	{ // Declaracion de todas las variables a usar en el programa(ints, doubles, arreglos, etc)
		int CantJugadores, CantRondas;
		// Notificacion al usuario de la solicitud de dato(println)
		// Capturamos el dato con nuestro Scanner (que se llama, escaner)
		System.out.println("Ingrese el numero de jugadores (1-10): ");
        CantJugadores = escaner.nextInt();
		escaner.nextLine(); 
		while (CantJugadores < 1 || CantJugadores > MAX_JUGADORES) {
			System.out.println("Error: Debe ingresar un valor entre 1 y 10. Intente de nuevo: ");
			CantJugadores = escaner.nextInt();
		}

        System.out.println("Ingrese la cantidad de rondas (1-5): ");
        CantRondas = escaner.nextInt();
		escaner.nextLine();
        while (CantRondas < 1 || CantRondas > MAX_RONDAS) {
            System.out.println("Error: Debe ingresar un valor entre 1 y 5. Intente de nuevo: ");
            CantRondas = escaner.nextInt();
			escaner.nextLine(); 
        }

		// Declaración de arreglos

		int[] puntajesFinales = PuntajesTotal(CantJugadores, CantRondas);
		double[] promedio =calcularPromedio(puntajesFinales, CantRondas);
		int Ganador = encontrarMayor( CantJugadores, promedio);

		// Notificación al usuario de los resultados(salidas)
		// Mostrar los puntajes finales
  System.out.println("Resultados finales:");
  for (int i = 0; i < CantJugadores; i++) {
	  System.out.println("Jugador " + (i + 1) + " - Puntaje total : " + puntajesFinales[i] + "- promedio: " + promedio[i]);
	}
	// Mostrar el ganador
	System.out.println("El ganador es el jugador " + (Ganador+1));

	}

	// metodos

	public static void main(String[] args) {
		AtlasPuntuaciones mainApp = new AtlasPuntuaciones();
		mainApp.run();
	}
/**
 * Descripción: El método PuntajesTotal permite capturar los puntajes de cada jugador en cada ronda
 * y calcular el puntaje total acumulado por cada jugador.
 * 
 * @param int cantJugadores - La cantidad de jugadores que participan en el juego.
 * @param int cantRondas - La cantidad de rondas que se jugarán.
 * @return int[] - Un arreglo que contiene el puntaje total de cada jugador.
 */
public int[] PuntajesTotal(int cantJugadores, int cantRondas) {
		int puntajes[] = new int[cantJugadores];
       for (int i = 0; i < cantRondas * cantJugadores ; i++) {
		  int rondaActual = (i / cantJugadores) + 1; // Determinar la ronda
            int jugadorActual = (i % cantJugadores) + 1; // Determinar el jugador
			System.out.println("Ingrese el puntaje en la ronda " + rondaActual + " del jugador " + jugadorActual + ": ");
            int puntaje = escaner.nextInt();

			if (puntaje < 0 || puntaje > MAX_PUNTAJE) {
                System.out.println("El puntaje no es valido. Intente de nuevo.");
                i--; 
                continue;
            }

            puntajes[jugadorActual - 1] += puntaje; 
        }
        return puntajes; 
}

/**
 * Descripción: El método calcularPromedio calcula el promedio de puntajes de cada jugador
 * basado en su puntaje total y la cantidad de rondas.
 * 
 * @param int[] puntajes - Un arreglo que contiene los puntajes totales de cada jugador.
 * @param int cantRondas - La cantidad de rondas jugadas.
 * @return double[] - Un arreglo que contiene el promedio de puntajes de cada jugador.
 */
public double[] calcularPromedio(int[] puntajes, int cantRondas) {
	double[] promedios = new double[puntajes.length];
	for (int i = 0; i < puntajes.length; i++) {
		promedios[i] = puntajes[i] / (double) cantRondas;
	}
	return promedios;
}

/**
 * Descripción: El método encontrarMayor busca el índice del jugador con el mayor promedio de puntajes.
 * 
 * @param int cantJugadores - La cantidad de jugadores que participaron en el juego.
 * @param double[] promedio - Un arreglo que contiene los promedios de puntajes de cada jugador.
 * @return int - El índice del jugador con el mayor promedio.
 */
public int encontrarMayor(int cantJugadores, double[] promedio) {
	int indiceGanador = 0; //solo para darle un valor inicial "el primer jugador es el ganador"
	double mayorPromedio = promedio[0]; // se guarda ese promedio del ganador
	for (int i = 1; i < cantJugadores; i++) { 
		if (promedio[i] > mayorPromedio) {//actualiza al verdadero mayor promedio
			mayorPromedio = promedio[i];
			indiceGanador = i;
		}
	}
	return indiceGanador;
}
}