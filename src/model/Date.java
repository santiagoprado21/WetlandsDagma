package model;

public class Date {

	private int day;
	private int month;
	private int year;

		/**
	* @deprecated Metodo para definir el dia, mes y ano de la fecha
	* @param day dia 
	* @param month mes
	* @param year ano
	*/

	public Date(int day, int month, int year) {

		this.day = day;
		this.month = month;
		this.year = year;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return day+ "/" + month + "/" + year;
	}
	
	

}
