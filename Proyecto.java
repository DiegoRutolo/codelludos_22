import java.util.ArrayList;

public class Proyecto implements Comparable<Proyecto> {
    public String nombre;
    public int diasNecesarios;
    public int puntuacion;
    public int diaLimite;
    public ArrayList<Skill> roles;

    public Proyecto(String nombre, Integer diasNecesarios, Integer puntuacion, Integer diaLimite)
    {
        this.nombre = nombre;
        this.diasNecesarios = diasNecesarios;
        this.puntuacion = puntuacion;
        this.diaLimite = diaLimite;
    }

    public int compareTo(Proyecto other) {
        if(this.getPuntuacion() > other.getPuntuacion())
            return 1;
        else if (this.getPuntuacion() == other.getPuntuacion())
            return 0 ;
        return -1 ;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDiasNecesarios() {
        return diasNecesarios;
    }

    public void setDiasNecesarios(int diasNecesarios) {
        this.diasNecesarios = diasNecesarios;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public int getDiaLimite() {
        return diaLimite;
    }

    public void setDiaLimite(int diaLimite) {
        this.diaLimite = diaLimite;
    }

    public ArrayList<Skill> getRoles() {
        return roles;
    }

    public void setRoles(ArrayList<Skill> roles) {
        this.roles = roles;
    }
}
