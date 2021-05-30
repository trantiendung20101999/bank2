package model;

import java.util.Date;

public class BankSavingBook {

	private int id;
	private InterestRate interestRate;
	private User user;
	private double money;
	private String branch;
	private String typeOfSaving;
	private int interestTerm;
	private int periodic;
	private String startDate;
	private int checkk;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public InterestRate getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(InterestRate interestRate) {
		this.interestRate = interestRate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getTypeOfSaving() {
		return typeOfSaving;
	}
	public void setTypeOfSaving(String typeOfSaving) {
		this.typeOfSaving = typeOfSaving;
	}
	public int getInterestTerm() {
		return interestTerm;
	}
	public void setInterestTerm(int interestTerm) {
		this.interestTerm = interestTerm;
	}
	public int getPeriodic() {
		return periodic;
	}
	public void setPeriodic(int periodic) {
		this.periodic = periodic;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public int getCheckk() {
		return checkk;
	}
	public void setCheckk(int checkk) {
		this.checkk = checkk;
	}
	public BankSavingBook(InterestRate interestRate, User user, double money, String branch, String typeOfSaving,
			int interestTerm, int periodic, String startDate, int checkk) {
		super();
		this.interestRate = interestRate;
		this.user = user;
		this.money = money;
		this.branch = branch;
		this.typeOfSaving = typeOfSaving;
		this.interestTerm = interestTerm;
		this.periodic = periodic;
		this.startDate = startDate;
		this.checkk = checkk;
	}
	public BankSavingBook(int id, InterestRate interestRate, User user, double money, String branch,
			String typeOfSaving, int interestTerm, int periodic, String startDate, int checkk) {
		super();
		this.id = id;
		this.interestRate = interestRate;
		this.user = user;
		this.money = money;
		this.branch = branch;
		this.typeOfSaving = typeOfSaving;
		this.interestTerm = interestTerm;
		this.periodic = periodic;
		this.startDate = startDate;
		this.checkk = checkk;
	}
	public BankSavingBook() {
		super();
	}
	
	
	
	
}
