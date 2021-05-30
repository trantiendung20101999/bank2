package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import controller.ConnectDB;
import controller.InterestRate.InterestRateDAOImp;
import controller.bankSavingBookDAO.BankSavingDAOImp;
import model.BankSavingBook;
import model.InterestRate;
import model.User;

class InterestRateDAOImpTest {

	Connection con;
	InterestRate ir;
	InterestRateDAOImp irdi;
	
	@BeforeEach
	void setUp()
	{
		irdi = new InterestRateDAOImp();
		con = ConnectDB.connection();

	}
	
	
	//-----------------Test Tìm kiếm bảng lãi suất theo id-----------------------------
	// Vào thời điểm test ID trong miền giá trị [1,24]  
	//---------------------------------------------------------------------------------
	
	
	//---------------- Tìm kiếm tồn tại ----------------------------
	
	@Test
	@DisplayName("Tìm kiếm bảng lãi suất theo id tồn tại biên dưới ")
	void searchInterestTerm()
	{
		ir = irdi.getInterestRateByID(1);
		assertNotNull(ir);
		assertEquals(1, ir.getId());
		assertEquals(2.55, ir.getInterestRate());
		assertEquals(1, ir.getTime());
		assertEquals("tiet kiem thuong"	, ir.getTypeOfSaving());
	}
	@Test
	@DisplayName("Tìm kiếm bảng lãi suất theo id tồn tại biên trên ")
	void searchInterestTerm2()
	{
		ir = irdi.getInterestRateByID(24);
		assertNotNull(ir);
		assertEquals(24, ir.getId());
		assertEquals(5.3, ir.getInterestRate());
		assertEquals(12, ir.getTime());
		assertEquals("tiet kiem phat loc"	, ir.getTypeOfSaving());
	}
	
	//---------------------------------------------------------------------------------
	
	//--------------------- Tìm kiếm không tồn tại ---------------------------
	
	@Test
	@DisplayName("Tìm kiếm bảng lãi suất theo id không tồn tại biên dưới  ")
	void searchInterestTerm3()
	{
		ir = irdi.getInterestRateByID(0);
		assertNull(ir);
	}
	
	@Test
	@DisplayName("Tìm kiếm bảng lãi suất theo id không tồn tại biên trên  ")
	void searchInterestTerm4()
	{
		ir = irdi.getInterestRateByID(25);
		assertNull(ir);
	}
		
	
	//----------------------Tìm kiếm bảng lãi suất theo kỳ hạn và loại tiết kiệm ------------------
	// Vào thời điểm test có 2 loại tiết kiệm "tiet kiem thuong" và "tiet kiem phat loc"
	// kỳ hạn nằm trong miền giá trị [1,12] 
	//--------------------------------------------------------------------------------------------
	
	
	// Tìm kiếm hợp lệ 
	
	@Test
	@DisplayName("Tìm kiếm bảng lãi suất theo kỳ hạn vào loại tiết kiệm tồn tại"
			+ "(kỳ hạn biên dưới , tiết kiệm thường)  ")
	void searchInterestTermByTerm()
	{
		ir = irdi.getInterestRateByTerm_Type(1, "tiet kiem thuong");
		assertNotNull(ir);
		assertEquals(1, ir.getId());
		assertEquals(2.55, ir.getInterestRate());
		assertEquals(1, ir.getTime());
		assertEquals("tiet kiem thuong"	, ir.getTypeOfSaving());
	}
	
	@Test
	@DisplayName("Tìm kiếm bảng lãi suất theo kỳ hạn vào loại tiết kiệm tồn tại"
			+ "(kỳ hạn biên trên , tiết kiệm thường)  ")

	void searchInterestTermByTerm2()
	{
		ir = irdi.getInterestRateByTerm_Type(12, "tiet kiem thuong");
		assertNotNull(ir);
		assertEquals(12, ir.getId());
		assertEquals(4.6, ir.getInterestRate());
		assertEquals(12, ir.getTime());
		assertEquals("tiet kiem thuong"	, ir.getTypeOfSaving());
	}
	
	@Test
	@DisplayName("Tìm kiếm bảng lãi suất theo kỳ hạn vào loại tiết kiệm tồn tại"
			+ "(kỳ hạn biên dưới , tiết kiệm phát lộc )  ")
	void searchInterestTermByTerm3()
	{
		ir = irdi.getInterestRateByTerm_Type(1, "tiet kiem phat loc");
		assertNotNull(ir);
		assertEquals(13, ir.getId());
		assertEquals(3, ir.getInterestRate());
		assertEquals(1, ir.getTime());
		assertEquals("tiet kiem phat loc"	, ir.getTypeOfSaving());
	}
	
	@Test
	@DisplayName("Tìm kiếm bảng lãi suất theo kỳ hạn vào loại tiết kiệm tồn tại"
			+ "(kỳ hạn biên trên , tiết kiệm phát lộc )  ")

	void searchInterestTermByTerm4()
	{
		ir = irdi.getInterestRateByTerm_Type(12, "tiet kiem phat loc");
		assertNotNull(ir);
		assertEquals(24, ir.getId());
		assertEquals(5.3, ir.getInterestRate());
		assertEquals(12, ir.getTime());
		assertEquals("tiet kiem phat loc"	, ir.getTypeOfSaving());
	}
	
	//---------------------------------------------------------------------------------
	// Tìm kiếm không hợp lệ 
	
	@Test
	@DisplayName("Tìm kiếm bảng lãi suất theo kỳ hạn vào loại tiết kiệm không tồn tại"
			+ "(kỳ hạn biên dưới , tiết kiệm thường)  ")
	void searchInterestTermByTerm5()
	{
		ir = irdi.getInterestRateByTerm_Type(0, "tiet kiem thuong");
		assertNull(ir);
	}
	
	@Test
	@DisplayName("Tìm kiếm bảng lãi suất theo kỳ hạn vào loại tiết kiệm không tồn tại"
			+ "(kỳ hạn biên trên , tiết kiệm thường)  ")

	void searchInterestTermByTerm6()
	{
		ir = irdi.getInterestRateByTerm_Type(13, "tiet kiem thuong");
		assertNull(ir);
	}
	
	@Test
	@DisplayName("Tìm kiếm bảng lãi suất theo kỳ hạn vào loại tiết kiệm không tồn tại"
			+ "(kỳ hạn biên dưới , tiết kiệm phát lộc )  ")
	void searchInterestTermByTerm7()
	{
		ir = irdi.getInterestRateByTerm_Type(0, "tiet kiem phat loc");
		assertNull(ir);
	}
	
	@Test
	@DisplayName("Tìm kiếm bảng lãi suất theo kỳ hạn vào loại tiết kiệm không tồn tại"
			+ "(kỳ hạn biên trên , tiết kiệm phát lộc )  ")

	void searchInterestTermByTerm8()
	{
		ir = irdi.getInterestRateByTerm_Type(13, "tiet kiem phat loc");
		assertNull(ir);
	}
	
}
