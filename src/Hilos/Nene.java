package Hilos;

import java.util.Random;

public class Nene extends Thread {

	private Mesa mesa;
	String nombre;

	public Nene(String nombre, Mesa mesa) {
		this.nombre = nombre;
		this.mesa = mesa;
	}

	// Sleep con tiempo d espera random, mesa llama al metodo come tarta
	public void run() {
		try {
			System.out.println(nombre + " llega a la fiesta");
			Thread.sleep(new Random().nextInt(500));

			mesa.comerTarta(nombre);

			System.out.println(nombre + " se marcha del cumpleaños");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}