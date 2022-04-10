package ui;

import java.util.Scanner;

import model.*;

	/**
	* @deprecated nombre de la clase principal
	*/

public class WetlandManager {

	public static Scanner sc;

	public static WetlandController controller;

	public static void main(String[] args) {

		init();
		menu();
	}

		/**
	* @deprecated Metodo usado para definir el escaner y la controladora
	*/

	public static void init() {

		sc = new Scanner(System.in);
		controller = new WetlandController();
	}

		/**
	* @deprecated Metodo usado para crear un menu
	*/

	public static void menu() {

		System.out.println("Bienvenido al registro de los humedales del municipio de Santiago De Cali ");

		boolean flag = false;

		while (!flag) {

			System.out.println("\nPor favor elija la opcion que desee ejecutar: ");
			System.out.println("1. Crear un humedal ");
			System.out.println("2. Registrar una nueva especie en un humedal ");
			System.out.println("3. Registrar un evento en un humedal ");
			System.out.println("4. Mostrar la cantidad de mantenimientos de un humedal en un año ");
			System.out.println("5. Mostrar cual es el humedal con menor cantidad de especies de flora ");
			System.out.println("6. Mostrar en que humedales se encuentra una especie en especifico ");
			System.out.println("7. Mostrar la informacion completa de todos los humedales registrados ");
			System.out.println("8. Mostrar el humedal con mayor cantidad de animales ");
			System.out.println("0. Terminar el programa");

			int primaryOption = sc.nextInt();

			switch (primaryOption) {

			case 1:

				registerWetland();

				break;

			case 2:

				registerSpecies();

				break;

			case 3:

				registerEvent();

				break;

			case 4:

				showManteince();

				break;

			case 5:

				showFloraWetland();

				break;

			case 6:

				//no pude hacerlo

			case 7:

				showInfoWetlands();

				break;

			case 8:

				showWetlandMoreSpecies();

				break;

			case 0:

				flag = true;

				break;

			}
		}
	}

		/**
	* @deprecated Metodo usado para pedir los datos del humedal al usuario
	*/

	public static void registerWetland() {

		System.out.println("Por favor ingrese el nombre del humedal ");

		String nameWetland = sc.nextLine();

		nameWetland = sc.nextLine();

		System.out.println("Por favor ingrese la zona en la que esta ubicado el humedal ");

		String zoneWetland = sc.nextLine();

		sc.nextLine();

		System.out.println("Por favor ingrese 1 si el humedal es publico, de lo contrario ingrese 2: ");

		int typeWetland = sc.nextInt();

		boolean typeWetlandBoolean = true;

		switch (typeWetland) {

		case 1:

			typeWetlandBoolean = true;

			System.out.println("El humedal es de tipo publico ");

			break;

		case 2:

			typeWetlandBoolean = false;

			System.out.println("El humedal es de tipo privado ");

			break;

		}

		sc.nextLine();

		System.out.println("Por favor ingrese la cantidad de km2 que delimita el humedal ");

		int kmWetland = sc.nextInt();

		sc.nextLine();

		System.out.println("Por favor ingrese el URL de la foto del humedal ");

		String urlWetland = sc.nextLine();

		sc.nextLine();

		System.out.println("Por favor escriba 1 si el humedal esta en una zona protegida, escriba 2 si no es asi ");

		int zoneProtected = sc.nextInt();

		boolean zoneProtectedBoolean = true;

		switch (zoneProtected) {

		case 1:

			zoneProtectedBoolean = true;

			System.out.println("El humedal se encuentra en una zona protegida");

			break;

		case 2:

			zoneProtectedBoolean = false;

			System.out.println("El humnedal no se encuentra en una zona protegida");

			break;
		}

		if (controller.registerWetland(nameWetland, zoneWetland, typeWetlandBoolean, kmWetland, urlWetland,
				zoneProtectedBoolean)) {

			System.out.println("El humedal " + nameWetland + "fue registrado exitosamente");

		} else {

			System.out.println("El humedal " + nameWetland + "no pudo ser registrado");

		}

	}

		/**
	* @deprecated Metodo usado para tomar los datos de una especie y registrarlo en un humedal
	*/

