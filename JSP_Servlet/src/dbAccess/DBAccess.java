package dbAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class DBAccess {
	public static Connection sqlcon = null;
	Statement stm = null;
	PreparedStatement pstm = null;
	ResultSet rs = null;

	public static Connection getConnect() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			sqlcon = DriverManager.getConnection(
					"jdbc:sqlserver://localhost:1433;databaseName=QLKH; username=sa; password=12345678");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return sqlcon;
	}

	public static void main(String[] args) {
		DBAccess db = new DBAccess();
		db.getConnect();
		ArrayList<Account> accList = new ArrayList<Account>(); 
		
		   accList = db.getAccList();
		   for(int i=0;i<accList.size();i++){
			   System.out.println(accList.get(i).getUser());
		   }

		
		
	}
	public boolean checkLogin(String username, String password) {

		// String sql = "select * from ACCOUNT ";
		// try {
		// pstm = getConnect().prepareStatement(sql);
		// rs = pstm.executeQuery();
		// Account acc;
		// while(rs.next())
		// {
		// acc = new Account();
		// acc.setId(rs.getInt(1));
		// acc.setUser(rs.getString(2));
		// acc.setPass(rs.getString(3));
		// acc.setEmail(rs.getString(4));
		// return true;
		// }
		// } catch (SQLException e) {
		// e.printStackTrace();
		// }
		// return false;
		return true;

	}

	public ArrayList<Account> getAccList() {
		ArrayList<Account> accList = new ArrayList<>();// tạo ds kiểu tài khoản
														// rỗng

		String sql = "select * from ACCOUNT ";
		try {
			pstm = getConnect().prepareStatement(sql);// kết nối và gán lệnh sql
			rs = pstm.executeQuery();// thực thi lệnh select
			Account acc;
			while (rs.next()) {
				acc = new Account(); // tạo obj mới
				acc.setId(rs.getInt(1));// gán cột 1 của rs vào id của acc
				acc.setUser(rs.getString(2));
				acc.setPass(rs.getString(3));
				acc.setEmail(rs.getString(4));
				accList.add(acc);// them acc vao list
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accList;//trả về list acc
	}
	public void addAcc(String u,String p,String em){
		String sql = "insert into ACCOUNT(username,password,email) values (?,?,?)";
		
		try {
			PreparedStatement pstm = getConnect().prepareStatement(sql);
			pstm.setString(1, u);
			pstm.setString(2, p);
			pstm.setString(3, em);
			pstm.executeUpdate();
			getConnect().close();
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
	}
	public boolean sameUser(String u){
		ArrayList<Account> arr = getAccList();
		for(int i =0; i<arr.size();i++){
			if(u.equals(arr.get(i).getUser())){
				return true;
			}
		}
		return false;
	}
	public static void delAcc(int id){
		String sql = "delete from ACCOUNT where ID = ?";
		try {
			PreparedStatement pstm = getConnect().prepareStatement(sql);
			pstm.setInt(1, id);;
			pstm.executeUpdate(sql);
			getConnect().close();
		} catch (SQLException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
