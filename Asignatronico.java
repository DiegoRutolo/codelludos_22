import java.util.ArrayList;

public class Asignatronico {

    public ArrayList<Proyecto> proyectosPendientes;
    public ArrayList<Proyecto> proyectosAsignados;
    public ArrayList<Trabajador> trabajadoresLibres;
    public ArrayList<Trabajador> trabajadoresAsignados;
    public Proyecto firstToComplete;
    public Integer diaActual = 0;

    public Asignatronico() {
        this.proyectosPendientes = new ArrayList<>();
        this.proyectosAsignados = new ArrayList<>();
        this.trabajadoresLibres = new ArrayList<>();
        this.trabajadoresAsignados = new ArrayList<>();
    }

    public Asignatronico(ArrayList<Proyecto> proyectosPendientes, ArrayList<Proyecto> proyectosAsignados, ArrayList<Trabajador> trabajadoresLibres, ArrayList<Trabajador> trabajadoresAsignados, Proyecto firstToComplete) {
        this.proyectosPendientes = proyectosPendientes;
        this.proyectosAsignados = proyectosAsignados;
        this.trabajadoresLibres = trabajadoresLibres;
        this.trabajadoresAsignados = trabajadoresAsignados;
        this.firstToComplete = firstToComplete;
    }

    public void asignProjects() {
        for(int indexProyecto = 0 ; indexProyecto < proyectosPendientes.size(); indexProyecto++) {
            Proyecto currentProject = proyectosPendientes.get(indexProyecto);
            for(Skill rol : currentProject.roles) {
                Trabajador bestWorker = null;
                for(int indexTrabajador = 0 ; indexTrabajador < trabajadoresLibres.size(); indexTrabajador++) {
                    Trabajador currentWorker = trabajadoresAsignados.get(indexTrabajador);
                    if(currentWorker.getSkillNames().contains(rol.nombre)) {
//                        if()
                    }
                }
            }

        }
    }

}
