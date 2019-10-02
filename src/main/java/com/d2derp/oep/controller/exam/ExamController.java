package com.d2derp.oep.controller.exam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.d2derp.oep.pojo.ExamPojo;
import com.d2derp.oep.service.exam.ExamService;

@RestController
@RequestMapping("/exam")
public class ExamController {

	@Autowired
	private ExamService examService;

	public ExamService getExamService() {
		return examService;
	}

	public void setExamService(ExamService examService) {
		this.examService = examService;
	}

	@RequestMapping("/save")
	public void saveExam(@RequestBody ExamPojo examPojo) {
		examService.saveExam(examPojo);

	}

	@RequestMapping("/list")
	public ResponseEntity<List<ExamPojo>> listExam() {
		return ResponseEntity.ok(examService.listExam());

	}

	@RequestMapping("/get/{id}")
	public ResponseEntity<ExamPojo> getExam(@PathVariable(value = "id") int id) {
		return ResponseEntity.ok(examService.findExam(id));

	}

//	@RequestMapping("/edit")
//	public ResponseEntity<ExamPojo> editExam(@RequestBody ExamPojo examPojo) {
//		if (examService.findExam(examPojo.getId()) != null) {
//			ResponseEntity.badRequest().build();
//		}
//		return ResponseEntity.ok(examService.editExam(examPojo));
//
//	}

	@RequestMapping("/delete/{id}")
	public ResponseEntity deleteExam(@PathVariable(value = "id") int id) {
		if (examService.findExam(id) != null) {
			ResponseEntity.badRequest().build();
		}
		examService.deleteExam(id);
		return ResponseEntity.ok().build();

	}

}
