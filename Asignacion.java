import java.util.ArrayList;
import java.util.HashMap;

public class Asignacion {
    public Proyecto proyecto;
    public ArrayList<Trabajador> trabajadores;
    public HashMap<Skill, Trabajador> asignaciones;

    public void setAsignaciones(ArrayList<Skill> skills, ArrayList<Trabajador> trabajadores) throws Exception {
        this.asignaciones = new HashMap<>();
        if(skills.size() != trabajadores.size()) {
            throw new Exception("Error asignando skills y trabajadores");
        }
    }
}
