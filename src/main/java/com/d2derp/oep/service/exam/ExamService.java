package com.d2derp.oep.service.exam;

import java.util.List;

import com.d2derp.oep.pojo.ExamPojo;

public interface ExamService {

	void saveExam(ExamPojo examPojo);

	List<ExamPojo> listExam();

	ExamPojo findExam(int id);

//	ExamPojo editExam(ExamPojo examPojo);

	void deleteExam(int id);

}
