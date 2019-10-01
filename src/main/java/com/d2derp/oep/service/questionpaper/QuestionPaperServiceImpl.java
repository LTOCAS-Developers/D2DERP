package com.d2derp.oep.service.questionpaper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.d2derp.oep.dao.questionpaper.QuestionPaperDao;
import com.d2derp.oep.entity.QuestionPaper;
import com.d2derp.oep.pojo.QuestionPaperPojo;

@Transactional
@Service("QuestionPaperService")
public class QuestionPaperServiceImpl implements QuestionPaperService {

	@Autowired
	public QuestionPaperDao questionPaperDao;

	public QuestionPaperDao getQuestionPaperDao() {
		return questionPaperDao;
	}

	public void setQuestionPaperDao(QuestionPaperDao questionPaperDao) {
		this.questionPaperDao = questionPaperDao;
	}

	@Override
	public void saveQuestionPaper(QuestionPaperPojo questionPaperPojo) {
		QuestionPaper questionPaper = new QuestionPaper();
		questionPaper.setName(questionPaperPojo.getName());
		questionPaperDao.save(questionPaper);
	}

	@Override
	public List<QuestionPaperPojo> listQuestionPaper() {
		List<QuestionPaperPojo> questionPaperPojoList = new ArrayList();
		List<QuestionPaper> questionPaperList = questionPaperDao.findAll();
		for(int i=0; i<questionPaperList.size(); i++) {
			QuestionPaper questionPaper = questionPaperList.get(i);

			QuestionPaperPojo questionPaperPojo = new QuestionPaperPojo();
			questionPaperPojo.setName(questionPaper.getName());
			questionPaperPojo.setId(questionPaper.getId());

			questionPaperPojoList.add(questionPaperPojo);

		}		

		return questionPaperPojoList;

	}



	@Override
	public QuestionPaperPojo findQuestionPaper(int id) {
		Optional<QuestionPaper> questionPaper = questionPaperDao.findById(id);
		QuestionPaperPojo questionPaperPojo = new QuestionPaperPojo();
		questionPaperPojo.setName(questionPaper.get().getName());
		questionPaperPojo.setId(questionPaper.get().getId());

		return questionPaperPojo;
	}

	@Override
	public void deleteQuestionPaper(int id) {
		
		questionPaperDao.deleteById(id);
	}

	@Override
	public QuestionPaperPojo editQuestionPaper(QuestionPaperPojo questionPaperPojo) {
		Optional<QuestionPaper> questionPaper = questionPaperDao.findById(questionPaperPojo.getId());
		System.out.println(questionPaperPojo.getId());
		questionPaper.get().setName(questionPaperPojo.getName());
		questionPaper.get().setId(questionPaperPojo.getId());

		return questionPaperPojo;
	}

}
