import java.util.ArrayList;

public class Asignatronico {

    public ArrayList<Proyecto> proyectosPendientes;
    public ArrayList<Proyecto> proyectosAsignados;
    public ArrayList<Trabajador> trabajadoresLibres;
    public ArrayList<Trabajador> trabajadoresAsignados;
    public ArrayList<Asignacion> asignaciones;
    public Proyecto firstToComplete;
    public Integer diaActual = 0;

    public Asignatronico() {
        this.proyectosPendientes = new ArrayList<>();
        this.proyectosAsignados = new ArrayList<>();
        this.trabajadoresLibres = new ArrayList<>();
        this.trabajadoresAsignados = new ArrayList<>();
        this.asignaciones = new ArrayList<>();
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
            Asignacion provAsignacion = new Asignacion();
            provAsignacion.proyecto = currentProject;
            for(Skill rol : currentProject.roles) {
                Trabajador bestWorker = null;
                for(int indexTrabajador = 0 ; indexTrabajador < trabajadoresLibres.size(); indexTrabajador++) {
                    Trabajador currentWorker = trabajadoresAsignados.get(indexTrabajador);
                    if(currentWorker.getSkillNames().contains(rol.nombre)) {
                        if(currentWorker.getLevelForSkill(rol.nombre) >= rol.nivel) {
                            if(bestWorker == null) {
                                bestWorker = currentWorker;
                            } else if (currentWorker.getLevelForSkill(rol.nombre) < bestWorker.getLevelForSkill(rol.nombre)) {
                                bestWorker = currentWorker;
                            }
                        }
                    }
                }
                if(bestWorker != null) {
                    provAsignacion.trabajadores.add(bestWorker);
                    trabajadoresLibres.remove(bestWorker);
                    trabajadoresAsignados.add(bestWorker);
                }
            }
            if(provAsignacion.trabajadores.size() == currentProject.roles.size()) {
                // Result is good, set project as asigned
                asignaciones.add(provAsignacion);
                proyectosAsignados.add(currentProject);
            } else {
                // Return workers to free state and clean the asigned array
                for(Trabajador trabajador : trabajadoresAsignados) {
                    trabajadoresLibres.add(trabajador);
                }
                trabajadoresAsignados = new ArrayList<>();
            }
        }

        for(Asignacion asignacion : asignaciones) {
            // Clear all pending projects that has been asigned
            proyectosPendientes.remove(asignacion.proyecto);
        }
    }

}