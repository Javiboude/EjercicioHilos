package Hilos;

public class Madre extends Thread {

	private Mesa mesa;

	public Madre(Mesa mesa) {
		this.mesa = mesa;
	}

	// Sleep de un segundo llama al metodo todosHancomido para ver si no se cumple y
	// pasar al metodo reponer
	public void run() {
		try {
			sleep(1000);
			System.out.println("Mami llega al cumpleaños");
			while (!mesa.todosHanComido()) {
				mesa.reponerTarta();
			}
			System.out.println("Mami se va del cumpleaños");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}