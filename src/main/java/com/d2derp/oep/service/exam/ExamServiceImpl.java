package com.d2derp.oep.service.exam;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.d2derp.oep.dao.batch.BatchDao;
import com.d2derp.oep.dao.exam.ExamDao;
import com.d2derp.oep.dao.questionpaper.QuestionPaperDao;
import com.d2derp.oep.entity.Batch;
import com.d2derp.oep.entity.Exam;
import com.d2derp.oep.entity.QuestionPaper;
import com.d2derp.oep.pojo.BatchPojo;
import com.d2derp.oep.pojo.ExamPojo;
import com.d2derp.oep.pojo.QuestionPaperPojo;

@Transactional
@Service
public class ExamServiceImpl implements ExamService {

	@Autowired
	private BatchDao batchDao;

	Date date = new Date();

	@Autowired
	private ExamDao examDao;

	@Autowired
	private QuestionPaperDao questionPaperDao;

	@Override
	public void saveExam(ExamPojo examPojo) {

		Exam exam = new Exam();
		Batch batch = null;
		QuestionPaper questionPaper = null;

		batch = batchDao.getOne(examPojo.getBatchPojo().getId());
		questionPaper = questionPaperDao.getOne(examPojo.getQuestionPaperPojo().getQuestionPaperId());

		exam.setName(examPojo.getName());
		exam.setStartTime(date);
		exam.setEndTime(date);
		exam.setDate(date);
		exam.setBatch(batch);
		exam.setQuestionPaper(questionPaper);
		examDao.save(exam);

	}

	@Override
	public List<ExamPojo> listExam() {
		List<ExamPojo> examPojoList = new ArrayList();
		List<Exam> examList = examDao.findAll();
		
		for (int i = 0; i < examList.size(); i++) {

			Exam exam = examList.get(i);
			BatchPojo batchPojo = new BatchPojo();
			ExamPojo examPojo = new ExamPojo();
			QuestionPaperPojo questionPaperPojo=new QuestionPaperPojo();

			Batch batch = null;
			QuestionPaper questionPaper = null;

			batch = batchDao.getOne(exam.getBatch().getId());
			System.out.println(batch.getName());
			System.out.println(batch.getId());

			questionPaper = questionPaperDao.getOne(exam.getQuestionPaper().getQuestionPaperId());

			examPojo.setName(exam.getName());
			examPojo.setId(exam.getId());
			examPojo.setDate(exam.getDate());
			examPojo.setStartTime(exam.getStartTime());
			examPojo.setEndTime(exam.getEndTime());
			batchPojo.setName(exam.getName());
			batchPojo.setId(exam.getId());
			questionPaperPojo.setName(exam.getQuestionPaper().getName());
			System.out.println(questionPaper.getName());
			questionPaperPojo.setQuestionPaperId(exam.getQuestionPaper().getQuestionPaperId());
			examPojo.setBatchPojo(batchPojo);
			examPojo.setQuestionPaperPojo(questionPaperPojo);
			
			examPojoList.add(examPojo);
			

		}

		return examPojoList;
	}

	@Override
	public ExamPojo findExam(int id) {
		BatchPojo batchPojo = new BatchPojo();
		QuestionPaperPojo questionPaperPojo=new QuestionPaperPojo();
		Optional<Exam> exam = examDao.findById(id);
		ExamPojo examPojo = new ExamPojo();
		examPojo.setId(exam.get().getId());
		examPojo.setName(exam.get().getName());
		examPojo.setDate(exam.get().getDate());
		examPojo.setStartTime(exam.get().getStartTime());
		examPojo.setEndTime(exam.get().getEndTime());
		batchPojo.setName(exam.get().getBatch().getName());
		batchPojo.setId(exam.get().getBatch().getId());
		questionPaperPojo.setName(exam.get().getQuestionPaper().getName());
		questionPaperPojo.setQuestionPaperId(exam.get().getQuestionPaper().getQuestionPaperId());

		examPojo.setBatchPojo(batchPojo);
		examPojo.setQuestionPaperPojo(questionPaperPojo);
		return examPojo;
	}

	@Override
	public void deleteExam(int id) {

		examDao.deleteById(id);

	}

	@Override
	public ExamPojo editExam(ExamPojo examPojo) {

		Optional<Exam> exam = examDao.findById(examPojo.getId());
		exam.get().setId(examPojo.getId());
		exam.get().setName(examPojo.getName());
		exam.get().setDate(date);
		exam.get().setStartTime(date);
		exam.get().setEndTime(date);
		exam.get().getBatch().setName(examPojo.getBatchPojo().getName());
		exam.get().getBatch().setId(examPojo.getBatchPojo().getId());
		exam.get().getQuestionPaper().setName(examPojo.getQuestionPaperPojo().getName());
		exam.get().getQuestionPaper().setQuestionPaperId(examPojo.getQuestionPaperPojo().getQuestionPaperId());
		return examPojo;
	}

}
