package com.manoj.spring.cloud.exception;

import java.util.Date;

public class ExceptionResponse {
	
	private Date timeStamp;
	private String messge;
	private String detail;
	
	
	public ExceptionResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ExceptionResponse(Date timeStamp, String messge, String detail) {
		super();
		this.timeStamp = timeStamp;
		this.messge = messge;
		this.detail = detail;
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getMessge() {
		return messge;
	}
	public void setMessge(String messge) {
		this.messge = messge;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	@Override
	public String toString() {
		return "ExceptionResponse [timeStamp=" + timeStamp + ", messge=" + messge + ", detail=" + detail + "]";
	}
	
	

}
