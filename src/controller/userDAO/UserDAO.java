package controller.userDAO;

import java.util.ArrayList;

import model.BankSavingBook;
import model.User;

public interface UserDAO {

	//them nguoi dung khong dang ky tai khoan
		public boolean addUser(User user);
	// tim kiem nguoi dung theo cmnd/cccd/hochieu
		public User searchUserByidCard(String idcard);
	// them mot tai khoan moi
		public boolean insertUser(User user);
	// kiem tra tai khoan co ton tai khong?
		public User checkAccount(String username, String password);
	// lay thong tin ve chuc nang cua nguoi dung
		public String getRole(User user);
	// lay ra danh sach so tiet kiem cua nguoi dung
		public ArrayList<BankSavingBook> getBankSavingBook(User user);
	// kiem tra ten tai khoan nguoi dung da ton tai
		public boolean checkUsername(String username);
	// tim kiem nguoi dung theo id
		public User getUserByID(int id);
	// add username password
		public boolean addUsername(User u);
		
		
}
