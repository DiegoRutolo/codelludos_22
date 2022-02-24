import java.util.HashMap;

public class Main {
    public static HashMap<String, Proyecto> proyectos=new HashMap<String, Proyecto>();
    public static HashMap<String, Trabajador> trabajadores=new HashMap<String, Trabajador>();
    
    public static void main(String[] args) {
        System.out.println("Hola mundo");

        Lector l = new Lector("a_an_example.in.txt");
    }
}
