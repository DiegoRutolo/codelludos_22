import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class OutputPrinter {

    public File outputFile;
    FileWriter myWriter;

    public void initialize() {
        try {
//            outputFile = new File("C:\\demo\\demofile.txt");
//            outputStream = new FileOutputStream(outputFile);

            outputFile = new File("filename.txt");
            if (outputFile.createNewFile()) {
                System.out.println("File created: " + outputFile.getName());
            } else {
                System.out.println("File already exists.");
            }
            myWriter = new FileWriter("filename.txt");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


    public void printResult(ArrayList<Result> resultados) {
        try {
            myWriter.write(((Integer)resultados.size()).toString());
            for (Result resultado : resultados) {

                System.out.println("Successfully wrote to the file.");
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


}
