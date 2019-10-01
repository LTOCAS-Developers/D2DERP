package com.d2derp.oep.controller.questionpaper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.d2derp.oep.pojo.QuestionPaperPojo;
import com.d2derp.oep.service.questionpaper.QuestionPaperService;

@RestController
@RequestMapping("/questionPaper")
public class QuestionPaperController {

	@Autowired
	private QuestionPaperService questionPaperService;

	public QuestionPaperService getQuestionpaperService() {
		return questionPaperService;
	}

	public void setQuestionPaperService(QuestionPaperService questionPaperService) {
		this.questionPaperService = questionPaperService;
	}
	
	@PostMapping(value="/save")
	public void saveQuestionPaper(@RequestBody QuestionPaperPojo questionPaperPojo){
		questionPaperService.saveQuestionPaper(questionPaperPojo); 
		
	}

	@GetMapping(value = "/list")
	public ResponseEntity<List<QuestionPaperPojo>> listQuestionPaper() {
		System.out.println("im worked");
		return ResponseEntity.ok(questionPaperService.listQuestionPaper());
	}

	@GetMapping(value = "/get/{id}")
	public ResponseEntity<QuestionPaperPojo> getQuestionPaper(@PathVariable(value = "id") int id) {
		return ResponseEntity.ok(questionPaperService.findQuestionPaper(id));

	}

	@PutMapping(value = "/edit")
	public ResponseEntity<QuestionPaperPojo> updateQuestionPaper(@RequestBody QuestionPaperPojo questionPaperPojo) {

		if (questionPaperService.findQuestionPaper(questionPaperPojo.getId()) != null) {
			ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(questionPaperService.editQuestionPaper(questionPaperPojo));
	}

	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity deleteQuestionPaper(@PathVariable(value = "id") int id) {
		if (questionPaperService.findQuestionPaper(id) != null) {
			ResponseEntity.badRequest().build();
		}

		questionPaperService.deleteQuestionPaper(id);

		return ResponseEntity.ok().build();

	}


}
