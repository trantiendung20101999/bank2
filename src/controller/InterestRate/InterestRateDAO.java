package controller.InterestRate;

import model.InterestRate;

public interface InterestRateDAO {

	// Tim bang lai suat theo id
	public InterestRate getInterestRateByID(int id);
	// tim bang lai suat theo ky han va loai lai suat
	public InterestRate getInterestRateByTerm_Type(int term,String type);
	
}
