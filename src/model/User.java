package model;

import java.util.Date;

public class User {

	private int id;
	private String fullname;
	private String username;
	private String password;
	private String address;
	private String phonenumber;
	private String email;
	private String role;
	private String idCard;
	private String dob;
	public User() {
		super();
	}
	public User(int id, String fullname, String username, String password, String address, String phonenumber,
			String email, String role, String idCard, String dob) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.username = username;
		this.password = password;
		this.address = address;
		this.phonenumber = phonenumber;
		this.email = email;
		this.role = role;
		this.idCard = idCard;
		this.dob = dob;
	}
	public User(String fullname, String username, String password, String address, String phonenumber, String email,
			String role, String idCard, String dob) {
		super();
		this.fullname = fullname;
		this.username = username;
		this.password = password;
		this.address = address;
		this.phonenumber = phonenumber;
		this.email = email;
		this.role = role;
		this.idCard = idCard;
		this.dob = dob;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public User(String fullname, String address, String phonenumber, String email, String role, String idCard,
			String dob) {
		super();
		this.fullname = fullname;
		this.address = address;
		this.phonenumber = phonenumber;
		this.email = email;
		this.role = role;
		this.idCard = idCard;
		this.dob = dob;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", fullname=" + fullname + ", username=" + username + ", password=" + password
				+ ", address=" + address + ", phonenumber=" + phonenumber + ", email=" + email + ", role=" + role
				+ ", idCard=" + idCard + ", dob=" + dob + "]";
	}

	
	
}
