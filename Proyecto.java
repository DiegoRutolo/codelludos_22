import java.util.ArrayList;

public class Proyecto 
{
    public String Nombre;
    public Integer DiasNecesarios;
    public Integer Puntuacion;
    public Integer DiaLimite;
    public ArrayList<Skill> Roles;

    public Proyecto(String nombre, Integer diasNecesarios, Integer puntuacion, Integer diaLimite)
    {
        this.Nombre = nombre;
        this.DiasNecesarios = diasNecesarios;
        this.Puntuacion = puntuacion;
        this.DiaLimite = diaLimite;
    }
}
