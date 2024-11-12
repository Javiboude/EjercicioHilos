package Hilos;

public class Mesa {
	private final int totalNiños;
	private int porcionesTarta = 0;
	private int niñosQueHanComido = 0;

	public Mesa(int totalNiños) {
		this.totalNiños = totalNiños;
	}

	// Metodo synchronized donde si no hay porciones espera, sino quitamos una
	// porcion de tarta y sumamos un niño que ha comido despues avisamos al otro
	// metodo con notifyAll
	public synchronized void comerTarta(String nombre) throws InterruptedException {
		while (porcionesTarta == 0) {
			wait();
		}
		porcionesTarta--;
		niñosQueHanComido++;
		notifyAll();
	}

	// Metodo synchronized donde si hay porciones espera, sino mientras no hayan
	// comido todos los niños añadimos dos porciones de tarta despues avisamos
	public synchronized void reponerTarta() throws InterruptedException {
		while (porcionesTarta > 0) {
			wait();
		}
		if (niñosQueHanComido < totalNiños) {
			porcionesTarta++;
			porcionesTarta++;
			System.out.println("--> Mamá pone tarta");
			notifyAll();
		}
	}

	public synchronized boolean todosHanComido() {
		return niñosQueHanComido >= totalNiños;
	}
}
