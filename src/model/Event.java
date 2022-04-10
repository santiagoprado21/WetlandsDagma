package model;

public class Event {

	private Date eventDate;
	
	private String eventOwner;

	private int eventPrice;

	private String description;

	private EventType type;

		/**
	* @deprecated Metodo usado para anadir un evento a un humedal
	* @param eventDate fecha en la que se realiza el evento
	* @param eventOwner organizador del evento
	* @param eventPrice precio del evento
	* @param description descripcion del evento
	* @param type tipo de evento
	*/


	public Event (Date eventDate,String eventOwner,int eventPrice,String description,EventType type){

		this.eventDate = eventDate;
		this.eventOwner = eventOwner;
		this.eventPrice = eventPrice;
		this.description = description;
		this.type = type;
	}

	public Date getDate(){

		return eventDate;
	}

	public void setDate(Date eventDate){

		this.eventDate = eventDate;
	}

	public EventType getType() {

		return type;
	}

	public void setType(EventType type) {
		this.type = type;
	}
	
	public String getEventOwner() {
		return eventOwner;
	}

	public void setEventOwner(String eventOwner) {
		this.eventOwner = eventOwner;
	}

	public int getEventPrice() {
		return eventPrice;
	}

	public void setEventPrice(int eventPrice) {
		this.eventPrice = eventPrice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "La fecha del evento es: " + eventDate.toString() 
		+"\nEl dueño del evento es: " + eventOwner
		+"\nEl precio del evento es " + eventPrice
		+"\nY la descripcion del evento es: " + description;

	}
}
