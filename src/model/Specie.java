package model;

public class Specie {
	
	private TypeSpecie type;
	private String name;
	private String scientificName;
	private boolean migratory;

	/**
	* @deprecated Metodo usado para definir los atributos de la especie
	* @param type tipo de la especie
	* @param name nombre de la especie
	* @param scientificName nombre cientifico de la especie
	* @param migratory conocer si la especie es migratoria o no
	*/

	public Specie(TypeSpecie type,String name,String scientificName,boolean migratory){

		this.type = type;
		this.name = name;
		this.scientificName = scientificName;
		this.migratory = migratory;

	}

	public TypeSpecie getType(){

		return type;
	}

	public void setType(TypeSpecie type){

		this.type = type;
	}

	public String getName(){

		return name;
	}

	public void setName(String name){

		this.name = name;
	}

	public String getScientificName(){

		return scientificName;
	}

	public void setScientificName(String scientificName){

		this.scientificName = scientificName;
	}

	public boolean getMigratory(){

		return migratory;
	}

	public void setMigratory(boolean migratory){

		this.migratory = migratory;
	}

	@Override
	public String toString() {

		return "Specie info:\nName: " + name 
		+ "\nScientific Name: " + scientificName
		+ "\nType: " + type
		+ "\nMigratory: " + migratory;




	}
}
