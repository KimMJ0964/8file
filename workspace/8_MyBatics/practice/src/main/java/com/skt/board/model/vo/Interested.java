package com.skt.board.model.vo;

public class Interested {
	private String memId;
	private int fsNo;
	private String courseNo;
	private int tourNo;
	
	public Interested() {
		super();
	}

	public Interested(String memId, int fsNo, String courseNo, int tourNo) {
		super();
		this.memId = memId;
		this.fsNo = fsNo;
		this.courseNo = courseNo;
		this.tourNo = tourNo;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public int getFsNo() {
		return fsNo;
	}

	public void setFsNo(int fsNo) {
		this.fsNo = fsNo;
	}

	public String getCourseNo() {
		return courseNo;
	}

	public void setCourseNo(String courseNo) {
		this.courseNo = courseNo;
	}

	public int getTourNo() {
		return tourNo;
	}

	public void setTourNo(int tourNo) {
		this.tourNo = tourNo;
	}

	@Override
	public String toString() {
		return "Interested [memId=" + memId + ", fsNo=" + fsNo + ", courseNo=" + courseNo + ", tourNo=" + tourNo + "]";
	}
}
