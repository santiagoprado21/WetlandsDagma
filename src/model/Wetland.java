package model;

public class Wetland {
	 
	private String nameWetland;

	private String zoneWetland;

	private boolean typeWetland;

	private int kmWetland;

	private String urlWetland;

	private boolean zoneProtected;

	private Specie[] species;

	private Event[] events;

	/**
	* @deprecated Metodo usado para especificar los atributos de la clase wetland
	* @param nameWetland nombre del humedal
	* @param zoneWetland zona donde esta ubicado el humedal
	* @param typeWetland tipo del humedal
	* @param kmWetland km que delimitan el humedal
	* @param urlWetland url donde se encuentra fotos del humedal
	* @param zoneProtected ver si el humedal esta en una zona protegida
	*/

	public Wetland(String nameWetland,String zoneWetland,boolean typeWetland, int kmWetland, String urlWetland, boolean zoneProtected){

		this.nameWetland = nameWetland;
		this.zoneWetland = zoneWetland;
		this.typeWetland = typeWetland;
		this.kmWetland = kmWetland;
		this.urlWetland = urlWetland;
		this.zoneProtected = zoneProtected;
		species = new Specie[100];
		events = new Event[100];

	}

	/**
	* @deprecated Metodo usado para anadir una especie 
	* @param type tipo de la especie
	* @param name nombre de la especie
	* @param scientificName nombre cientifico de la especie
	* @param migratory conocer si la especie es migratoria o no
	*/

	public boolean addSpecie(TypeSpecie type, String name, String scientificName,boolean migratory){

		boolean stopFlag = false;

		Specie mySpecie = new Specie(type,name,scientificName,migratory);

		for (int i = 0; i < species.length && !stopFlag; i++){

			if (species[i] == null){

				species[i] = mySpecie;
				
				stopFlag = true;

			}

		}

		return stopFlag;
	}

	/**
	* @deprecated Metodo usado para anadir un evento
	* @param eventDate fecha en la que se realiza el evento
	* @param eventOwner organizador del evento
	* @param eventPrice precio del evento
	* @param description descripcion del evento
	* @param type tipo de evento
	*/

		public boolean addEvent(Date eventDate,String eventOwner,int eventPrice,String description,EventType type){

		boolean stopFlag = false;

		Event myEvent = new Event(eventDate,eventOwner,eventPrice,description,type);

		for (int i = 0; i < events.length && !stopFlag; i++){

			if (events[i] == null){

				events[i] = myEvent;
				
				stopFlag = true;

			}

		}

		return stopFlag;
	}



	public String getNameWetland(){

		return nameWetland;
	}

	public void setNameWetland(String nameWetland){

		this.nameWetland = nameWetland;
	}

	public String getZoneWetland(){

		return zoneWetland;
	}

	public void setZoneWetland(String zoneWetland){

		this.zoneWetland = zoneWetland;
	}

	public boolean getTypeWetland(){

		return typeWetland;
	}

	public void setTypeWetland(boolean typeWetland){

		this.typeWetland = typeWetland;
	}

	public int getKmWetland(){

		return kmWetland;
	}

	public void setKmWetland(int kmWetland){

		this.kmWetland = kmWetland;
	}

	public String getUrlWetland(){

		return urlWetland;
	}

	public void setUrlWetland(String urlWetland){

		this.urlWetland = urlWetland;
	}

	public boolean getZoneProtected(){

		return zoneProtected;
	}

	public void setZoneProtected(boolean zoneProtected){

		this.zoneProtected = zoneProtected;
	}
	

	@Override
	public String toString(){

		return "Wetland info:\nName: " + nameWetland 
		+ "\nZone: " + zoneWetland 
		+ "\nType: " + typeWetland
		+ "\nKm: " + kmWetland
		+ "\nUrl: " + urlWetland
		+ "\nStatus: " + zoneProtected; 

	}

	public Specie[] getSpecies(){

		return species;

	}

	public void setSpecies(Specie[] species){

		this.species = species;
	}
	
	public Event[] getEvent() {
		
		return this.events;
	}	
	
	public void setEvent(Event[] events){

		this.events = events;
	}
	
}
