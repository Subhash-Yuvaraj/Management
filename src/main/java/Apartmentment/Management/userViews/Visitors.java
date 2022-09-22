package Apartmentment.Management.userViews;

public class Visitors {
	private int v_id;
	private String name,phone,in_time,out_time;
	public int getV_id() {
		return v_id;
	}
	public void setV_id(int v_id) {
		this.v_id = v_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getIn_time() {
		return in_time;
	}
	public void setIn_time(String in_time) {
		this.in_time = in_time;
	}
	public String getOut_time() {
		return out_time;
	}
	public void setOut_time(String out_time) {
		this.out_time = out_time;
	}
	public Visitors(int v_id, String name, String phone, String in_time, String out_time) {
		super();
		this.v_id = v_id;
		this.name = name;
		this.phone = phone;
		this.in_time = in_time;
		this.out_time = out_time;
	}
	public Visitors() {
		super();
		// TODO Auto-generated constructor stub
	}
}
