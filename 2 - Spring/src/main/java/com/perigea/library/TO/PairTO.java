package com.perigea.library.TO;

public class PairTO {
	
	private Integer id;
	private String pair;
	private float currentPrice;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPair() {
		return pair;
	}
	public void setPair(String pair) {
		this.pair = pair;
	}
	public float getCurrentPrice() {
		return currentPrice;
	}
	public void setCurrentPrice(float currentPrice) {
		this.currentPrice = currentPrice;
	}
	@Override
	public String toString() {
		return "PairTO [id=" + id + ", pair=" + pair + ", currentPrice=" + currentPrice + "]";
	}
}
