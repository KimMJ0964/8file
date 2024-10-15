package com.skt.festival.model.vo;

public class Festival {
	private int fsNo;
	private int tourNo;
	private String fsName;
	private String fsArea;
	private String fsSeason;
	private String fsTema;
	private int price;
	private String fsDate;
	private String fsMbti;
	private String fsImg;
	
	public Festival() {
		super();
	}

	public Festival(int fsNo, int tourNo, String fsName, String fsArea, String fsSeason, String fsTema, int price,
			String fsDate, String fsMbti, String fsImg) {
		super();
		this.fsNo = fsNo;
		this.tourNo = tourNo;
		this.fsName = fsName;
		this.fsArea = fsArea;
		this.fsSeason = fsSeason;
		this.fsTema = fsTema;
		this.price = price;
		this.fsDate = fsDate;
		this.fsMbti = fsMbti;
		this.fsImg = fsImg;
	}

	public int getFsNo() {
		return fsNo;
	}

	public void setFsNo(int fsNo) {
		this.fsNo = fsNo;
	}

	public int getTourNo() {
		return tourNo;
	}

	public void setTourNo(int tourNo) {
		this.tourNo = tourNo;
	}

	public String getFsName() {
		return fsName;
	}

	public void setFsName(String fsName) {
		this.fsName = fsName;
	}

	public String getFsArea() {
		return fsArea;
	}

	public void setFsArea(String fsArea) {
		this.fsArea = fsArea;
	}

	public String getFsSeason() {
		return fsSeason;
	}

	public void setFsSeason(String fsSeason) {
		this.fsSeason = fsSeason;
	}

	public String getFsTema() {
		return fsTema;
	}

	public void setFsTema(String fsTema) {
		this.fsTema = fsTema;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getFsDate() {
		return fsDate;
	}

	public void setFsDate(String fsDate) {
		this.fsDate = fsDate;
	}

	public String getFsMbti() {
		return fsMbti;
	}

	public void setFsMbti(String fsMbti) {
		this.fsMbti = fsMbti;
	}

	public String getFsImg() {
		return fsImg;
	}

	public void setFsImg(String fsImg) {
		this.fsImg = fsImg;
	}

	@Override
	public String toString() {
		return "Festival [fsNo=" + fsNo + ", tourNo=" + tourNo + ", fsName=" + fsName + ", fsArea=" + fsArea
				+ ", fsSeason=" + fsSeason + ", fsTema=" + fsTema + ", price=" + price + ", fsDate=" + fsDate
				+ ", fsMbti=" + fsMbti + ", fsImg=" + fsImg + "]";
	}
	
}
