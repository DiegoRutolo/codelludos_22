import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class OutputPrinter {

    public File outputFile;
    FileWriter outputWriter;

    public void initialize() {
        try {
            outputFile = new File("filename.txt");
            if (outputFile.createNewFile()) {
                System.out.println("File created: " + outputFile.getName());
            } else {
                System.out.println("File already exists.");
            }
            outputWriter = new FileWriter("filename.txt");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


    public void printResult(ArrayList<Asignacion> resultados) {
        if(outputFile == null || outputWriter == null) {
            this.initialize();
        }
        try {
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
}
