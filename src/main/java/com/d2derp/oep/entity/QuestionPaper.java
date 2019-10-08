package com.d2derp.oep.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class QuestionPaper {

		private int id;
	private String name;
	
	private List<QuestionsQuespaperAsso> questionsQuespaperAsso;

	@OneToMany(mappedBy = "questionsQuespaperAssoId.questionPaper", cascade = CascadeType.ALL)
	public List<QuestionsQuespaperAsso> getQuestionsQuespaperAsso() {
		return questionsQuespaperAsso;
	}
	
	public void setQuestionsQuespaperAsso(List<QuestionsQuespaperAsso> questionsQuespaperAsso) {
		this.questionsQuespaperAsso = questionsQuespaperAsso;
	}
	
	@Id
	@GeneratedValue
	@Column(name = "QuestionPaper_ID")
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


