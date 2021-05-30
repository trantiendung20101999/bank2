package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Web.BankServlet;

class TinhLaiTest {

	BankServlet bs;
	
	@BeforeEach
	void setUp()
	{
		bs = new BankServlet();
	}
	
	//---------------Kiểm tra tính lãi đến thời điểm tính lãi ---------------
	
	@Test
	@DisplayName("Kiểm tra số tiền nhập vào nhỏ hơn 1 triệu  ")
	void testLai()
	{
		double s=bs.tinhtienlaihientai(999999, "2021-04-30", 2.5, 3);
		assertEquals(s, -1);
	}
	
	@Test
	@DisplayName("Kiểm tra ngày bắt đầu lớn hơn ngày hiện tại  ")
	void testLai2()
	{
		double s=bs.tinhtienlaihientai(10000000, "2021-07-30", 2.5, 3);
		assertEquals(s, -1);
	}
	
	@Test
	@DisplayName("Kiểm tra năm hiện tại bẳng năm bắt đầu với ngày trước bắt đầu trước ngày hiện tại ")
	void testLai3()
	{
		double s=bs.tinhtienlaihientai(1000000, "2021-01-30", 2.5, 1);
		assertEquals(s, 2064);
	}
	
	@Test
	@DisplayName("Kiểm tra năm hiện tại sau năm bắt đầu ")
	void testLai4()
	{
		double s=bs.tinhtienlaihientai(1000000, "2020-01-30", 2.5, 1);
		assertEquals(s,2094);
	}
	
	@Test
	@DisplayName("Kiểm tra năm hiện tại bằng năm bắt đầu , tháng hiện tại bằng tháng bắt đầu và ngày hiện tại lớn hơn người bắt đầu ")
	void testLai5()
	{
		double s=bs.tinhtienlaihientai(1000000, "2021-05-19", 2.5, 1);
		assertEquals(s,82);
	}
	
	@Test
	@DisplayName("Kiểm ngày tính vào ngày mở ")
	void testLai6()
	{
		double s=bs.tinhtienlaihientai(1000000, "2021-05-21", 2.5, 1);
		assertEquals(s,0);
	}
	
	//---------------------------Kiểm tra tính lãi tới hết kỳ hạn -------------------------

	
	@Test
	@DisplayName("Tính lãi hết kỳ hạn với số nhỏ hơn 1 triệu   ")
	void testLai7()
	{
		double s=bs.tinhtienlaidinhky(999999, 2.5, 1);
		assertEquals(s,-1);
	}
	
	@Test
	@DisplayName("Tính lãi hết kỳ hạn hợp lệ ")
	void testLai8()
	{
		double s=bs.tinhtienlaidinhky(1000000, 2.5, 1);
		assertEquals(s,205479);
	}
}
