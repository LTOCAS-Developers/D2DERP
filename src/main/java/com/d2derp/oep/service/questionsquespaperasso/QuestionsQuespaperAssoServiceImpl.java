package com.d2derp.oep.service.questionsquespaperasso;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.d2derp.oep.dao.questionpaper.QuestionPaperDao;
import com.d2derp.oep.dao.questions.QuestionsDao;
import com.d2derp.oep.dao.questionsquespaperasso.QuestionsQuespaperAssoDao;
import com.d2derp.oep.entity.QuestionPaper;
import com.d2derp.oep.entity.Questions;
import com.d2derp.oep.entity.QuestionsQuespaperAsso;
import com.d2derp.oep.pojo.QuestionsQuespaperAssoPojo;


@Service
public class QuestionsQuespaperAssoServiceImpl implements QuestionsQuespaperAssoService {

	@Autowired
	QuestionsDao questionsDao;

	@Autowired
	QuestionPaperDao questionsPaperDao;

	@Autowired
	QuestionsQuespaperAssoDao questionsQuestionPaperDao;

	@Override
	public void saveQuestionsQuesPaperAsso(QuestionsQuespaperAssoPojo questionsQuespaperAssoPojo) {
		// TODO Auto-generated method stub

		QuestionsQuespaperAsso questionsQuespaperAsso = new QuestionsQuespaperAsso();
		Questions questions = null;
		QuestionPaper questionPaper = null;
		questionPaper = questionsPaperDao.getOne(questionsQuespaperAssoPojo.getQuestionPaperId());
		for(int i=0;i<questionsQuespaperAssoPojo.getQuestionsId().size();i++) {
			
			questions= questionsDao.getOne(questionsQuespaperAssoPojo.getQuestionsId().get(i));
			System.out.println(questions.getAnswer());
			
			questionsQuespaperAsso.setQuestionPaper(questionPaper);
			System.out.println(questionPaper.getName());
			questionsQuespaperAsso.setQuestions(questions);
			questionsQuestionPaperDao.save(questionsQuespaperAsso);

			
		}
		

			}

}
