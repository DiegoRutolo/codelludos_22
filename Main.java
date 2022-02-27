import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Main {
	
    public static final CASO_STRUCT CASO_A = new CASO_STRUCT("a_an_example.in.txt", "a_an_example.out.txt");
	public static final CASO_STRUCT CASO_B = new CASO_STRUCT("b_better_start_small.in.txt", "b_better_start_small.out.txt");
	public static final CASO_STRUCT CASO_C = new CASO_STRUCT("c_collaboration.in.txt", "c_collaboration.out.txt");
	public static final CASO_STRUCT CASO_D = new CASO_STRUCT("d_dense_schedule.in.txt", "d_dense_schedule.out.txt");
	public static final CASO_STRUCT CASO_E = new CASO_STRUCT("e_exceptional_skills.in.txt", "e_exceptional_skills.out.txt");
	public static final CASO_STRUCT CASO_F = new CASO_STRUCT("f_find_great_mentors.in.txt", "f_find_great_mentors.out.txt");

    public static HashMap<String, Proyecto> proyectos=new HashMap<String, Proyecto>();
    public static HashMap<String, Trabajador> trabajadores=new HashMap<String, Trabajador>();
    
    public static void main(String[] args) {
        System.out.println("Hola mundo");

		FileManager fm = new FileManager(CASO_E);
		fm.readFile();
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

		fm.writeResult(prueba.asignaciones);
    }

	public static void cleanMemory(){
		proyectos.clear();
		trabajadores.clear();
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
