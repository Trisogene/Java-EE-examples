package com.perigea.library.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pair {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;
	
	@Column
	private String pair;
	
	@Column
	private float currentPrice;

	public int getId() {
		return id;
	}

	public void setId(int id) {
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
		return "Pair [id=" + id + ", pair=" + pair + ", currentPrice=" + currentPrice + "]";
	}

}
