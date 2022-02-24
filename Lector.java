import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Scanner;

public class Lector {
	private int numTrabajadores;
	private int numProyectos;

	private List<Trabajador> trabajadores;

	public Lector(String fileName) {

		try {
			Scanner sc = new Scanner(new FileReader("inputs/" + fileName));
			this.numTrabajadores = sc.nextInt();
			this.numProyectos = sc.nextInt();

			for (int i = 0; i < numTrabajadores; i++) {
				String nombreTrab = sc.next();
				Trabajador t = new Trabajador(nombreTrab);
				int nSkils = sc.nextInt();

				for (int j = 0; j < nSkils; j++) {
					String nombreSkill = sc.next();
					int nivel = sc.nextInt();
					t.skills.add(new Skill(nombreSkill, nivel));
				}
			}
		} catch (FileNotFoundException e) {
		}
	}

	public int getNumTrabajadores() {
		return this.numTrabajadores;
	}

	public int getNumProyectos() {
		return this.numProyectos;
	}
}
