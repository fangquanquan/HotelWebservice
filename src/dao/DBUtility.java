package dao;

import java.sql.*;
import java.util.ArrayList;

public class DBUtility {
	DBConnect db = new DBConnect();
	java.sql.Connection conn = db.GetDBCon();
	
//		public static void main(String args[]) throws SQLException {
//			
//			DBUtility test = new DBUtility();
//					
//		}
//		DBUtility() throws SQLException {
//			String a = getHotelList("sz");
//			System.out.println(a);
//		}
//		
		
		
	public String getCityList() throws SQLException {	
		String sql = "select distinct city from hotel";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		ArrayList<String> citylist = new ArrayList<String>();		
		while (rs.next()) {
			citylist.add(rs.getString(1));
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < citylist.size(); i++) {
			sb.append(citylist.get(i) + "#");
		}
		String city = sb.toString();
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return city;
	}

	public String getHotelList(String city) throws SQLException {
		String sql = null;
		switch (city) {
		case "sh":
			sql = "select Hotel from hotel where City='Shanghai'";
			break;
		case "sz":
			sql = "select Hotel from hotel where City='Suzhou'";
			break;
		}
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		ArrayList<String> hotellist = new ArrayList<String>();
		while (rs.next()) {
			hotellist.add(rs.getString(1));
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < hotellist.size(); i++) {
			sb.append(hotellist.get(i) + "#");
		}
		 String hotel = sb.toString();	
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return hotel;
	}

	public String getRoomrate(String hotelcity) throws SQLException {
		String sql = "select distinct Roomrate from " + hotelcity;
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		ArrayList<String> roomratelist = new ArrayList<String>();
		while (rs.next()) {
			roomratelist.add(rs.getString(1));
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < roomratelist.size(); i++) {
			sb.append(roomratelist.get(i) + "#");
		}
		 String roomrate = sb.toString();
	
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return roomrate;
	}

	public ArrayList<Integer> getVacancy(String hotelcity, String roomrate,
			int date) throws SQLException {
		String sql = null;
		sql = "select RoomNum from " + hotelcity + " where roomrate='"
				+ roomrate + "' and Date='2015-06-" + date + "'";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		ArrayList<Integer> roomnum = new ArrayList<Integer>();
		while (rs.next()) {
			roomnum.add(rs.getInt(1));
		}
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return roomnum;
	}

	public boolean bookRoom(String hotelcity, String roomrate, int date)
			throws SQLException {
		boolean bookstate;
		try {
			String sql = "UPDATE `id26347040`.`" + hotelcity
					+ "` SET `RoomNum`=(roomnum-1) WHERE `Roomrate`='"
					+ roomrate + "' and`Date`='2015-06-" + date + "'";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.execute();
			bookstate = true;

		} catch (Exception e) {
			bookstate = false;
			// TODO: handle exception
		}
		return bookstate;
	}

	public boolean bookOrder(String hotelcity, String roomrate, int indate,
			int outdate, String name, String tel, String credit) {
		boolean orderstate;
		try {
			String sql = "INSERT INTO `id26347040`.`"
					+ hotelcity
					+ "_order` (`Roomrate`, `indate`, `outdate`, `customerName`, `telNum`, `creditNum`) VALUES ('"
					+ roomrate + "', '2015-06-" + indate + "', '2015-06-"
					+ outdate + "', '" + name + "', '" + tel + "', '" + credit
					+ "')";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.execute();
			orderstate = true;
		} catch (Exception e) {

			orderstate = false;
			// TODO: handle exception
		}
		return orderstate;
	}
}
// public void freeDB() {
// try {
// Connection conn = this.GetDBCon();
// conn.close();
// System.out.println("Database has been freed!");
// } catch (SQLException e) {
// // TODO Auto-generated catch block
// e.printStackTrace();
// // conn = null;
// }
// }

