package Apartmentment.Management.userViews;

public class Residents {
	String name,gender,age,blood_group;
	int ap_id,r_id;
	public Residents(String name, String gender, String age, String blood_group, int ap_id, int r_id) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.blood_group = blood_group;
		this.ap_id = ap_id;
		this.r_id = r_id;
	}
	public Residents() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getBlood_group() {
		return blood_group;
	}
	public void setBlood_group(String blood_group) {
		this.blood_group = blood_group;
	}
	public int getAp_id() {
		return ap_id;
	}
	public void setAp_id(int ap_id) {
		this.ap_id = ap_id;
	}
	public int getR_id() {
		return r_id;
	}
	public void setR_id(int r_id) {
		this.r_id = r_id;
	}
	
	
	
}
