package com.perigea.aggregator.TO;

public class CovidDataTO {
	private Integer codice;
	
	private String data;
	private String comune;
	private String provincia;
	private String sigla;
	private Integer dose1;
	private Integer dose2;
	
	public Integer getCodice() {
		return codice;
	}
	public void setCodice(Integer codice) {
		this.codice = codice;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getComune() {
		return comune;
	}
	public void setComune(String comune) {
		this.comune = comune;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public Integer getDose1() {
		return dose1;
	}
	public void setDose1(Integer dose1) {
		this.dose1 = dose1;
	}
	public Integer getDose2() {
		return dose2;
	}
	public void setDose2(Integer dose2) {
		this.dose2 = dose2;
	}
	
	@Override
	public String toString() {
		return "CovidDataTO [codice=" + codice + ", data=" + data + ", comune=" + comune + ", provincia=" + provincia
				+ ", sigla=" + sigla + ", dose1=" + dose1 + ", dose2=" + dose2 + "]";
	}
	
}
