package model;

import java.util.Iterator;

public class WetlandController {

	private Wetland[] wetlands;

	private Specie[] species;

	private Event[] events;

	public WetlandController() {

		wetlands = new Wetland[80];

		species = new Specie[100];
	}

	/**
	* @deprecated Metodo usado para registrar un humedal 
	* @param nameWetland nombre del humedal
	* @param zoneWetland zona donde esta ubicado el humedal
	* @param typeWetland tipo del humedal
	* @param kmWetland km que delimitan el humedal
	* @param urlWetland url donde se encuentra fotos del humedal
	* @param zoneProtected ver si el humedal esta en una zona protegida
	*/

	public boolean registerWetland(String nameWetland, String zoneWetland, boolean typeWetland, int kmWetland,
			String urlWetland, boolean zoneProtected) {

		boolean stopFlag = false;

		Wetland myWetland = new Wetland(nameWetland, zoneWetland, typeWetland, kmWetland, urlWetland, zoneProtected);

		for (int i = 0; i < wetlands.length && !stopFlag; i++) {

			if (wetlands[i] == null) {

				wetlands[i] = myWetland;

				stopFlag = true;

				System.out.println("guarde al wetland " + wetlands[i].getNameWetland());

			}

		}

		return stopFlag;

	}

	/**
	* @deprecated Metodo usado para anadir una especie a un humedal
	* @param type tipo de la especie
	* @param name nombre de la especie
	* @param scientificName nombre cientifico de la especie
	* @param migratory conocer si la especie es migratoria o no
	*/

	public boolean registerSpecie(String wetland, TypeSpecie type, String name, String scientificName,
			boolean migratory) {

		boolean stopFlag = false;

		Specie mySpecie = new Specie(type, name, scientificName, migratory);

		for (int i = 0; i < wetlands.length && !stopFlag; i++) {

			if (wetlands[i] != null) {

				if (wetlands[i].getNameWetland().equals(wetland)) {

					stopFlag = wetlands[i].addSpecie(type, name, scientificName, migratory);

				}

			}

		}

		return stopFlag;

	}

		/**
	* @deprecated Metodo usado para anadir un evento a un humedal
	* @param eventDate fecha en la que se realiza el evento
	* @param eventOwner organizador del evento
	* @param eventPrice precio del evento
	* @param description descripcion del evento
	* @param type tipo de evento
	*/

	public boolean registerEvent(String wetland, Date eventDate, String eventOwner, int eventPrice, String description,
			EventType type) {

		boolean stopFlag = false;

		Event myEvent = new Event(eventDate, eventOwner, eventPrice, description, type);

		for (int i = 0; i < wetlands.length && !stopFlag; i++) {

			if (wetlands[i] != null) {

				if (wetlands[i].getNameWetland().equals(wetland)) {

					stopFlag = wetlands[i].addEvent(eventDate, eventOwner, eventPrice, description, type);

				}
			}

		}

		return stopFlag;

	}

		/**
	* @deprecated Metodo usado para mostrar las especies con sus atributos
	*/
	
	public String showSpecies() {

		String speciesRegistered = "";

		boolean speciesNullFlag = false;
		
		String migratoryString = "";
		
		for (int i = 0; (i < species.length); i++) {

			if (species[i] == null) {

				speciesNullFlag = true;

			} else {
				
				if (species[i].getMigratory() == true) {

					migratoryString = "Yes";

				} else {

					migratoryString = "No";
				}
				
				speciesRegistered += "\n" + (i + 1) + "." + species[i].getName() + "\nScientific Name: "
						+ species[i].getScientificName() + "\nMigratory: " + migratoryString; 
			}
		
		}
		
		return speciesRegistered;
	}

		/**
	* @deprecated Metodo usado para mostrar los humedales registrados con sus atributos 
	*/

