package com.d2derp.oep.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

@Entity
public class Course {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;

	 @ManyToOne
	 @JoinTable(name = "FEEDBACK_ASSO",
	          joinColumns = {@JoinColumn(name = "CourseId", insertable = false,
	                  updatable = false, referencedColumnName = "id")},
	          inverseJoinColumns = {@JoinColumn(name = "FeedBack_Id", insertable =false ,
	                  updatable = false, referencedColumnName = "id")})
	 private FeedBack feedBack;
	 
	 
	
	public FeedBack getFeedBack() {
		return feedBack;
	}

	public void setFeedBack(FeedBack feedBack) {
		this.feedBack = feedBack;
	}

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

	


	
	
}
