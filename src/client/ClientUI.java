package client;

import java.io.*;
import java.util.ArrayList;

public class ClientUI {
	BufferedReader console = new BufferedReader(
			new InputStreamReader(System.in));
	Client client = new Client();

	public static void main(String args[]) throws IOException {
		System.out.println("Welcome to book our hotel!");
		ClientUI ui = new ClientUI();
		ui.book();
	}

	public void book() {
		try {
			System.out.println("We have hotel in the city:");

			String city = getCityList();
			String hotel = getHotelList(city);
			String roomrate = getRoomrate(city, hotel);

			System.out.println("Please input your check-in date:");
			String readin = console.readLine().trim();
			int indate = Integer.parseInt(readin);
			while (indate < 0 || indate > 30) {
				System.out
						.println("check-in date is illeagal,please input again:");
				readin = console.readLine().trim();
				indate = Integer.parseInt(readin);
			}
			System.out.println("Please input your check-out outdate:");
			String readout = console.readLine().trim();
			int outdate = Integer.parseInt(readout);
			while (outdate < indate || outdate == indate || outdate > 30) {
				System.out
						.println("check-out date is illeagal,please input again:");
				readout = console.readLine().trim();
				outdate = Integer.parseInt(readout);
			}

			boolean vac = checkVacancy(city, hotel, roomrate, indate, outdate);
			if (vac) {
				System.out.println("Have vacancy room! Confirm : Y/N?");
				String confirm = console.readLine().trim();
				if (confirm.equalsIgnoreCase("y")) {
					bookRoom(city, hotel, roomrate, indate, outdate);
				} else {
					System.out.println("Thanks for your visiting!");
					System.out.println("");
					book();
				}
			} else {
				System.out.println("No available room!Please try again!");
				System.out.println("");
				book();

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getCityList() {
		String citystr = client.getCityList();
		System.out.println("  -------------- ");
		String citylist[] = citystr.split("#");
		for (int i = 0; i < citylist.length; i++) {
			System.out.print("   " + (i + 1) + ". " + citylist[i] + " \n");
			System.out.println("  -------------- ");
		}
		System.out.println("Please select city num:");
		try {
			String citynum = console.readLine().trim();
			String city = null;
			switch (citynum) {
			case "1":
				city = "sh";
				break;
			case "2":
				city = "sz";
				break;
			}
			return city;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public String getHotelList(String city) {
		String hotelstr = client.getHotelList(city);
		System.out.println("Hotel in the city:");
		System.out.println("  -------------- ");
		String hotellist[] = hotelstr.split("#");
		for (int i = 0; i < hotellist.length; i++) {
			System.out.print("   " + (i + 1) + ". " + hotellist[i] + " \n");
			System.out.println("  -------------- ");
		}
		System.out.println("Please select hotel num:");
		try {
			String hotelnum = console.readLine().trim();
			String hotel = hotellist[Integer.parseInt(hotelnum) - 1];
			return hotel;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public String getRoomrate(String city, String hotel) {
		String roomratestr = client.getRoomrate(city, hotel);
		if (roomratestr == null) {
			System.out.println("Broker unable to connect hotel server! ");
			System.exit(1);
		}
		System.out.println("The hotel roomrate:");
		System.out.println("  -------------- ");
		String roomratelist[] = roomratestr.split("#");
		for (int i = 0; i < roomratelist.length; i++) {
			System.out.print("   " + (i + 1) + ". " + roomratelist[i] + " \n");
			System.out.println("  -------------- ");
		}

		System.out.println("Please select roomrate num:");
		try {
			String roomratenum = console.readLine().trim();
			String roomrate = roomratelist[Integer.parseInt(roomratenum) - 1];
			return roomrate;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	protected boolean checkVacancy(String city, String hotel, String roomrate,
			int indate, int outdate) {
		boolean vacancy = client.getVacancy(city, hotel, roomrate, indate,
				outdate);
		return vacancy;
	}

	protected void bookRoom(String city, String hotel, String roomrate,
			int indate, int outdate) throws IOException {
		System.out.print("please input yourname:");
		String name = console.readLine().trim();

		System.out.print("please input telphone:");
		String tel = console.readLine().trim();

		System.out.print("please input credit :");
		String credit = console.readLine().trim();
		boolean state = false;
		state = client.bookRoom(city, hotel, roomrate, indate, outdate, name,
				tel, credit);
		if (state) {
			System.out.println("Booking succeed!");
			if (city == "sh")
				city = "Shanghai";
			if (city == "sz")
				city = "Suzhou";
		    	System.out.println("   Booking Details   " );
		    	System.out.println("-----------------------");
				System.out.println(" City     : "+city);
				
				System.out.println(" Hotel    : "+hotel);
				
		    	System.out.println(" Roomrate : "+roomrate);
		    	
		    	System.out.println(" Check-in : 2015-06-"+indate);
		    	
		    	System.out.println(" Check-out: 2015-06-"+outdate);
		    	
		    	System.out.println(" Name     : "+name);
		    	
		    	System.out.println(" Tel      : "+tel  );
		    	
				System.out.println(" Credit   : "+credit);
				
		} else {
			System.out.println("Book failed!");
		}
	}

}
