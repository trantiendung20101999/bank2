package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import controller.ConnectDB;
import controller.InterestRate.InterestRateDAOImp;
import controller.bankSavingBookDAO.BankSavingBookDAO;
import controller.bankSavingBookDAO.BankSavingDAOImp;
import controller.userDAO.UserDAOImp;
import model.BankSavingBook;
import model.InterestRate;
import model.User;

class UserDAOImpTest {

	Connection con;
	UserDAOImp udi;
	User user;
	BankSavingDAOImp bsdi;
	InterestRateDAOImp irdi;
	
	@BeforeEach
	void setUp()
	{
		bsdi= new BankSavingDAOImp();
		irdi = new InterestRateDAOImp();
		udi = new UserDAOImp();
		con = ConnectDB.connection();
		String userFullname="Tran Tien DUng";
		String username="dunghoi";
		String password="123456";
		String address = "hongthuan";
		String dob = "2021-04-23";
		String phonenumber = "443543";
		String email = "trantiendung101999@gmail.com";
		String role="khach hang";
		String idcard = "123";
		user=new User();
		user.setFullname(userFullname);
		user.setUsername(username);
		user.setPassword(password);
		user.setAddress(address);
		user.setDob(dob);
		user.setPhonenumber(phonenumber);
		user.setEmail(email);
		user.setRole(role);
		user.setIdCard(idcard);
	}
	
	
	//------------------------------------Tìm người dùng theo ID -----------------------------
	// Trong DB ID nằm trong miền [3,17] vào thời điểm test 
		
	// Tìm người dùng hợp lệ 
		
	@Test
	@DisplayName("Tìm người dùng theo ID hợp lệ ( theo biên dưới ) ")
	void searchUserId()
	{
		User u  = udi.getUserByID(3);
		assertNotNull(u);
		assertEquals("admin", u.getAddress());
		assertEquals("admin", u.getDob());
		assertEquals("admin", u.getEmail());
		assertEquals("admin", u.getFullname());
		assertEquals(3, u.getId());
		assertEquals("admin", u.getIdCard());
		assertEquals("admin", u.getPassword());
		assertEquals("admin", u.getPhonenumber());
		assertEquals("admin", u.getRole());
		assertEquals("admin", u.getUsername());
	}
	
	@Test
	@DisplayName("Tìm người dùng theo ID hợp lệ (theo biên trên) ")
	void searchUserId2()
	{
		User u = udi.getUserByID(17);
		assertNotNull(u);
		assertEquals("tg", u.getAddress());
		assertEquals("2021-04-23", u.getDob());
		assertEquals("fdsa@gmail.com", u.getEmail());
		assertEquals("sfg", u.getFullname());
		assertEquals(17, u.getId());
		assertEquals("9678678", u.getIdCard());
		assertEquals(null, u.getPassword());
		assertEquals("7467", u.getPhonenumber());
		assertEquals("khach hang", u.getRole());
		assertEquals(null, u.getUsername());
	}
	

	// Tìm ngừoi dùng không hợp lệ 
	
	
	@Test
	@DisplayName("Tìm người dùng theo ID không hợp lệ ( theo biên dưới ) ")
	void searchUserId3()
	{
		User u  = udi.getUserByID(2);
		assertNull(u);
	}
	@Test
	@DisplayName("Tìm người dùng theo ID không hợp lệ ( theo biên trên ) ")
	void searchUserId4()
	{
		User u  = udi.getUserByID(18);
		assertNull(u);
	}
	
	//------------------------------------ thêm người dùng mới -----------------------------

	@Test
	@DisplayName("Thêm người dùng thành công ")
	void insertUser() throws SQLException
	{
		con.setAutoCommit(false);
		udi.con= con;
		try {
			assertTrue(udi.insertUser(user));
			assertNotNull(udi.getUserByID(user.getId()));
			assertEquals(udi.getUserByID(user.getId()).toString(), user.toString());
		}
		finally {
			con.rollback();
		}
	}
	
	@Test
	@DisplayName("Thêm người dùng không thành công ")
	void insertUser2() throws SQLException
	{
		con.setAutoCommit(false);
		udi.con= con;
		try {
			assertFalse(udi.insertUser(null));
			assertNull(udi.getUserByID(user.getId()));
		}
		finally {
			con.rollback();
		}
	}
	
	//------------------------------------kiểm tra tài khoản  -----------------------------
	
	@Test
	@DisplayName("Kiểm tra thông tin tài khoản chính xác  ")
	void checkaccount()
	{
		User u = udi.checkAccount("dung333", "123456");
		assertNotNull(u);
		assertEquals(udi.getUserByID(u.getId()).toString(), u.toString());
	}
	@Test
	@DisplayName("Kiểm tra tài khoản không tồn tại ")
	void checkaccount2()
	{
		User u = udi.checkAccount("dung333543543", "123456");
		assertNull(u);
	}
	
	@Test
	@DisplayName("Kiểm tra mật khẩu không chính xác ")
	void checkaccount3()
	{
		User u = udi.checkAccount("dung333", "1234567");
		assertNull(u);
	}
	
	@Test
	@DisplayName("Kiểm tra tài khoản và mật khẩu không chính xác ")
	void checkaccount4()
	{
		User u = udi.checkAccount("dung3333333", "1234567");
		assertNull(u);
	}
	
//------------------------------------ kiểm tra chức năng lấy role  -----------------------------

	@Test
	@DisplayName("Kiểm tra lấy role admin  ")
	void getRole()
	{
		user=udi.getUserByID(3);
		String role  = udi.getRole(user);
		assertEquals(role, "admin");
	}
	
