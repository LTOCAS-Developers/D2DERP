package com.d2derp.oep.service.quesquespaperservice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.d2derp.oep.dao.questionpaper.QuestionPaperDao;
import com.d2derp.oep.dao.questions.QuestionsDao;
import com.d2derp.oep.entity.QuestionPaper;
import com.d2derp.oep.entity.Questions;
import com.d2derp.oep.pojo.QuestionsQuespaperAssoPojo;

@Transactional
@Service("quesQuesPaperServiceImpl")
public class QuesQuesPaperServiceImpl implements QuesQuesPaperService {

	@Autowired
	public QuestionsDao questionsDao;

	@Autowired
	public QuestionPaperDao questionPaperDao;

	@Override
	public void saveQuestionsAssociation(QuestionsQuespaperAssoPojo questionsQuespaperAssoPojo) {

		QuestionPaper questionPaper = questionPaperDao.getOne(questionsQuespaperAssoPojo.getQuestionPaperId());

		List<Questions> questionList = new ArrayList<Questions>();

		for (int i = 0; i < questionsQuespaperAssoPojo.getQuestionsId().size(); i++) {
			// ,
			Questions question = new Questions();
			question.setQuestionNumber(questionsQuespaperAssoPojo.getQuestionsId().get(i));

			questionList.add(question);

		}

		questionPaper.getQuestionsList().addAll(questionList);

	}

	@Override
	public void deleteQuestionsAssociation(QuestionsQuespaperAssoPojo questionsQuespaperAssoPojo) {

		QuestionPaper questionPaper = questionPaperDao.getOne(questionsQuespaperAssoPojo.getQuestionPaperId());

		List<Questions> questionList = questionPaper.getQuestionsList();
		System.out.println(questionList.size());

		for (int i = 0; i < questionsQuespaperAssoPojo.getQuestionsId().size(); i++) {
			System.out.println("hhhhhh");
			for (int j = 0; j < questionList.size(); j++) {

				if (questionsQuespaperAssoPojo.getQuestionsId().get(i) == questionList.get(j).getQuestionNumber()) {
					questionList.remove(j);
				}
			}

			System.out.println(questionList.size());

		}
		System.out.println(questionList.size());

	}

}
