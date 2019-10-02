package com.d2derp.oep.pojo;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class ExamPojo {

	private int id;
	private String name;
	private Date startTime;
	private Date endTime;
	private Date date;



	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	private BatchPojo batchPojo;
	
	public BatchPojo getBatchPojo() {
		return batchPojo;
	}
	public void setBatchPojo(BatchPojo batchPojo) {
		this.batchPojo = batchPojo;
	}
	
}
