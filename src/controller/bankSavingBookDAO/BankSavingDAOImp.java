package controller.bankSavingBookDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import controller.ConnectDB;
import controller.InterestRate.InterestRateDAOImp;
import controller.userDAO.UserDAOImp;
import model.BankSavingBook;
import model.InterestRate;
import model.User;

public class BankSavingDAOImp implements BankSavingBookDAO{

	public static Connection con = ConnectDB.connection();
	PreparedStatement pre;
	
	// tim kiem so tiet kiem theo ma so 
	
	@Override
	public BankSavingBook searchBook(int id) {
		String SEARCH_BOOK_BYID_SQL= "SELECT * FROM BankSavingBooks WHERE ID=?";
		UserDAOImp userDAO = new UserDAOImp();
		InterestRateDAOImp interest = new InterestRateDAOImp();
		BankSavingBook bsb = new BankSavingBook();
		try {
			pre=con.prepareStatement(SEARCH_BOOK_BYID_SQL);
			pre.setInt(1, id);
			ResultSet rs = pre.executeQuery();
			if(rs.next())
			{
				User u = userDAO.getUserByID(rs.getInt("UsersID"));
				InterestRate interestRate = interest.getInterestRateByID(rs.getInt("InterestRateID"));
				double money = rs.getDouble("Money");
				String branch = rs.getString("branch");
				String typeofsaving = rs.getString("TypeOfSaving");
				int interestterm = rs.getInt("InterestTerm");
				String startDate = rs.getString("StartDate");
				int periodic = rs.getInt("periodic");
				int checkk = rs.getInt("checkk");
				bsb.setId(id);
				bsb.setUser(u);
				bsb.setInterestRate(interestRate);
				bsb.setMoney(money);
				bsb.setBranch(branch);
				bsb.setTypeOfSaving(typeofsaving);
				bsb.setInterestTerm(interestterm);
				bsb.setStartDate(startDate);
				bsb.setPeriodic(periodic);
				bsb.setCheckk(checkk);
				return bsb;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean insertBook(BankSavingBook bsb) {
		String INSERT_BOOK_SQL="INSERT INTO BankSavingBooks(InterestRateID,UsersID,Money,Branch,TypeOfSaving,InterestTerm,StartDate,periodic,checkk) VALUES(?,?,?,?,?,?,?,?,?)";
		if(bsb!=null)
		{
		try {
			pre = con.prepareStatement(INSERT_BOOK_SQL,Statement.RETURN_GENERATED_KEYS);
			
			pre.setInt(1, bsb.getInterestRate().getId());
			pre.setInt(2, bsb.getUser().getId());
			pre.setDouble(3, bsb.getMoney());
			pre.setString(4, bsb.getBranch());;
			pre.setString(5, bsb.getTypeOfSaving());
			pre.setInt(6, bsb.getInterestTerm());
			pre.setString(7,bsb.getStartDate());
			pre.setInt(8,bsb.getPeriodic());
			pre.setInt(9, bsb.getCheckk());
			boolean result = pre.executeUpdate()>0;
			ResultSet rs = pre.getGeneratedKeys();
			if(rs.next())
			{
				bsb.setId(rs.getInt(1));
			}
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		
		return false;
	}

	@Override
	public boolean rutSo(BankSavingBook bsb) {
		String RUT_SO_SQL="UPDATE BankSavingBooks SET checkk=1 WHERE ID=?";
		try {
			pre = con.prepareStatement(RUT_SO_SQL);
			pre.setInt(1, bsb.getId());
			boolean result = pre.executeUpdate()>0;
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
	}
	
	

}
