public class Skill {
	public String nombre;
	public int nivel;

	public Skill(){};

	public Skill(String nombre, int nivel){
		this.nombre=nombre;
		this.nivel=nivel;
	}

	@Override
	public String toString() {
		return String.format("%s %d", nombre, nivel);
	}
}