	@Test
	@DisplayName("Kiểm tra lấy role khach hang  ")
	void getRole2()
	{
		user = udi.getUserByID(17);
		String role  = udi.getRole(user);
		assertEquals(role, "khach hang");
	}
	
	@Test
	@DisplayName("Kiểm tra lấy role cua user khong ton tai   ")
	void getRole4()
	{
		user.setId(0);
		String role  = udi.getRole(user);
		assertNull(role);
	}
//-------------------- kiểm tra chức năng lấy danh sách sổ tiết kiệm của người dùng   -----------------------------

	@Test
	@DisplayName("Kiểm tra lấy danh sách có 1 sổ tiết kiệm  ")
	void getListBsb()
	{
		List<BankSavingBook> lists = new ArrayList<BankSavingBook>();
		user = udi.getUserByID(17);
		lists = udi.getBankSavingBook(user);
		assertNotEquals(lists.size(),0);
		BankSavingBook bsb = lists.get(0);
		assertEquals(bsdi.searchBook(11).toString(), bsb.toString());
		
	}
	
	@Test
	@DisplayName("Kiểm tra lấy danh sách có nhiêu sổ tiết kiệm  ")
	void getListBsb2()
	{
		List<BankSavingBook> lists = new ArrayList<BankSavingBook>();
		user = udi.getUserByID(14);
		lists = udi.getBankSavingBook(user);
		assertNotEquals(lists.size(),0);
		
		List<BankSavingBook> lists2 = new ArrayList<BankSavingBook>();
		lists2.add(bsdi.searchBook(12));
		lists2.add(bsdi.searchBook(13));
		lists2.add(bsdi.searchBook(14));
		lists2.add(bsdi.searchBook(15));
		
		assertEquals(lists.size(), lists2.size());
		for(int i=0;i<lists.size();i++)
		{
			assertEquals(lists.get(i).toString(), lists2.get(i).toString());
		}
		
	}
	
	@Test
	@DisplayName("Kiểm tra lấy danh sách rỗng ")
	void getListBsb3()
	{
		List<BankSavingBook> lists = new ArrayList<BankSavingBook>();
		user = udi.getUserByID(4);
		lists = udi.getBankSavingBook(user);
		assertEquals(lists.size(),0);
		
	}
	
	@Test
	@DisplayName("Kiểm tra lấy danh sách không tồn tại ")
	void getListBsb4()
	{
		List<BankSavingBook> lists = new ArrayList<BankSavingBook>();
		
		lists = udi.getBankSavingBook(null);
		assertNull(lists);
		
	}
	
	//-------------------- kiểm tra chức năng kiểm tra username đã tồn tại chưa  -----------------------------
	
	@Test
	@DisplayName("Kiểm tra Username tồn tại ")
	void checkUsername()
	{
		assertTrue(udi.checkUsername("dung333"));
		
	}
	
	@Test
	@DisplayName("Kiểm tra Username không tồn tại ")
	void checkUsername2()
	{
		assertFalse(udi.checkUsername("dung333321321"));
		
	}

	//-------------------- kiểm tra chức năng thêm người dùng không có username   -----------------------------

	@Test
	@DisplayName("Thêm người dùng không có username,password  thành công ")
	void addUser() throws SQLException
	{
	
		con.setAutoCommit(false);
		udi.con=con;
		try {
		user.setUsername(null);
		user.setPassword(null);
		assertTrue(udi.addUser(user));
		assertEquals(udi.getUserByID(user.getId()).toString(), user.toString());
		}
		finally {
			con.rollback();
		}
		
		
	}
	
	@Test
	@DisplayName("Thêm người dùng không có username,password không thành công ")
	void addUser2()
	{
		assertFalse(udi.addUser(null));
	}
	
	//-------------------- kiểm tra chức năng tìm người dùng theo idCard -----------------------------

	@Test
	@DisplayName("Tìm người dùng theo idCard tồn tại ")
	void searchUser()
	{
		User u = udi.searchUserByidCard("2141243");
		assertNotNull(u);
		assertEquals("ha noi", u.getAddress());
		assertEquals("2021-04-14", u.getDob());
		assertEquals("", u.getEmail());
		assertEquals("Tran Tien DUng1", u.getFullname());
		assertEquals(13, u.getId());
		assertEquals("2141243", u.getIdCard());
		assertEquals(null, u.getPassword());
		assertEquals("", u.getPhonenumber());
		assertEquals("khach hang", u.getRole());
		assertEquals(null, u.getUsername());
	}
	
	@Test
	@DisplayName("Tìm người dùng theo idCard không tồn tại ")
	void searchUser2()
	{
		User u = udi.searchUserByidCard("214124344");
		assertNull(u);

	}
	
	//-------------------- kiểm tra chức năng cập nhật thông tin người dùng -----------------------------
	
	@Test
	@DisplayName("Cập nhật người dùng thành công ")
	void updateUser() throws SQLException
	{
		con.setAutoCommit(false);
		udi.con=con;
		try {
		User u = new User();
		u = udi.getUserByID(13);
		u.setUsername("dungdung1");
		u.setPassword("123456");
		assertTrue(udi.addUsername(u));
		assertEquals(udi.getUserByID(13).toString(), u.toString());}
		finally {
			con.rollback();
		}
	}
	
	@Test
	@DisplayName("Cập nhật người dùng thất bại ")
	void updateUser2() throws SQLException
	{
		con.setAutoCommit(false);
		udi.con=con;
		try {
		assertFalse(udi.addUsername(null));
		}
		finally {
			con.rollback();
		}
	}
	
}
