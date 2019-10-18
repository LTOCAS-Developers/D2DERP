package com.d2derp.oep.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class QuestionPaper {

	 @Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	private int questionPaperId;
	private String name;
	
	 @OneToMany
	  @JoinTable(name = "QUES_QUESPAPER_ASSO",
	          joinColumns = {@JoinColumn(name = "QUESPAPER_ID", referencedColumnName = "questionPaperId")},
	          inverseJoinColumns = {@JoinColumn(name = "QUES_ID", referencedColumnName = "questionNumber")}
	  )
	  private List<Questions> questionsList;

	public int getQuestionPaperId() {
		return questionPaperId;
	}

	public void setQuestionPaperId(int questionPaperId) {
		this.questionPaperId = questionPaperId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Questions> getQuestionsList() {
		return questionsList;
	}

	public void setQuestionsList(List<Questions> questionsList) {
		this.questionsList = questionsList;
	}
}
