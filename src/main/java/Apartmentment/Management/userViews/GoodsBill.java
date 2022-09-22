package Apartmentment.Management.userViews;

public class GoodsBill {
	private int id,ap_id,status;
	private String bill_date;
	private double cost;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAp_id() {
		return ap_id;
	}
	public void setAp_id(int ap_id) {
		this.ap_id = ap_id;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	public String getBill_date() {
		return bill_date;
	}
	public void setBill_date(String bill_date) {
		this.bill_date = bill_date;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	
}
