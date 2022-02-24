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

	public static HashMap<String, Trabajador> trabajadores=new HashMap<String, Trabajador>();
	public static HashMap<String, Proyecto> proyectos=new HashMap<String, Proyecto>();
	
	public static void main(String[] args) {
		System.out.println("Hola mundo");

		Lector l = new Lector(CASO_F, trabajadores, proyectos);
		trabajadores.forEach((n, t) -> System.out.println(t));
	}

	public static Map<String, Trabajador> getTrabajadoresBySill(Skill s) {
		return trabajadores.entrySet().parallelStream()
				.filter(t -> t.getValue().skills.contains(s))
				.collect(Collectors.toMap(Entry::getKey, Entry::getValue));
	}
}
