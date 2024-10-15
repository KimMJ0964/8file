package com.skt.tourist.model.vo;

public class Tourist {
	private int tourNo;
	private String tourName;
	private String tourFiled;
	private String tourTema;
	private String tourSeason;
	private String tourImg;
	public Tourist(int tourNo, String tourName, String tourFiled, String tourTema, String tourSeason, String tourImg) {
		super();
		this.tourNo = tourNo;
		this.tourName = tourName;
		this.tourFiled = tourFiled;
		this.tourTema = tourTema;
		this.tourSeason = tourSeason;
		this.tourImg = tourImg;
	}
	public int getTourNo() {
		return tourNo;
	}
	public void setTourNo(int tourNo) {
		this.tourNo = tourNo;
	}
	public String getTourName() {
		return tourName;
	}
	public void setTourName(String tourName) {
		this.tourName = tourName;
	}
	public String getTourFiled() {
		return tourFiled;
	}
	public void setTourFiled(String tourFiled) {
		this.tourFiled = tourFiled;
	}
	public String getTourTema() {
		return tourTema;
	}
	public void setTourTema(String tourTema) {
		this.tourTema = tourTema;
	}
	public String getTourSeason() {
		return tourSeason;
	}
	public void setTourSeason(String tourSeason) {
		this.tourSeason = tourSeason;
	}
	public String getTourImg() {
		return tourImg;
	}
	public void setTourImg(String tourImg) {
		this.tourImg = tourImg;
	}
	@Override
	public String toString() {
		return "Tourist [tourNo=" + tourNo + ", tourName=" + tourName + ", tourFiled=" + tourFiled + ", tourTema="
				+ tourTema + ", tourSeason=" + tourSeason + ", tourImg=" + tourImg + "]";
	}
}