	public String showWetlands() {

		String wetlandsRegistered = "";

		boolean wetlandNullFlag = false;

		String type = "";

		String zoneProtectedString = "";

		for (int i = 0; (i < wetlands.length); i++) {

			if (wetlands[i] == null) {

				wetlandNullFlag = true;

			} else {

				if (wetlands[i].getTypeWetland() == true) {

					type = "Publico";

				} else {

					type = "Privado";
				}

				if (wetlands[i].getZoneProtected() == true) {

					zoneProtectedString = "Si";

				} else {

					zoneProtectedString = "No";
				}

				wetlandsRegistered += "\n" + (i + 1) + "." + wetlands[i].getNameWetland() + "\nZone: "
						+ wetlands[i].getZoneWetland() + "\nKm: " + wetlands[i].getKmWetland() + "\nUrl: "
						+ wetlands[i].getUrlWetland() + "\nEl tipo del humedal es: " + type + "\nZona protegida: "
						+ zoneProtectedString;

			}

		}

		return wetlandsRegistered;
	}

		/**
	* @deprecated Metodo usado para mostrar los mantenimientos de un humedal en una ano en especifico
	* @param year ano en el que se realizo el mantenimiento
	* @param wetland nombre del humedal 
	*/

	public int showManteinces(int year, String wetland) {

		boolean stopFlag = false;

		int contador = 0;

		for (int i = 0; i < wetlands.length && !stopFlag; i++) {

			if (wetlands[i] != null) {

				if (wetlands[i].getNameWetland().equals(wetland)) {

					stopFlag = true;

					Event[] array = wetlands[i].getEvent();

					for (int j = 0; j < array.length; j++) {

						if (array[j] != null) {

							if (array[j].getType().equals(EventType.MAINTENANCE)) {

								if (array[j].getDate().getYear() == year) {

									contador++;

								}
							}

						}
					}

				}

			}

		}

		return contador;

	}

		/**
	* @deprecated Metodo usado para mostrar el humedal con menor cantidad de especies de flora
	*/

	public String showSpeciesFlora() {

		int quantityFlora = 0;

		String wetland = "";

		for (int i = 0; i < wetlands.length; i++) {

			if (wetlands[i] != null) {

				for (int j = 0; j < species.length; j++) {

					int quantityActual = 0;

					if (wetlands[i].getSpecies()[j] != null) {

						if (wetlands[i].getSpecies()[j].getType().equals(TypeSpecie.AQUATIC_FLORA)
								|| wetlands[i].getSpecies()[j].getType().equals(TypeSpecie.LAND_FLORA)) {

							quantityActual += 1;

							if (quantityActual !=  0 && quantityFlora<quantityActual) {	

								quantityFlora = quantityActual;
								wetland = wetlands[i].getNameWetland();
							}

							
						}
					}

				}

			}

		}

		return wetland;
	}

		/**
	* @deprecated metodo para mostrar en que humedales estan una especie en especifico
	* @param type tipo de especie que va a buscar el usuario 
	*/

	public String showWetlandsSpecie(String type) {

		String wetlandsNames = "";

		boolean stopFlag = false;

		for (int i = 0; i < wetlands.length && !stopFlag; i++) {

			if (wetlands[i] != null) {

				wetlands[i].getSpecies();

				for (int j = 0; j < species.length; j++) {

					if (wetlands[i].getSpecies()[j].getType().equals(typeSpecie)) {

						stopFlag = true;

						wetlandsNames += "\n" + (i + 1) + "." + wetlands[i].getNameWetland();
					}
				}
			}
		}

		return wetlandsNames;
	}

		/**
	* @deprecated Metodo usado para mostrar el humedal con mayor numero de especies registradas
	*/

	public String showTotalSpecies() {

		int quantity = 0;

		String wetland = "";

		for (int i = 0; i < wetlands.length; i++) {

			if (wetlands[i] != null) {

				int quantityActual = 0;

				for (int j = 0; j < species.length; j++) {

					if (wetlands[i].getSpecies()[j] != null) {
						
						if (wetlands[i].getSpecies()[j].getType().equals(TypeSpecie.AQUATIC_FLORA)
								|| wetlands[i].getSpecies()[j].getType().equals(TypeSpecie.LAND_FLORA)
								|| wetlands[i].getSpecies()[j].getType().equals(TypeSpecie.BIRD_FAUNA)
								|| wetlands[i].getSpecies()[j].getType().equals(TypeSpecie.MAMMAL_FAUNA)
								|| wetlands[i].getSpecies()[j].getType().equals(TypeSpecie.AQUATIC_FAUNA)) {

							quantityActual += 1;
						}

					}
				}

				if (quantityActual > quantity) {

					quantity = quantityActual;

					wetland = wetlands[i].getNameWetland();
				}

			}

		}

		return wetland;
	}

}