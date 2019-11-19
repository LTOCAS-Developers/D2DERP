package com.d2derp.oep.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

@Entity
public class Questions {

	@Id
	@GeneratedValue
	private int questionNumber;

	private String questions;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private String answer;

	@ManyToOne
	private Course course;

	@ManyToOne
	private QuestionsTopic questionsTopic;
	
	 @ManyToOne
	  @JoinTable(name = "QUES_QUESPAPER_ASSO",
	          joinColumns = {@JoinColumn(name = "QUES_ID", insertable = false,
	                  updatable = false, referencedColumnName = "questionNumber")},
	          inverseJoinColumns = {@JoinColumn(name = "QUESPAPER_ID", insertable =false ,
	                  updatable = false, referencedColumnName = "questionPaperId")})
	  private QuestionPaper questionPaper;

	public int getQuestionNumber() {
		return questionNumber;
	}

	public void setQuestionNumber(int questionNumber) {
		this.questionNumber = questionNumber;
	}

	public String getQuestions() {
		return questions;
	}

	public void setQuestions(String questions) {
		this.questions = questions;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public String getOption4() {
		return option4;
	}

	public void setOption4(String option4) {
		this.option4 = option4;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public QuestionsTopic getQuestionsTopic() {
		return questionsTopic;
	}

	public void setQuestionsTopic(QuestionsTopic questionsTopic) {
		this.questionsTopic = questionsTopic;
	}

	public QuestionPaper getQuestionsPaper() {
		return questionPaper;
	}

	public void setQuestionsPaper(QuestionPaper questionPaper) {
		this.questionPaper = questionPaper;
	}
}
