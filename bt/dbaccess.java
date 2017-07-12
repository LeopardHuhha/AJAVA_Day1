package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class ConnectDB {
	Connection sqlcon = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	ArrayList<Member> listMember = new ArrayList<>(); ;
	
	
	public Connection getConnect() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			sqlcon = DriverManager
			.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLKH; username=sa; password=Abcde12345");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sqlcon;
	}
	
	public ArrayList<Member> getListMember (){
		String sql = "Select * from Member";
		ArrayList<Member> listMember = new ArrayList<>();
		try {
			pstmt = getConnect().prepareStatement(sql);
			rs = pstmt.executeQuery();
			Member member;
			while(rs.next()){
				member = new Member();
				member.setId(rs.getInt("id"));
				member.setTen(rs.getString("Name"));
				member.setAccount(rs.getString("Account"));
				member.setDiaChi(rs.getString("DiaChi"));
				listMember.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listMember;
	}
	
	public ArrayList<Member> getListMember (String abc){
		String sql = "Select * from Member where ten like '%"+abc+"%'";
		ArrayList<Member> listMember = new ArrayList<>();
		try {
			pstmt = getConnect().prepareStatement(sql);
			rs = pstmt.executeQuery();
			Member member;
			while(rs.next()){
				member = new Member();
				member.setId(rs.getInt("id"));
				member.setTen(rs.getString("Name"));
				member.setAccount(rs.getString("Account"));
				member.setDiaChi(rs.getString("DiaChi"));
				listMember.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listMember;
	}
	
	
	public void addMember(Member abc){
		String sql = "insert into member values ("+abc.getId()+",N'"+abc.getTen()+"','"+abc.getAccount()+"',N'"+abc.getDiaChi()+"')";
		try {
			stmt = getConnect().createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void editMember(Member abc){
		String sql = "update member set name = N'"+abc.getTen()+"',account='"+abc.getAccount()+"',"
		+ "diachi=N'"+abc.getDiaChi()+"' where id="+abc.getId()+" ";
		try {
			stmt = getConnect().createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteMember(int id){
		String sql = "delete from member where id = "+id+"";
		try {
			stmt = getConnect().createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Member getInfoMember(int id){
		String sql = "Select * from Member where id="+id+"";
		Member member = new Member();;
		try {
			pstmt = getConnect().prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				
				member.setId(rs.getInt("id"));
				member.setTen(rs.getString("Name"));
				member.setAccount(rs.getString("Account"));
				member.setDiaChi(rs.getString("DiaChi"));
				listMember.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return member;
	}
	
	public static void main(String[] args) {
		ConnectDB run = new ConnectDB();
		ArrayList<Member> lisst = new ArrayList<>();
		lisst = run.getListMember();
		System.out.println(lisst.get(1).getTen());
	}
}