	public static void registerSpecies() {

		System.out.println("Por favor ingrese el nombre del humedal al que quiere anadir la especie ");

		String wetland = sc.nextLine();

		wetland = sc.nextLine();

		System.out.println("Por favor ingrese el nombre de la especie ");

		String name = sc.nextLine();

		name = sc.nextLine();

		System.out.println("Por favor ingrese el nombre cientifico de la especie ");

		String scientificName = sc.nextLine();

		System.out.println("Digite 1 si la especie es migratoria, 2 de lo contrario ");

		int migratory = sc.nextInt();

		sc.nextLine();

		boolean migratoryBoolean = true;

		switch (migratory) {

		case 1:

			migratoryBoolean = true;

			System.out.println("La especie es migratoria");

			break;
		case 2:

			migratoryBoolean = false;

			System.out.println("La especie no es migratoria");

			break;

		}

		System.out.println(
				"Digite el numero de su tipo de especie\n1.Land_Flora\n2.Aquatic_Flora\n3.Bird_Fauna\n4.Mammal_Fauna\n5.Aquatic_Fauna");

		String type = sc.nextLine();

		sc.nextLine();

		switch (Integer.valueOf(type)) {

		case 1:

			type = "LAND_FLORA";

			break;

		case 2:

			type = "AQUATIC_FLORA";

			break;

		case 3:

			type = "BIRD_FAUNA";

			break;

		case 4:

			type = "MAMMAL_FAUNA";

			break;

		case 5:

			type = "AQUATIC_FAUNA";

			break;
		}

		System.out.println("El tipo es " + type);

		TypeSpecie typeSpecie = TypeSpecie.valueOf(type);

		if (controller.registerSpecie(wetland, typeSpecie, name, scientificName, migratoryBoolean)) {

			System.out.println("La especie ha sido registrada exitosamente! ");

		} else {

			System.out.println("La especie no ha sido registrada exitosamente ");

		}
	}

		/**
	* @deprecated Metodo usado para registrar los datos de un evento y registrarlo a un humedal
	*/

	public static void registerEvent() {

		System.out.println("Por favor ingrese el nombre del humedal al que quiere anadir el evento ");

		String wetland = sc.nextLine();

		wetland = sc.nextLine();

		System.out.println("Por favor ingrese el dia del evento");

		int day = sc.nextInt();

		System.out.println("Por favor ingrese el mes del evento");

		int month = sc.nextInt();

		System.out.println("Por favor ingrese el año del evento");

		int year = sc.nextInt();

		Date myDate = new Date(day, month, year);

		System.out.println("Por favor ingrese el nombre de quien realiza el evento ");

		String eventOwner = sc.nextLine();

		sc.nextLine();

		System.out.println("Por favor ingrese el precio del evento");

		int eventPrice = sc.nextInt();

		sc.nextLine();

		System.out.println("Por favor ingrese una descripcion del evento ");

		String description = sc.nextLine();

		System.out.println("Por favor digite el numero correspondiente a el tipo de evento:" + "\n1.Maintenance"
				+ "\n2.School_Visits" + "\n3.Upgrade_Activities" + "\n4.Celebration");

		String type = sc.nextLine();

		switch (Integer.valueOf(type)) {

		case 1:

			type = "MAINTENANCE";

			break;

		case 2:

			type = "SCHOOL_VISITS";

			break;

		case 3:

			type = "UPGRADE_ACTIVITIES";

			break;

		case 4:

			type = "CELEBRATION";

			break;
		}

		System.out.println("El tipo es " + type);

		EventType eventType = EventType.valueOf(type);

		if (controller.registerEvent(wetland, myDate, eventOwner, eventPrice, description, eventType)) {

			System.out.println("El evento ha sido registrado exitosamente! ");

		} else {

			System.out.println("El evento no fue registrado exitosamente ");
		}

	}

		/**
	* @deprecated Metodo usado para mostrar cuantos eventos de tipo mantenimiento se han realizado en un ano especifico
	*/

	public static void showManteince() {

		System.out.println("Por favor ingrese el año que desea conocer los eventos ");

		int year = sc.nextInt();

		sc.nextLine();

		System.out.println("Por favor ingresar el nombre del humedal ");

		String wetland = sc.nextLine();

		int method = controller.showManteinces(year, wetland);

		System.out.println(
				"El humedal " + wetland + " tuvo un total de " + method + " mantenimientos, en el año " + year);

	}

		/**
	* @deprecated Metodo usado para mostrar la informacion de los humedales completa
	*/

	public static void showInfoWetlands() {

		String infoWetlands = controller.showWetlands();

		System.out.println("La informacion completa de los humedales es la siguiente: \n" + infoWetlands);
		
		String infoSpecies = controller.showSpecies();
		
		System.out.println("La informacion de las especies es la siguiente: \n" + infoSpecies);

	}

		/**
	* @deprecated Metodo usado para mostrar el humedal con menor cantidad de especies de flora
	*/

	public static void showFloraWetland() {

		String wetlandFlora = controller.showSpeciesFlora();

		System.out.println("El humedal con menor cantidad de especies de flora es: " + wetlandFlora);
	}

		/**
	* @deprecated Metodo usado para mostrar el nombre del humedal con mayor numero de especies registradas
	*/

	public static void showWetlandMoreSpecies() {

		String wetlandTotalSpecies = controller.showTotalSpecies();

		System.out.println("El humedal con mayor cantidad de especies registradas es: " + wetlandTotalSpecies);
	}

}