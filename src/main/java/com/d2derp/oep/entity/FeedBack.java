package com.d2derp.oep.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class FeedBack {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String feedBack;
	@ManyToOne(fetch =FetchType.LAZY)
	private Batch batch;
	
	 @OneToMany
	 @JoinTable(name = "FEEDBACK_ASSO",
	          joinColumns = {@JoinColumn(name = "FeedBack_Id", insertable = false,
	                  updatable = false, referencedColumnName = "id")},
	          inverseJoinColumns = {@JoinColumn(name = "CourseId", insertable =false ,
	                  updatable = false, referencedColumnName = "id")})
	private List<Course> courseList;

	 

	public List<Course> getCourseList() {
		return courseList;
	}
	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getFeedBack() {
		return feedBack;
	}
	public void setFeedBack(String feedBack) {
		this.feedBack = feedBack;
	}
	public Batch getBatch() {
		return batch;
	}
	public void setBatch(Batch batch) {
		this.batch = batch;
	}
	
	
	
}
