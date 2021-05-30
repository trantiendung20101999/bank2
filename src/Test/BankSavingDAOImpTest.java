package Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import controller.ConnectDB;
import controller.InterestRate.InterestRateDAOImp;
import controller.bankSavingBookDAO.BankSavingDAOImp;
import controller.userDAO.UserDAOImp;
import model.BankSavingBook;
import model.InterestRate;
import model.User;

public class BankSavingDAOImpTest {

	Connection con;
	BankSavingDAOImp bsdi;
	User user;
	InterestRate ir;
	BankSavingBook bsb;
	InterestRateDAOImp irdi;
	UserDAOImp udi;
	
	@BeforeEach
	void setUp()
	{
		bsdi= new BankSavingDAOImp();
		irdi = new InterestRateDAOImp();
		udi = new UserDAOImp();
		con = ConnectDB.connection();

		int id = 8;
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
		user.setId(id);
		user.setFullname(userFullname);
		user.setUsername(username);
		user.setPassword(password);
		user.setAddress(address);
		user.setDob(dob);
		user.setPhonenumber(phonenumber);
		user.setEmail(email);
		user.setRole(role);
		user.setIdCard(idcard);
		
		int irId = 1;
		String typeofsaving = "tiet kiem thuong";
		int time = 1;
		double interestrate = 2.55;
		ir = new InterestRate();
		ir.setId(irId);
		ir.setTypeOfSaving(typeofsaving);
		ir.setTime(time);
		ir.setInterestRate(interestrate);
		
		double money = 10000000;
		String branch = " Ha Dong , Ha NOI";
		String typeofsaving2="tiet kiem thuong";
		int interestTerm = 1;
		int perodic = 1;
		String startDate="2021-05-20";
		bsb = new BankSavingBook();
		bsb.setBranch(branch);
		bsb.setInterestRate(ir);
		bsb.setInterestTerm(interestTerm);
		bsb.setMoney(money);
		bsb.setPeriodic(perodic);
		bsb.setStartDate(startDate);
		bsb.setTypeOfSaving(typeofsaving2);
		bsb.setUser(user);
		
	}
	
	// ------------------- Test tìm sổ theo mã----------------------
	// Trong DB chỉ có mã 11-15 vào thời điểm Test
	//--------------------------------------------------------------
	
	// Tìm hợp lệ 
	
	@Test
	@DisplayName("Tìm sổ theo mã sổ tồn tại biên dưới  ") 
	
	void searchBook()
	{
	
		BankSavingBook bsb = bsdi.searchBook(11);
		assertNotNull(bsb);
		assertEquals("Hà Đông,Hà Nội", bsb.getBranch());
		assertEquals(11, bsb.getId());
		assertEquals(irdi.getInterestRateByID(1).toString(), bsb.getInterestRate().toString());
		assertEquals(1,bsb.getInterestTerm());
		assertEquals(4564, bsb.getMoney());
		assertEquals(0, bsb.getPeriodic());
		assertEquals("2021-04-07", bsb.getStartDate());
		assertEquals("tiet kiem thuong", bsb.getTypeOfSaving());
		assertEquals(udi.getUserByID(17).toString(), bsb.getUser().toString());
	}
	
	@Test
	@DisplayName("Tìm sổ theo mã sổ tồn tại biên trên  ") 
	
	void searchBook2()
	{
		BankSavingBook bsb = bsdi.searchBook(15);
		assertNotNull(bsb);
		assertEquals("Hà Đông,Hà Nội", bsb.getBranch());
		assertEquals(15, bsb.getId());
		assertEquals(irdi.getInterestRateByID(1).toString(), bsb.getInterestRate().toString());
		assertEquals(1,bsb.getInterestTerm());
		assertEquals(100000, bsb.getMoney());
		assertEquals(0, bsb.getPeriodic());
		assertEquals("2021-05-16", bsb.getStartDate());
		assertEquals("tiet kiem thuong", bsb.getTypeOfSaving());
		assertEquals(udi.getUserByID(14).toString(), bsb.getUser().toString());
	}
	
	//--------------------------------------------------------------
	// Tìm không hợp lệ 
	
	@Test
	@DisplayName("Tìm sổ theo mã sổ không tồn tại biên dưới  ")
	void searchBook3()
	{
		BankSavingBook bsb = bsdi.searchBook(1);
		assertNull(bsb);
	}
	
	@Test
	@DisplayName("Tìm sổ theo mã sổ không tồn tại biên trên  ")
	void searchBook4()
	{
		BankSavingBook bsb = bsdi.searchBook(16);
		assertNull(bsb);
	}
	
	//---------------------------Test thêm sổ -----------------------------------
	
	
	@Test
	@DisplayName("Thêm sổ thành công ")
	void insertBook() throws SQLException
	{
		con.setAutoCommit(false);
		try {
			bsdi.con = con;
		assertTrue(bsdi.insertBook(bsb));
		assertNotNull(bsdi.searchBook(bsb.getId()));
		assertEquals(bsdi.searchBook(bsb.getId()).toString(), bsb.toString());
		}
		finally {
			con.rollback();
			con.close();
		}
	}
	
	@Test
	@DisplayName("Thêm sổ không thành công ")
	void insertBook2() throws SQLException
	{
		con.setAutoCommit(false);
		try {
			bsdi.con = con;
		assertFalse(bsdi.insertBook(null));
		assertNull(bsdi.searchBook(bsb.getId()));
		}
		finally {
			con.rollback();
			con.close();
		}
	}
	
	//----------------------------Test rút so----------------------------------
	
	
	@Test
	@DisplayName("Rút sổ không tồn tại ")
	void delBook1() throws SQLException
	{
		con.setAutoCommit(false);
		try {
			bsdi.con = con;
			bsb.setId(8);
		assertFalse(bsdi.rutSo(bsb));
		}
		finally {
			con.rollback();
			con.close();
		}
	}
	
	@Test
	@DisplayName("Rút sổ thành công  ")
	void delBook2() throws SQLException
	{
		con.setAutoCommit(false);
		try {
			bsdi.con = con;
			bsb.setId(11);
		assertTrue(bsdi.rutSo(bsb));
		assertNull(bsdi.searchBook(bsb.getId()));
		}
		finally {
			con.rollback();
			con.close();
		}
	}
	
	
	
}
