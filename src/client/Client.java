package client;

import java.rmi.*;
import java.util.ArrayList;

import org.apache.axis2.AxisFault;

import server.*;

public class Client {

	public String getCityList() {
		try {
			Server server = new ServerStub();
			GetCityList citylist = new GetCityList();
			
			GetCityListResponse citylistResponse=server.getCityList(citylist);
			return citylistResponse.get_return();
		} catch (ConnectException conEx) {
			System.out.println("Unable to connect to Broker server!");
			System.exit(1);
			return null;
		} catch (Exception ex) {
			ex.printStackTrace();
			System.exit(1);
			return null;
		}
	}

	public String getHotelList(String city) {
		try {

			Server server = new ServerStub();
			GetHotelList hotellist = new GetHotelList();
			hotellist.setCity(city);
			GetHotelListResponse hotellistResponse = server
					.getHotelList(hotellist);
			return hotellistResponse.get_return();

		} catch (ConnectException conEx) {
			System.out.println("Unable to connect to Broker server!");
			System.exit(1);
			return null;
		} catch (Exception ex) {

			ex.printStackTrace();
			System.exit(1);
			return null;
		}
	}

	public String getRoomrate(String city, String hotel) {
		try {
			Server server = new ServerStub();
			GetRoomrate roomrate = new GetRoomrate();
			roomrate.setCity(city);
			roomrate.setHotel(hotel);
			GetRoomrateResponse roomrateResponse = server.getRoomrate(roomrate);
			return roomrateResponse.get_return();

		} catch (ConnectException conEx) {
			System.out.println("Broker unable to connect hotel server! ");
			System.exit(1);
			return null;
		} catch (Exception ex) {
			// ex.printStackTrace();
			System.out.println("Broker unable to connect hotel server! ");
			System.exit(1);
			return null;
		}
	}

	public boolean getVacancy(String city, String hotel, String roomrate,
			int indate, int outdate) {
		try {
			Server server = new ServerStub();
			GetVacancy vacancy = new GetVacancy();
			vacancy.setCity(city);
			vacancy.setHotel(hotel);
			vacancy.setRoomrate(roomrate);
			vacancy.setIndate(indate);
			vacancy.setOutdate(outdate);
			GetVacancyResponse vacancyResponse = server.getVacancy(vacancy);
			return vacancyResponse.get_return();
		} catch (ConnectException conEx) {
			System.out.println("Unable to connect Broker to server!");
			System.exit(1);
			return false;
		} catch (Exception ex) {

			ex.printStackTrace();
			System.exit(1);
			return false;
		}
	}

	public boolean bookRoom(String city, String hotel, String roomrate,
			int indate, int outdate, String name, String tel, String credit) {
		boolean state = false;
		try {
			Server server = new ServerStub();
			BookRoom bookRoom = new BookRoom();
			bookRoom.setCity(city);
			bookRoom.setHotel(hotel);
			bookRoom.setRoomrate(roomrate);
			bookRoom.setIndate(indate);
			bookRoom.setOutdate(outdate);
			bookRoom.setName(name);
			bookRoom.setTel(tel);
			bookRoom.setCredit(credit);
			BookRoomResponse bookRoomResponse = server.bookRoom(bookRoom);
			return bookRoomResponse.get_return();
		} catch (ConnectException conEx) {
			System.out.println("Unable to connect Broker to server!");
			System.exit(1);
		} catch (Exception ex) {
			ex.printStackTrace();
			System.exit(1);
		}
		return state;
	}
}