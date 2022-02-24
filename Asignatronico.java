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

    public Asignatronico(ArrayList<Proyecto> proyectosPendientes, ArrayList<Trabajador> trabajadoresLibres) {
        this.proyectosPendientes = proyectosPendientes;
        this.trabajadoresLibres = trabajadoresLibres;
        this.trabajadoresAsignados = new ArrayList<>();
        this.proyectosAsignados = new ArrayList<>();
        this.asignaciones = new ArrayList<>();

    }

    public Asignatronico(ArrayList<Proyecto> proyectosPendientes, ArrayList<Proyecto> proyectosAsignados, ArrayList<Trabajador> trabajadoresLibres, ArrayList<Trabajador> trabajadoresAsignados, Proyecto firstToComplete) {
        this.proyectosPendientes = proyectosPendientes;
        this.proyectosAsignados = proyectosAsignados;
        this.trabajadoresLibres = trabajadoresLibres;
        this.trabajadoresAsignados = trabajadoresAsignados;
        this.firstToComplete = firstToComplete;
    }

    public void assignProjects() {
        Integer currentDay = 0;
        do {
            asignRoundOfProjects();
//            Integer maxDia = getMaximumDurationHigherThan(currentDay);
            this.trabajadoresLibres.addAll(trabajadoresAsignados);
            this.trabajadoresAsignados = new ArrayList<>();
//            currentDay = maxDia;
        } while(this.proyectosPendientes.size() > 0);




//        Integer diaProvisional = getMinimunDurationHigherThan(0);
//        ArrayList<Asignacion> finishedProjects = getProjectsWithDuration(diaProvisional);
//        ArrayList<Trabajador> provTrabajadoresLibres = (ArrayList<Trabajador>) this.trabajadoresLibres.clone();
//        for(Asignacion asignacion : finishedProjects) {
//            provTrabajadoresLibres.addAll(asignacion.trabajadores);
//        }
//        ArrayList<Trabajador> provTrabajadoresAsignados = (ArrayList<Trabajador>) this.trabajadoresAsignados.clone();
//        for(Asignacion asignacion : finishedProjects) {
//            provTrabajadoresAsignados.removeAll(asignacion.trabajadores);
//        }
//        Integer completedProjects = falseAsignRoundOfProjects((ArrayList<Proyecto>) this.proyectosPendientes.clone(), (ArrayList<Proyecto>)this.proyectosAsignados.clone(), provTrabajadoresLibres, provTrabajadoresAsignados, (ArrayList<Asignacion>)this.asignaciones.clone());
//        if(completedProjects > 0) {
//            asignRoundOfProjects();
//        } else {
//            Integer secondDiaProvisional = getMinimunDurationHigherThan(diaProvisional);
//            ArrayList<Asignacion> secondFinishedProjects = getProjectsWithDuration(secondDiaProvisional);
//        }
    }

    public Integer checkPossibleCompletedProjects() {
        Integer diaProvisional = getMinimunDurationHigherThan(0);
        ArrayList<Asignacion> finishedProjects = getProjectsWithDuration(diaProvisional);
        ArrayList<Trabajador> provTrabajadoresLibres = (ArrayList<Trabajador>) this.trabajadoresLibres.clone();
        for(Asignacion asignacion : finishedProjects) {
            provTrabajadoresLibres.addAll(asignacion.trabajadores);
        }
        ArrayList<Trabajador> provTrabajadoresAsignados = (ArrayList<Trabajador>) this.trabajadoresAsignados.clone();
        for(Asignacion asignacion : finishedProjects) {
            provTrabajadoresAsignados.removeAll(asignacion.trabajadores);
        }
        Integer completedProjects = falseAsignRoundOfProjects((ArrayList<Proyecto>) this.proyectosPendientes.clone(), (ArrayList<Proyecto>)this.proyectosAsignados.clone(), provTrabajadoresLibres, provTrabajadoresAsignados, (ArrayList<Asignacion>)this.asignaciones.clone());

        return completedProjects;
    }

    public Integer getMinimunDurationHigherThan(int threshold) {
        Integer minimunDuration = Integer.MAX_VALUE;
        for(Asignacion asignacion : asignaciones) {
            // Clear all pending projects that has been asigned
            proyectosPendientes.remove(asignacion.proyecto);
            if(asignacion.proyecto.diasNecesarios < minimunDuration) {
                minimunDuration = asignacion.proyecto.diasNecesarios;
            }
        }

        return minimunDuration;
    }

    public Integer getMaximumDurationHigherThan(int threshold) {
        Integer maximumDuration = Integer.MAX_VALUE;
        for(Asignacion asignacion : asignaciones) {
            // Clear all pending projects that has been asigned
            proyectosPendientes.remove(asignacion.proyecto);
            if(asignacion.proyecto.diasNecesarios > maximumDuration) {
                maximumDuration = asignacion.proyecto.diasNecesarios;
            }
        }

        return maximumDuration;
    }

    public ArrayList<Asignacion> getProjectsWithDuration(int duration) {
        ArrayList<Asignacion> projects = new ArrayList<>();
        for(Asignacion asignacion : asignaciones) {
            if(asignacion.proyecto.diasNecesarios <= duration)  {
                projects.add(asignacion);
            }
        }

        return projects;
    }

    public Integer asignRoundOfProjects() {
        Integer numberOfAsignedProjects = 0;
        for(int indexProyecto = 0 ; indexProyecto < proyectosPendientes.size(); indexProyecto++) {
            Proyecto currentProject = proyectosPendientes.get(indexProyecto);
            Asignacion provAsignacion = new Asignacion();
            provAsignacion.proyecto = currentProject;
            for(Skill rol : currentProject.roles) {
                Trabajador bestWorker = null;
                for(int indexTrabajador = 0 ; indexTrabajador < trabajadoresLibres.size(); indexTrabajador++) {
                    Trabajador currentWorker = trabajadoresLibres.get(indexTrabajador);
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
                proyectosPendientes.remove(currentProject);
                numberOfAsignedProjects++;
            } else {
                // Return workers to free state and clean the asigned array
                trabajadoresAsignados.removeAll(provAsignacion.trabajadores);
                trabajadoresLibres.addAll(provAsignacion.trabajadores);
            }
        }

        return numberOfAsignedProjects;
    }

    public Integer falseAsignRoundOfProjects(ArrayList<Proyecto> proyectosPendientes, ArrayList<Proyecto> proyectosAsignados,
                                             ArrayList<Trabajador> trabajadoresLibres, ArrayList<Trabajador> trabajadoresAsignados,
                                             ArrayList<Asignacion> asignaciones) {
        Integer numberOfAsignedProjects = 0;
        for(int indexProyecto = 0 ; indexProyecto < proyectosPendientes.size(); indexProyecto++) {
            Proyecto currentProject = proyectosPendientes.get(indexProyecto);
            Asignacion provAsignacion = new Asignacion();
            provAsignacion.proyecto = currentProject;
            for(Skill rol : currentProject.roles) {
                Trabajador bestWorker = null;
                for(int indexTrabajador = 0 ; indexTrabajador < trabajadoresLibres.size(); indexTrabajador++) {
                    Trabajador currentWorker = trabajadoresLibres.get(indexTrabajador);
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
                proyectosPendientes.remove(currentProject);
                numberOfAsignedProjects++;
            } else {
                // Return workers to free state and clean the asigned array
                // TODO: Do not erase all asigned, only the current
                trabajadoresAsignados.removeAll(provAsignacion.trabajadores);
                trabajadoresLibres.addAll(provAsignacion.trabajadores);
            }
        }

        return numberOfAsignedProjects;
    }
}
