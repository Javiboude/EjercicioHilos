package Hilos;

public class Fiesta {

	public static void main(String[] args) {
		System.out.println("Empieza el cumpleaños");

		// Creamos los hilos y los empezamos
		int numeroDeNiños = 4;
		Mesa mesa = new Mesa(numeroDeNiños);

		Madre madre = new Madre(mesa);
		madre.start();

		// Creamos un array de niños y creamos un array tipo Nene al que le metemos los
		// numero de ninos que queremos crear.
		String[] nombresNiños = { "Jaimito", "Luisito", "Juanito", "Jorgito" };
		Nene[] niños = new Nene[numeroDeNiños];

		// Mientras i sea menor que numeroDeNiños crea un niño con el array y lo inicializa
		for (int i = 0; i < numeroDeNiños; i++) {
			niños[i] = new Nene(nombresNiños[i], mesa);
			niños[i].start();
		}

		//Hacemos un join a los hilos
		try {
			for (Nene niño : niños) {
				niño.join();
			}
			madre.join();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}

		System.out.println("Fin del cumpleaños");
	}
}
