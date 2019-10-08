package com.d2derp.oep.entity;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "QUESTIONS_QUESTIONPAPER_ASSO")
@AssociationOverrides({
    @AssociationOverride(name = "questionsQuespaperAssoId.questions",
        joinColumns = @JoinColumn(name = "Questions_ID")),
    @AssociationOverride(name = "questionsQuespaperAssoId.questionPaper",
        joinColumns = @JoinColumn(name = "QuestionPaper_ID")) })
public class QuestionsQuespaperAsso {

	@EmbeddedId
	private QuestionsQuespaperAssoId questionsQuespaperAssoId=new QuestionsQuespaperAssoId();
	
	  @Transient
	    public Questions getQuestions() {
	        return getQuestionsQuespaperAssoId().getQuestions();
	    }
	 
	    public void setQuestions(Questions questions) {
	    	getQuestionsQuespaperAssoId().setQuestions(questions);
	    }
	 
	    @Transient
	    public QuestionPaper getQuestionPaper() {
	        return getQuestionsQuespaperAssoId().getQuestionPaper();
	    }
	 
	    public void setQuestionPaper(QuestionPaper questionPaper) {
	    	getQuestionsQuespaperAssoId().setQuestionPaper(questionPaper);
	    }

	public QuestionsQuespaperAssoId getQuestionsQuespaperAssoId() {
		return questionsQuespaperAssoId;
	}

	public void setQuestionsQuespaperAssoId(QuestionsQuespaperAssoId questionsQuespaperAssoId) {
		this.questionsQuespaperAssoId = questionsQuespaperAssoId;
	}
	
}
