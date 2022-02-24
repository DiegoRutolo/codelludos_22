import java.util.ArrayList;

public class Proyecto 
{
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
}
