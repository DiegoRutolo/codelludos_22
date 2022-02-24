package lectura;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Lector {
	private int numTrabajadores;
	private int numProyectos;

	public Lector(String fileName) {

		try {
			Scanner sc = new Scanner(new FileReader("inputs/" + fileName));
			this.numTrabajadores = sc.nextInt();
			this.numProyectos = sc.nextInt();
		} catch (FileNotFoundException e) {
			this.numTrabajadores = 0;
			this.numProyectos = 0;
		}
	}

	public int getNumTrabajadores() {
		return this.numTrabajadores;
	}

	public int getNumProyectos() {
		return this.numProyectos;
	}
}
