import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class FileManager {
	private int numTrabajadores;
	private int numProyectos;
	private CASO_STRUCT CASO;
	private File outputFile;
    private FileWriter outputWriter;

	public FileManager(CASO_STRUCT CASO) {
		this.CASO=CASO;
		
	}

	public void readFile(){
		try {
			Scanner sc = new Scanner(new FileReader("inputs/" + this.CASO.input_file));
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
				Main.trabajadores.put(nombreTrab, t);
			}

			for (int i = 0; i < numProyectos; i++) {
				String nomProy = sc.next();
				int nDias = sc.nextInt();
				int puntuacion =  sc.nextInt();
				int limite = sc.nextInt();
				int nRoles = sc.nextInt();

				Proyecto p  = new Proyecto(nomProy, nDias, puntuacion, limite);
				for (int j = 0; j < nRoles; j++) {
					String nomRol = sc.next();
					int nivRol = sc.nextInt();
					p.roles.add(new Skill(nomRol, nivRol));
				}
				Main.proyectos.put(nomProy, p);
			}
		} catch (FileNotFoundException e) {
		}
	}

	public void writeResult(ArrayList<Asignacion> resultados){
		try {
            outputFile = new File(this.CASO.output_file);
            if (outputFile.createNewFile()) {
                System.out.println("File created: " + outputFile.getName());
            } else {
                System.out.println("File already exists.");
            }
            outputWriter = new FileWriter(this.CASO.output_file);

			outputWriter.write(((Integer)resultados.size()).toString() + "\n");
            for (Asignacion resultado : resultados) {
                outputWriter.write(resultado.proyecto.nombre + "\n");
                for(int i = 0; i < resultado.trabajadores.size(); i++) {
                    Trabajador trabajador = resultado.trabajadores.get(i);
                    if(i < resultado.trabajadores.size() -1) {
                        outputWriter.write(trabajador.nombre + " ");
                    } else {
                        outputWriter.write(trabajador.nombre + "\n");
                    }
                }
            }
            outputWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
	}

	public int getNumTrabajadores() {
		return this.numTrabajadores;
	}

	public int getNumProyectos() {
		return this.numProyectos;
	}
}
