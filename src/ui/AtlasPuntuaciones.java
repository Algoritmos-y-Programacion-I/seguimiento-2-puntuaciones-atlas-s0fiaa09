// Análisis (completar)
// Descripción del programa:
// Entradas:
// Salidas:
// Ejemplo:


package ui; // No olvidar especificar el paquete / carpeta de nuestro programa

import java.util.Scanner; // Para poder usar Scanner, debemos importarlo

public class AtlasPuntuaciones {

	// Declaración del Escaner que nos ayudará en todo el programa
	private Scanner escaner;

	// Declaración de nuestras constantes a utilizar


	private AtlasPuntuaciones() {
		escaner = new Scanner(System.in);
	}
	
	
	public void run()
	{


		 System.out.println("Ingrese el número de jugadores (Máximo 10):");
			 int n = escaner.nextInt();
				 
		System.out.println("Ingrese el número de rondas (Máximo 5):");
			int m = escaner.nextInt();


			int [] jugadores = CantJugadores(n);
			jugadores = puntajeRondas(jugadores, m);
			resultado(jugadores, m);
			puntuacionAlta(jugadores);
			int Ganador = puntuacionAlta(jugadores);
	




			 
				
		 
			}
		 
			public static void main(String[] args) {
		AtlasPuntuaciones mainApp = new AtlasPuntuaciones();
		mainApp.run();
	}

	/**
	 * Descripción: El método calcularSumaTotal permite ...
	 * @param int[] numeros
	 * @return 
	 */


public int[] CantJugadores(int n) {
		int [] jugadores = new int [n];
		return jugadores;

	} 
	public int[] puntajeRondas(int[] jugadores, int m) {
     for (int i = 0; i < jugadores.length; i++) { 
        jugadores[i] = PuntajeRondas(i, m);
    }
    return jugadores;

}
	public int PuntajeRondas(int jugador, int m) {
    	int puntajeTotal = 0;
    for (int i = 0; i < m; i++) { 
        System.out.println("Ingrese el puntaje del jugador " + (jugador + 1) + " en la ronda " + (i + 1) + ": ");
       puntajeTotal += escaner.nextInt();

    }
	metodoPromedio(puntajeTotal, m);
    return puntajeTotal;
}
	public  void resultado(int[] jugadores, int m) {
        System.out.println("Resultados del torneo:");
        for (int i = 0; i < jugadores.length; i++) { 
            double promedio = metodoPromedio(jugadores[i], m);
            System.out.println("El puntaje total del jugador " + (i + 1) + " es: " + jugadores[i] +" El promedio por ronda: " + promedio);
        }
    }

 	public  double metodoPromedio(int puntTotal, int m) {
		double resultado = (puntTotal / m);
        return resultado;
    }

	public  int  puntuacionAlta(int[] jugadores) {
		int mayor = 0;
		int jugadorGanador = 1;
		for (int i = 0; i < jugadorGanador.length; i++) {

		if (jugadorGanador > mayor) {
			mayor = jugadorGanador;
			System.out.println("el jugador con la puntuacion mas alta es: " + jugadorGanador);
		}

		}

	}

	

	
}