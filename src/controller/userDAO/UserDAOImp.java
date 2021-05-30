package controller.userDAO;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controller.ConnectDB;
import controller.InterestRate.InterestRateDAOImp;
import model.BankSavingBook;
import model.InterestRate;
import model.User;

public class UserDAOImp implements UserDAO{

	public static Connection con = ConnectDB.connection();
	PreparedStatement pre ;
	//them mot tai khoan moi
	@Override
	public boolean insertUser(User user) {
		boolean insertStatus=false;
		if(user!=null)
		{
		
		String INSERT_USER="INSERT INTO Users(Fullname,Username,Password,Address,Dob,Phonenumber,Email,Role,Idcard) VALUES(?,?,?,?,?,?,?,?,?)";
		
		try {
			pre = con.prepareStatement(INSERT_USER,Statement.RETURN_GENERATED_KEYS);
			pre.setString(1	, user.getFullname());
			pre.setString(2, user.getUsername());
			pre.setString(3, user.getPassword());
			pre.setString(4, user.getAddress());
			pre.setString(5, user.getDob());
			pre.setString(6, user.getPhonenumber());
			pre.setString(7, user.getEmail());
			pre.setString(8, user.getRole());
			pre.setString(9, user.getIdCard());
			insertStatus = pre.executeUpdate()>0;
			ResultSet rs = pre.getGeneratedKeys();
			if(rs.next())
			{
				user.setId(rs.getInt(1));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		return insertStatus;
	}
	// kiem tra tai khoan co ton tai khong?
	@Override
	public User checkAccount(String username, String password) {
		String CHECK_ACCOUNT="SELECT * FROM Users WHERE Username=? AND Password=?";

		try {
			pre = con.prepareStatement(CHECK_ACCOUNT);
			pre.setString(1, username);
			pre.setString(2, password);
			ResultSet rs = pre.executeQuery();
			if(rs.next())
			{
				int id = rs.getInt("ID");
				String fullname = rs.getString("Fullname");
				String address = rs.getString("Address");
				String dob = rs.getString("Dob");
				String phonenumber = rs.getString("Phonenumber");
				String email = rs.getString("Email");
				String role= rs.getString("Role");
				String idcard = rs.getString("Idcard");
				User user = new User(id,fullname,username,password,address,phonenumber,email,role,idcard,dob);
				return user;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	// lay thong tin ve chuc nang cua nguoi dung
	@Override
	public String getRole(User user) {
		String GET_ROLE="SELECT Role FROM Users WHERE Users.ID=?";
		try {
			pre = con.prepareStatement(GET_ROLE);
			pre.setInt(1, user.getId());
			ResultSet rs = pre.executeQuery();
			if(rs.next())
			{
				String role = rs.getString("Role");
				return role;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// lay ra danh sach so tiet kiem cua nguoi dung
	@Override
	public ArrayList<BankSavingBook> getBankSavingBook(User user) {
		if(user!=null)
		{
		String GET_BANKSAINGBOOKS = "SELECT * FROM BankSavingBooks WHERE UsersID=?";
		ArrayList<BankSavingBook> listbook = new ArrayList();
		try {
			pre = con.prepareStatement(GET_BANKSAINGBOOKS);
			pre.setInt(1, user.getId());
			ResultSet rs = pre.executeQuery();
			while(rs.next())
			{
				InterestRateDAOImp interest = new InterestRateDAOImp();
				int id = rs.getInt("ID");
				int interestRateID= rs.getInt("InterestRateID");
				InterestRate interestrate = interest.getInterestRateByID(interestRateID);
				double money = rs.getDouble("Money");
				String branch = rs.getString("Branch");
				String typeofsaving = rs.getString("TypeOfSaving");
				int interestTerm = rs.getInt("InterestTerm");
				String startdate = rs.getString("StartDate");
				int periodic = rs.getInt("periodic");
				int checkk  = rs.getInt("checkk");
				BankSavingBook bsb = new BankSavingBook(id,interestrate,user,money,branch,typeofsaving,interestTerm,periodic,startdate,checkk);
				listbook.add(bsb);
			}
			return listbook;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		return null;
	}
	
	
	 //tim kiem nguoi dung theo id
	@Override
	public User getUserByID(int id) {
		String GET_USER_BYID_SQL = "SELECT * FROM Users WHERE ID=?";
		
		try {
			PreparedStatement pre = con.prepareStatement(GET_USER_BYID_SQL);
			pre.setInt(1, id);
			ResultSet rs = pre.executeQuery();
			if(rs.next())
			{
				User user= new User();
				
				String fullname = rs.getString("Fullname");
				String username = rs.getString("Username");
				String password = rs.getString("Password");
				String address = rs.getString("Address");
				String dob = rs.getString("Dob");
				String phonenumber = rs.getString("Phonenumber");
				String email = rs.getString("Email");
				String role = rs.getString("Role");
				String idcard = rs.getString("Idcard");
				
				user.setId(id);
				user.setFullname(fullname);
				user.setUsername(username);
				user.setPassword(password);
				user.setAddress(address);
				user.setDob(dob);
				user.setPhonenumber(phonenumber);
				user.setEmail(email);
				user.setRole(role);
				user.setIdCard(idcard);
				return user;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}

	// kiem tra ten tai khoan nguoi dung da ton tai ?
	@Override
	public boolean checkUsername(String username) {
		String CHECK_USERNAME_SQL ="SELECT * FROM Users WHERE Username=?";
		
		try {
			PreparedStatement pre = con.prepareStatement(CHECK_USERNAME_SQL);
			pre.setString(1, username);
			ResultSet rs = pre.executeQuery();
			if(rs.next())
			{
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
	}
	// them nguoi dung khong co ten tai khoan mat khau
	@Override
	public boolean addUser(User user) {
		boolean insertStatus=false;
		if(user!=null)
		{
		String INSERT_USER="INSERT INTO Users(Fullname,Address,Dob,Phonenumber,Email,Role,Idcard) VALUES(?,?,?,?,?,?,?)";
		
		try {
			pre = con.prepareStatement(INSERT_USER,Statement.RETURN_GENERATED_KEYS);
			pre.setString(1	, user.getFullname());
			pre.setString(2, user.getAddress());
			pre.setString(3, user.getDob());
			pre.setString(4, user.getPhonenumber());
			pre.setString(5, user.getEmail());
			pre.setString(6, user.getRole());
			pre.setString(7, user.getIdCard());
			insertStatus = pre.executeUpdate()>0;
			ResultSet rs = pre.getGeneratedKeys();
			if(rs.next())
			{
				user.setId(rs.getInt(1));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		return insertStatus;
	}
	@Override
	public User searchUserByidCard(String idcard) {
		String SEARCH_USER_BY_ID_CARD="SELECT * FROM Users WHERE Idcard=?";
		try {
			PreparedStatement pre = con.prepareStatement(SEARCH_USER_BY_ID_CARD);
			pre.setString(1, idcard);
			ResultSet rs = pre.executeQuery();
			if(rs.next())
			{
				User user= new User();
				
				String fullname = rs.getString("Fullname");
				String username = rs.getString("Username");
				String password = rs.getString("Password");
				String address = rs.getString("Address");
				String dob = rs.getString("Dob");
				String phonenumber = rs.getString("Phonenumber");
				String email = rs.getString("Email");
				String role = rs.getString("Role");
				
				user.setId(rs.getInt("ID"));
				user.setFullname(fullname);
				user.setUsername(username);
				user.setPassword(password);
				user.setAddress(address);
				user.setDob(dob);
				user.setPhonenumber(phonenumber);
				user.setEmail(email);
				user.setRole(role);
				user.setIdCard(idcard);
				return user;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}
	// them username password cho nguoi dung chua co tai khoan nhung da mo so tiet kiem
	@Override
	public boolean addUsername(User u) {
		if(u!=null)
		{
		String ADD_INFOR_SQL="UPDATE Users SET Username=? , Password=? WHERE ID=?";
		
		try {
			pre = con.prepareStatement(ADD_INFOR_SQL);
			pre.setString(1, u.getUsername());
			pre.setString(2, u.getPassword());
			pre.setInt(3, u.getId());
			return pre.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		return false;
		
	
	}
	
}
