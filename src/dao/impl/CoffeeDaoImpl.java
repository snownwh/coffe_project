package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.CoffeeDao;
import db.DBClose;
import db.DBConnection;
import dto.CoffeeDto;
import dto.CoffeeMenuDto;
import singleton.Singleton;

public class CoffeeDaoImpl implements CoffeeDao {

	@Override
	public List<CoffeeMenuDto> getCoffeeList() {
		String sql = " SELECT ESPRESSO_BEVERAGES, SHORT, TALL, GRANDE "  
				+ " FROM PRICELIST ";

		Connection conn = null; // DB Connection
		PreparedStatement psmt = null; // SQL
		ResultSet rs = null; // result

		List<CoffeeMenuDto> list = new ArrayList<CoffeeMenuDto>();

		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);

			rs = psmt.executeQuery();

			while (rs.next()) {

				CoffeeMenuDto dto = new CoffeeMenuDto(rs.getString(1), // 커피이름,
													  rs.getInt(2), // 숏,
													  rs.getInt(3), // 톨,
													  rs.getInt(4) // 그란데,
													  );
				list.add(dto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);
		}

		return list;
	}
	
	@Override
	public int coffeePrice(String size, String name) {
		String sql = " FROM PRICELIST "
					+ " WHERE ESPRESSO_BEVERAGES = ? ";
		
		if(size.equals("SHORT")) {
			sql = " SELECT SHORT " + sql;
		} else if (size.equals("TALL")) {
			sql = " SELECT TALL " + sql;
		} else if (size.equals("GRANDE")) {
			sql = " SELECT GRANDE " + sql;
		}
		
		System.out.println(sql);
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		int coffeeCost = 0;
		
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
					
			psmt.setString(1, name);
			
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				coffeeCost = rs.getInt(1);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);
		}
		System.out.println(coffeeCost);
		
		return coffeeCost;
	}

	@Override
	public boolean orderCoffee(CoffeeDto dto) {
		String sql = " INSERT INTO ORDERHISTORYLIST(SEQ_ORDERHISTORY, ID, ESPRESSO_BEVERAGES, "
				+ " PRICE, ODATE, C_SIZE, CYRUP, CREAM, ADDSHOT, AMOUNT, TOTALPRICE) "
				+ " VALUES(SEQ_ORDER.NEXTVAL, ?, ? , ?, SYSDATE, ?, ?, ?, ?, ?, ?) ";
		
		Singleton s = Singleton.getInstance();
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		int cost = s.cfeCtrl.coffeeCost(dto.getSize(), dto.getCoffeeName());
		int count = 0;
		
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			
			
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getCoffeeName());
			psmt.setInt(3, cost);
			psmt.setString(4, dto.getSize());
			psmt.setString(5, dto.getCyrup());
			psmt.setString(6, dto.getCream());
			psmt.setString(7, dto.getAddShot());
			psmt.setInt(8, dto.getAmount());
			psmt.setInt(9, (cost * dto.getAmount()));
			
//			rs = psmt.executeQuery();
//						
//			while(rs.next()) {
//				int SEQ_ORDERHISTORY = rs.getInt(1); 
//				String id = rs.getString(2);
//				String espresso_beverages = rs.getString(3);
//				int price = rs.getInt(4);
//				String odate = rs.getString(5);
//				String c_size = rs.getString(6);
//				int cyrup = rs.getInt(7);
//				int cream = rs.getInt(8);
//				int addshot = rs.getInt(9);
//				int amount = rs.getInt(10);
//				int totalprice =rs.getInt(11);
//			}
			
			count = psmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);
		}
		
		return count > 0 ? true : false;
	}

	@Override
	public List<CoffeeDto> orderBfPayList() {
		String sql = " SELECT ESPRESSO_BEVERAGES, CYRUP, C_SIZE, ADDSHOT, CREAM, AMOUNT, TOTALPRICE "  
				+ " FROM ORDERHISTORYLIST ";

		Connection conn = null; // DB Connection
		PreparedStatement psmt = null; // SQL
		ResultSet rs = null; // result

		List<CoffeeDto> list = new ArrayList<CoffeeDto>();

		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);

			rs = psmt.executeQuery();

			while (rs.next()) {

				CoffeeDto dto = new CoffeeDto(	 
												rs.getString(1), // 커피 이름
												rs.getString(2), // 시럽
												rs.getString(3), // 사이즈
												rs.getString(4), // 샷추가
												rs.getString(5), // 휘핑크림
												rs.getInt(6),
												rs.getInt(7)
			);
				list.add(dto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);
		}

		return list;
		
		
	}
	
	public List<CoffeeDto> totalList() {
		String sql = " SELECT ESPRESSO_BEVERAGES, ODATE, C_SIZE, AMOUNT, TOTALPRICE "  
				+ " FROM ORDERHISTORYLIST ";

		Connection conn = null; // DB Connection
		PreparedStatement psmt = null; // SQL
		ResultSet rs = null; // result

		List<CoffeeDto> list = new ArrayList<CoffeeDto>();

		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);

			rs = psmt.executeQuery();

			while (rs.next()) {

				CoffeeDto dto = new CoffeeDto(	 
												rs.getString(1), // 커피 이름
												rs.getString(2), // 시럽
												rs.getString(3), // 사이즈
												rs.getInt(4), // 샷추가
												rs.getInt(5) // 휘핑크림
												
			);
				list.add(dto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);
		}

		return list;
	}

	@Override
	public int sumAll() {
		String sql = " SELECT SUM(TOTALPRICE) "  
				+ " FROM ORDERHISTORYLIST ";
		
		Connection conn = null; // DB Connection
		PreparedStatement psmt = null; // SQL
		ResultSet rs = null; // result
		int sumAll = 0;
		
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				sumAll = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);
		}
		
		return sumAll; 
	}
	
	
	
}
