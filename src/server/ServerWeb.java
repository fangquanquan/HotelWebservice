package server;

import java.io.IOException;
import java.rmi.*;
import java.rmi.server.*;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.DBUtility;

public class ServerWeb {

	DBUtility db = new DBUtility();
	
	public String getCityList() throws SQLException {
		String city = db.getCityList();
		return city;
	}

	public String getHotelList(String city) throws SQLException {
		String hotel = db.getHotelList(city);
		return hotel;
	}
	
	public String getRoomrate(String city, String hotel)
			throws RemoteException, SQLException {
		String hotelcity = hotel + city;
		String roomrate = db.getRoomrate(hotelcity);
		return roomrate;
	}

	public boolean getVacancy(String city, String hotel, String roomrate,
			int indate, int outdate) throws IOException, SQLException {
		String hotelcity = hotel + city;
		boolean vacancy = true;
		for (int i = indate; i < outdate; i++) {
			ArrayList<Integer> roomnum = db.getVacancy(hotelcity, roomrate, i);
			Integer num = roomnum.get(0);
			if (num == 0) {
				vacancy = false;
				break;
			}
		}
		return vacancy;
	}

	public boolean bookRoom(String city, String hotel, String roomrate,
			int indate, int outdate, String name, String tel,
			String credit) throws IOException, SQLException {
		String hotelcity = hotel + city;
		boolean bookstate = false;
		boolean orderstate = false;
		boolean state;
		for (int i = indate; i < outdate; i++) {
			bookstate = db.bookRoom(hotelcity, roomrate, i);
			if (bookstate == false)
				break;
		}
		orderstate = db.bookOrder(hotelcity, roomrate, indate, outdate, name,
				tel, credit);
		if (bookstate && orderstate)
			state = true;
		else {
			state = false;
		}
		return state;
	}
}