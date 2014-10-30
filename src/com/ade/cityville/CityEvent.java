package com.ade.cityville;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;


public class CityEvent {
	private float cost;
	private double rating;
	private int id, age;
	private String date, time, name, description, img, location, phonenumber;
	private Calendar datentime;
	
	public CityEvent(int aid, String adate, String atime, String aname, 
			String alocation, String apn, float acost, double arating, int aage, 
			String adescription, String aimg) throws ParseException{
		
		id = aid;
		datentime = stringToCalendar(adate + "T" + atime, TimeZone.getTimeZone("GMT -4:00"));
		name = aname;
		location = alocation;
		phonenumber = apn;
		cost = acost;
		rating = arating;
		age = aage;
		description = adescription;
		img = aimg;
		
	}
	
	
	public static Calendar stringToCalendar(String strDate, TimeZone timezone) throws ParseException {
        String FORMAT_DATETIME = "yyyy-MM-dd'T'HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_DATETIME);
        sdf.setTimeZone(timezone);
        Date date = sdf.parse(strDate);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }


	/**
	 * @return the cost
	 */
	public float getCost() {
		return cost;
	}


	/**
	 * @param cost the cost to set
	 */
	public void setCost(float cost) {
		this.cost = cost;
	}


	/**
	 * @return the rating
	 */
	public double getRating() {
		return rating;
	}


	/**
	 * @param rating the rating to set
	 */
	public void setRating(double rating) {
		this.rating = rating;
	}


	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}


	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}


	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}


	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}


	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}


	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}


	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}


	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}


	/**
	 * @return the img
	 */
	public String getImg() {
		return img;
	}


	/**
	 * @param img the img to set
	 */
	public void setImg(String img) {
		this.img = img;
	}


	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}


	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}


	/**
	 * @return the phonenumber
	 */
	public String getPhonenumber() {
		return phonenumber;
	}


	/**
	 * @param phonenumber the phonenumber to set
	 */
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}


	/**
	 * @return the datentime
	 */
	public Calendar getDatentime() {
		return datentime;
	}


	/**
	 * @param datentime the datentime to set
	 */
	public void setDatentime(Calendar datentime) {
		this.datentime = datentime;
	}

}
