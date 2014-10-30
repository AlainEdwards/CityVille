package com.ade.cityville;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import android.content.Context;
import android.util.Log;

import com.ade.cityville.Server.RServer;

public class AppData {

	private static ArrayList<CityEvent> CityEventsList = new ArrayList<CityEvent>();
	private static Context c;

	public static boolean initializeData(){
		if (c == null){return false;}
		//Set all the class context here
		RServer.setContext(c);
		
		try {
			CityEventsList = RServer.getAllEvents();
		} catch (Exception e) {
			Log.e("Initilize Data", e.toString());
			return false;
		}
		
		return true;
	}
	/**
	 * @return the cityEventsList
	 */
	public static ArrayList<CityEvent> getCityEventsList() {
		return CityEventsList;
	}

	/**
	 * @param cityEventsList the cityEventsList to set
	 */
	public static void setCityEventsList(ArrayList<CityEvent> cityEventsList) {
		CityEventsList = cityEventsList;
	}
	/**
	 * @return the c
	 */
	public static Context getContext() {
		return c;
	}
	/**
	 * @param c the c to set
	 */
	public static void setContext(Context c) {
		AppData.c = c;
	}
}
