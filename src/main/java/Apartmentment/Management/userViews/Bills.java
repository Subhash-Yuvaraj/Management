package Apartmentment.Management.userViews;

public class Bills {
	private int id,ref_id,ap_id;
	private String ar_date,pa_date,mode;
	private double cost;
	public Bills(int id, int ref_id, int ap_id, String ar_date, String pa_date, String mode, double cost) {
		super();
		this.id = id;
		this.ref_id = ref_id;
		this.ap_id = ap_id;
		this.ar_date = ar_date;
		this.pa_date = pa_date;
		this.mode = mode;
		this.cost = cost;
	}
	public Bills() {
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRef_id() {
		return ref_id;
	}
	public void setRef_id(int ref_id) {
		this.ref_id = ref_id;
	}
	public int getAp_id() {
		return ap_id;
	}
	public void setAp_id(int ap_id) {
		this.ap_id = ap_id;
	}
	public String getAr_date() {
		return ar_date;
	}
	public void setAr_date(String ar_date) {
		this.ar_date = ar_date;
	}
	public String getPa_date() {
		return pa_date;
	}
	public void setPa_date(String pa_date) {
		this.pa_date = pa_date;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	
}
