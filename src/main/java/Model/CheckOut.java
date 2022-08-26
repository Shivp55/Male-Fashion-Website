package Model;

public class CheckOut {
	private double total;
	private int id,pincode,cusid;
	private String fname,lname,contact,email,country,state,city,staddr,apmt,notes;
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public int getCusid() {
		return cusid;
	}
	public void setCusid(int cusid) {
		this.cusid = cusid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStaddr() {
		return staddr;
	}
	public void setStaddr(String staddr) {
		this.staddr = staddr;
	}
	public String getApmt() {
		return apmt;
	}
	public void setApmt(String apmt) {
		this.apmt = apmt;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	@Override
	public String toString() {
		return "CheckOut [total=" + total + ", id=" + id + ", pincode=" + pincode + ", cusid=" + cusid + ", fname="
				+ fname + ", lname=" + lname + ", contact=" + contact + ", email=" + email + ", country=" + country
				+ ", state=" + state + ", city=" + city + ", staddr=" + staddr + ", apmt=" + apmt + ", notes=" + notes
				+ "]";
	}
	
}