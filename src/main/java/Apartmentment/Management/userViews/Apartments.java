package Apartmentment.Management.userViews;

public class Apartments {
	private int ap_id,block_id,floor_no;
	private double price;
	public Apartments(int ap_id, int block_id, int floor_no, double price) {
		super();
		this.ap_id = ap_id;
		this.block_id = block_id;
		this.floor_no = floor_no;
		this.price = price;
	}
	public int getAp_id() {
		return ap_id;
	}
	public void setAp_id(int ap_id) {
		this.ap_id = ap_id;
	}
	public int getBlock_id() {
		return block_id;
	}
	public void setBlock_id(int block_id) {
		this.block_id = block_id;
	}
	public int getFloor_no() {
		return floor_no;
	}
	public void setFloor_no(int floor_no) {
		this.floor_no = floor_no;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
