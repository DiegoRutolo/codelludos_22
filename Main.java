import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Main {
    public static final String CASO_A = "a_an_example.in.txt";
	public static final String CASO_B = "b_better_start_small.in.txt";
	public static final String CASO_C = "c_collaboration.in.txt";
	public static final String CASO_D = "d_dense_schedule.in.txt";
	public static final String CASO_E = "e_exceptional_skills.in.txt";
	public static final String CASO_F = "f_find_great_mentors.in.txt";

    public static HashMap<String, Proyecto> proyectos=new HashMap<String, Proyecto>();
    public static HashMap<String, Trabajador> trabajadores=new HashMap<String, Trabajador>();
    
    public static void main(String[] args) {
        System.out.println("Hola mundo");

		Lector l = new Lector(CASO_A, trabajadores, proyectos);
		//trabajadores.forEach((n, t) -> System.out.println(t));

		ArrayList<Proyecto> proyectosA = new ArrayList<>(proyectos.values());
		ArrayList<Trabajador> trabajadoresA = new ArrayList<>(trabajadores.values());

		Asignatronico prueba = new Asignatronico(proyectosA, trabajadoresA);
        prueba.assignProjects();

        /*
		for(Asignacion a: prueba.asignaciones)
        {
            if(a.esViable())
                System.out.println("Buenarda crack");
            else
                System.out.println("Malarda crack");
        }
        */

		OutputPrinter o = new OutputPrinter();
		o.printResult(prueba.asignaciones);
    }

	public static HashMap<String, Trabajador> getTrabajadoresBySkill(Skill skill) {
		HashMap<String, Trabajador> ts = new HashMap<>();

		for (Entry<String, Trabajador> e : trabajadores.entrySet()) {
			for (Skill s : e.getValue().skills) {
				if (skill.equals(s))
					ts.put(e.getKey(), e.getValue());
			}
			
		}
		
		return ts;
	}

	public static HashMap<String, Trabajador> getTrabajadoresBySkillSinNivel(Skill skill) {
		HashMap<String, Trabajador> ts = new HashMap<>();

		for (Entry<String, Trabajador> e : trabajadores.entrySet()) {
			for (Skill s : e.getValue().skills) {
				if (skill.nombre.contentEquals(s.nombre))
					ts.put(e.getKey(), e.getValue());
			}
			
		}
		
		return ts;
	}

	public static boolean contiene(ArrayList<Skill> skills, Skill skill) {
		for (Skill s : skills) {
			if (skill.equals(s))
				return true;
		}
		return false;
	}
}
