package controller.InterestRate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controller.ConnectDB;
import model.InterestRate;

public class InterestRateDAOImp implements InterestRateDAO{

	public static Connection con = ConnectDB.connection();
	@Override
	public InterestRate getInterestRateByID(int id) {
		InterestRate interest = null;
		
		String getInterestRate_SQL = "SELECT * FROM InterestRate WHERE ID=?";
		
		try {
			PreparedStatement pre = con.prepareStatement(getInterestRate_SQL);
			pre.setInt(1, id);
			ResultSet rs  = pre.executeQuery();
			if(rs.next())
			{
				interest = new InterestRate();
				interest.setId(id);
				interest.setTime(rs.getInt("Time"));
				interest.setTypeOfSaving(rs.getString("TypeOfSaving"));
				interest.setInterestRate(rs.getDouble("interestRate"));
				return interest;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return interest;
	}

	@Override
	public InterestRate getInterestRateByTerm_Type(int term, String type) {
		
		String GET_INTERESTRATE_BYTERM_TYPE ="SELECT * FROM InterestRate WHERE Time=? AND TypeOfSaving=?";
		InterestRate interest = new InterestRate();
		try {
			PreparedStatement pre = con.prepareStatement(GET_INTERESTRATE_BYTERM_TYPE);
			pre.setInt(1, term);
			pre.setString(2, type);
			ResultSet rs = pre.executeQuery();
			if(rs.next())
			{
				int id = rs.getInt("ID");
				double interestRate = rs.getDouble("InterestRate");
				interest.setId(id);
				interest.setInterestRate(interestRate);
				interest.setTime(term);
				interest.setTypeOfSaving(type);
				return interest;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
}
