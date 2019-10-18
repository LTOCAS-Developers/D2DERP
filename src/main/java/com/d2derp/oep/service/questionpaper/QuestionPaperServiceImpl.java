package com.d2derp.oep.service.questionpaper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.d2derp.oep.dao.example.EntityBDao;
import com.d2derp.oep.dao.example.ExampleDao;
import com.d2derp.oep.dao.questionpaper.QuestionPaperDao;
import com.d2derp.oep.entity.EntityA;
import com.d2derp.oep.entity.EntityB;
import com.d2derp.oep.entity.QuestionPaper;
import com.d2derp.oep.pojo.QuestionPaperPojo;

@Transactional
@Service("questionPaperService")
public class QuestionPaperServiceImpl implements QuestionPaperService {
	
	@Autowired
	public QuestionPaperDao questionPaperDao;
	
	@Autowired
	ExampleDao exampleDao;
	
	@Autowired
	EntityBDao entityBDao;
	public void oneToManyExample() {
		
		System.out.println("iam service");
		EntityB entityB3 = entityBDao.getOne(3);
  	EntityB entityB2 = entityBDao.getOne(2);
//		entityB2.setStrB("testStringB2");
//		entityB1.setStrB("testStringB");


		EntityA entityA = new EntityA();
		entityA.setStrA("testStringNew");
		entityA.setEntityBList(Arrays.asList(entityB2,entityB3));

//		entityB1.setRefEntityA(entityA);
//		entityB2.setRefEntityA(entityA);
		exampleDao.save(entityA);
	}
	public void getEntities() {
//		EntityA entityA = exampleDao.getOne(25);
		//System.out.println(entityA.getEntityBList().get(1).getStrB());
		
//		EntityB entityB3=entityA.getEntityBList().get(1);
		//System.out.println(entityB3.getRefEntityA().getStrA());
		
		System.out.println();
		
		EntityA entityA = exampleDao.getOne(1);
		EntityB entityB3 = entityBDao.getOne(3);
	  	EntityB entityB2 = entityBDao.getOne(2);
	  	EntityB entityB1 = entityBDao.getOne(1);

	  	

		entityA.setEntityBList(Arrays.asList(entityB2,entityB3,entityB1));

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
			questionPaperPojo.setQuestionPaperId(questionPaper.getQuestionPaperId());

			questionPaperPojoList.add(questionPaperPojo);

		}		

		return questionPaperPojoList;

	}



	@Override
	public QuestionPaperPojo findQuestionPaper(int id) {
		Optional<QuestionPaper> questionPaper = questionPaperDao.findById(id);
		QuestionPaperPojo questionPaperPojo = new QuestionPaperPojo();
		questionPaperPojo.setName(questionPaper.get().getName());
		questionPaperPojo.setQuestionPaperId(questionPaper.get().getQuestionPaperId());

		return questionPaperPojo;
	}

	@Override
	public void deleteQuestionPaper(int id) {
		
		questionPaperDao.deleteById(id);
	}

	@Override
	public QuestionPaperPojo editQuestionPaper(QuestionPaperPojo questionPaperPojo) {
		Optional<QuestionPaper> questionPaper = questionPaperDao.findById(questionPaperPojo.getQuestionPaperId());
		System.out.println(questionPaperPojo.getQuestionPaperId());
		questionPaper.get().setName(questionPaperPojo.getName());
		questionPaper.get().setQuestionPaperId(questionPaperPojo.getQuestionPaperId());

		return questionPaperPojo;
	}

}
