import java.util.ArrayList;

public class Trabajador 
{
	public String nombre;
	public ArrayList<Skill> skills;

	public Trabajador(String nombre)
	{
		this.nombre = nombre;
        skills=new ArrayList<Skill>();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append(nombre);
		sb.append(" (");
		for (Skill s : skills) {
			sb.append(s.nombre);
			sb.append(" ");
			sb.append(s.nivel);
			sb.append(", ");
		}
		sb.deleteCharAt(sb.length() - 1);
		sb.deleteCharAt(sb.length() - 1);
		sb.append(")");

		return sb.toString();
	}

    public ArrayList<String> getSkillNames() {
        ArrayList<String> skillNames = new ArrayList();
        for(Skill skill : skills) {
            skillNames.add(skill.nombre);
        }

        return skillNames;
    }

    public Integer getLevelForSkill(String skillName) {
		for(Skill skill : this.skills) {
			if(skill.nombre.equals(skillName)) {
				return skill.nivel;
			}
		}

		return 0;
	}
}
