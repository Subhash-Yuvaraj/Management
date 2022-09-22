package Apartmentment.Management.userViews;

public class Contacts {
	private int r_id;
	private String phone;
	public int getR_id() {
		return r_id;
	}
	public void setR_id(int r_id) {
		this.r_id = r_id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Contacts(int r_id, String phone) {
		super();
		this.r_id = r_id;
		this.phone = phone;
	}
	public Contacts() {
		super();
	}
}
