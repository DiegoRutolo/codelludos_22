import java.util.ArrayList;

public class Asignacion {
    public Proyecto proyecto;
    public ArrayList<Trabajador> trabajadores;

    public boolean esViable(){
        ArrayList<Skill> roles=proyecto.roles;
        ArrayList<Skill> skills=new ArrayList<Skill>();

        if(roles.size() != trabajadores.size()){
            return false;
        }

        int tamano=roles.size();

        //Cargamos la lista total de habilidades para checkear mentoring
        for (Trabajador t : trabajadores) {
            for (Skill s : t.skills){
                skills.add(s);
            }
        }

        int matchingSkills=0;   //Skills cumplidas
        for (int i=0;i<tamano;i++){
            Skill rol=roles.get(i);
            Trabajador t=trabajadores.get(i);
            boolean matched=false;
            for (Skill s : t.skills){
                if (s.nombre.equals(rol.nombre)){
                    if(s.nivel >= rol.nivel){
                        matchingSkills++;
                        matched=true;
                        continue;
                    }else if(s.nivel == (rol.nivel-1)){
                        boolean mentoring=false;
                        for(Skill m_skill : skills){
                            if(m_skill.nombre.equals(rol.nombre)){
                                if(m_skill.nivel>rol.nivel){
                                    mentoring=true;
                                }
                            }
                        }

                        if(mentoring){
                            matchingSkills++;
                            matched=true;
                            continue;
                        }
                    }
                }
            }
            
            //Si no coinciden puede que no tenga habilidad pero se requiera lvl 1 y haya un mentor
            if(!matched){
                if(rol.nivel==1){
                    boolean mentoring=false;
                    for(Skill m_skill : skills){
                        if(m_skill.nombre.equals(rol.nombre)){
                            if(m_skill.nivel>0){
                                mentoring=true;
                            }
                        }
                    }
                    if (mentoring){
                        matchingSkills++;
                    }
                }
            }
        }

        if(matchingSkills == tamano){
            return true;
        } else {
            return false;
        }
    }
}
