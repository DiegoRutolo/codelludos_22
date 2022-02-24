import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Lector {
	private int numTrabajadores;
	private int numProyectos;

	// HashMap<String, Trabajador> trabajadores;
	// HashMap<String, Proyecto> proyectos;

	public Lector(String fileName, HashMap<String, Trabajador> trabajadores, HashMap<String, Proyecto> proyectos) {
		try {
			Scanner sc = new Scanner(new FileReader("inputs/" + fileName));
			this.numTrabajadores = sc.nextInt();
			this.numProyectos = sc.nextInt();

			for (int i = 0; i < numTrabajadores; i++) {
				String nombreTrab = sc.next();
				Trabajador t = new Trabajador(nombreTrab);
				t.skills = new ArrayList<>();
				
				int nSkils = sc.nextInt();
				for (int j = 0; j < nSkils; j++) {
					String nombreSkill = sc.next();
					int nivel = sc.nextInt();
					t.skills.add(new Skill(nombreSkill, nivel));
				}
				trabajadores.put(nombreTrab, t);
			}

			for (int i = 0; i < numProyectos; i++) {
				String nomProy = sc.next();
				int nDias = sc.nextInt();
				int puntuacion =  sc.nextInt();
				int limite = sc.nextInt();
				int nRoles = sc.nextInt();

				Proyecto p  = new Proyecto(nomProy, nDias, puntuacion, limite);
				p.roles = new ArrayList<>();
				for (int j = 0; j < nRoles; j++) {
					String nomRol = sc.next();
					int nivRol = sc.nextInt();
					p.roles.add(new Skill(nomRol, nivRol));
				}
				proyectos.put(nomProy, p);
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
