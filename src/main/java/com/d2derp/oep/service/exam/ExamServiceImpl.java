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
import com.d2derp.oep.entity.Batch;
import com.d2derp.oep.entity.Exam;
import com.d2derp.oep.pojo.BatchPojo;
import com.d2derp.oep.pojo.ExamPojo;

@Transactional
@Service
public class ExamServiceImpl implements ExamService {

	@Autowired
	private BatchDao batchDao;
	
	Date date=new Date();

	@Autowired
	private ExamDao examDao;
	


	public ExamDao getExamDao() {
		return examDao;
	}

	public void setExamDao(ExamDao examDao) {
		this.examDao = examDao;
	}

	@Override
	public void saveExam(ExamPojo examPojo) {


		Exam exam = new Exam();
		Batch batch = null;
		if (examPojo.getBatchPojo().getId() == 0) {

			batch = batchDao.getOne(1);
		}
		exam.setName(examPojo.getName());
		exam.setStartTime(date);
		exam.setEndTime(date);
		exam.setDate(date);
        exam.setBatch(batch);

		examDao.save(exam);

	}

	@Override
	public List<ExamPojo> listExam() {
		List<ExamPojo> examPojoList = new ArrayList();
		List<Exam> examList = examDao.findAll();
		BatchPojo batchPojo = new BatchPojo();

		for (int i = 0; i < examList.size(); i++) {

			Exam exam = examList.get(i);

			ExamPojo examPojo = new ExamPojo();
			examPojo.setName(exam.getName());
			examPojo.setId(exam.getId());
			examPojo.setDate(exam.getDate());
			examPojo.setStartTime(exam.getStartTime());
			examPojo.setEndTime(exam.getEndTime());
			batchPojo.setName(exam.getBatch().getName());
			batchPojo.setId(exam.getBatch().getId());
			examPojo.setBatchPojo(batchPojo);
			examPojoList.add(examPojo);

		}

		return examPojoList;
	}

	@Override
	public ExamPojo findExam(int id) {
		BatchPojo batchPojo =new BatchPojo();
		Optional<Exam> exam = examDao.findById(id);
		ExamPojo examPojo =new ExamPojo();
		examPojo.setId(exam.get().getId());
		examPojo.setName(exam.get().getName());
		examPojo.setDate(exam.get().getDate());
		examPojo.setStartTime(exam.get().getStartTime());
		examPojo.setEndTime(exam.get().getEndTime());
		batchPojo.setName(exam.get().getBatch().getName());
		batchPojo.setId(exam.get().getBatch().getId());
		examPojo.setBatchPojo(batchPojo);
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

		return examPojo;
	}

}
