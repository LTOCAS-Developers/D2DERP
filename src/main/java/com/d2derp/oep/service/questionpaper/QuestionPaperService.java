package com.d2derp.oep.service.questionpaper;

import java.util.List;

import org.springframework.stereotype.Service;

import com.d2derp.oep.pojo.QuestionPaperPojo;

@Service
public interface QuestionPaperService {
	
	void saveQuestionPaper(QuestionPaperPojo questionPaperPojo);

	List<QuestionPaperPojo> listQuestionPaper();

	QuestionPaperPojo findQuestionPaper(int id);

	void deleteQuestionPaper(int id);

	QuestionPaperPojo editQuestionPaper(QuestionPaperPojo questionPaperPojo);
	
	public void oneToManyExample();
	public void getEntities() ;



}
