import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static HashMap<String, Proyecto> proyectos=new HashMap<String, Proyecto>();
    public static HashMap<String, Trabajador> trabajadores=new HashMap<String, Trabajador>();
    
    public static void main(String[] args) {
        System.out.println("Hola mundo");

        Lector l = new Lector("a_an_example.in.txt");

        //P1
        Skill s1=new Skill("Java", 5);
        Skill s2=new Skill("C++", 3);
        //T1
        Skill s3=new Skill("Java", 6);
        Skill s4=new Skill("Python", 6);
        //T2
        Skill s5=new Skill("Go", 4);
        Skill s6=new Skill("C++", 3);

        //P2
        Skill s7=new Skill("Java", 5);
        Skill s8=new Skill("C", 2);
        Skill s9=new Skill("Python", 6);
        //T1
        Skill s10=new Skill("Java", 5);
        Skill s11=new Skill("C", 2);
        //T2
        Skill s12=new Skill("Python", 7);
        Skill s13=new Skill("C", 1);
        //T3
        Skill s14=new Skill("Python", 5);

        Proyecto p1 = new Proyecto("hashcode",10,10,10);
        ArrayList<Skill> p1_skills = new ArrayList<Skill>();
        p1_skills.add(s1);
        p1_skills.add(s2);
        p1.roles=p1_skills;
        Trabajador t1 = new Trabajador("Fulano");
        t1.skills.add(s3);
        t1.skills.add(s4);
        Trabajador t2 = new Trabajador("Fulana");
        t2.skills.add(s5);
        t2.skills.add(s6);
        ArrayList<Trabajador> g1 = new ArrayList<Trabajador>();
        g1.add(t1);
        g1.add(t2);
        Asignacion a1=new Asignacion();
        a1.trabajadores=g1;
        a1.proyecto=p1;
        if(a1.esViable()){
            System.out.println("La Asignacion 1 es viable");
        }

        Proyecto p2 = new Proyecto("veloren",10,10,10);
        ArrayList<Skill> p2_skills = new ArrayList<Skill>();
        p2_skills.add(s7);
        p2_skills.add(s8);
        p2_skills.add(s9);
        p2.roles=p2_skills;
        Trabajador t3 = new Trabajador("Fulanito");
        t3.skills.add(s10);
        t3.skills.add(s11);
        Trabajador t4 = new Trabajador("Fulanita");
        t4.skills.add(s12);
        t4.skills.add(s13);
        Trabajador t5 = new Trabajador("Fulanosss");
        t5.skills.add(s14);
        ArrayList<Trabajador> g2 = new ArrayList<Trabajador>();
        g2.add(t3);
        g2.add(t4);
        g2.add(t5);
        Asignacion a2 = new Asignacion();
        a2.trabajadores=g2;
        a2.proyecto=p2;

        if(a2.esViable()){
            System.out.println("La Asignacion 2 es viable");
        }
    }
}
