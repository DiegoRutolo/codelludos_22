import lectura.Lector;

public class Main {
    public static void main(String[] args) {
        Skill skill=new Skill("C++", 5);
        
        System.out.println("Hola mundo");
        System.out.println("Skill: "+skill.name + ": "+skill.level);
        Lector l = new Lector("a_an_example.in.txt");
        System.out.println("Numero trabajadores: " + l.getNumTrabajadores());
    }
}
