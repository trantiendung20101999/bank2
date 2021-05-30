package model;

public class InterestRate {

	private int id;
	private String typeOfSaving;
	private int time;
	private double interestRate;
	public InterestRate() {
		super();
	}
	public InterestRate(String typeOfSaving, int time, double interestRate) {
		super();
		this.typeOfSaving = typeOfSaving;
		this.time = time;
		this.interestRate = interestRate;
	}
	public InterestRate(int id, String typeOfSaving, int time, double interestRate) {
		super();
		this.id = id;
		this.typeOfSaving = typeOfSaving;
		this.time = time;
		this.interestRate = interestRate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTypeOfSaving() {
		return typeOfSaving;
	}
	public void setTypeOfSaving(String typeOfSaving) {
		this.typeOfSaving = typeOfSaving;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	@Override
	public String toString() {
		return "InterestRate [id=" + id + ", typeOfSaving=" + typeOfSaving + ", time=" + time + ", interestRate="
				+ interestRate + "]";
	}
	
	
}
