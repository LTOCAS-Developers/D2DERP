package com.d2derp.oep.controller.quesquespaperassocontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.d2derp.oep.pojo.QuestionsPojo;
import com.d2derp.oep.pojo.QuestionsQuespaperAssoPojo;
import com.d2derp.oep.service.quesquespaperservice.QuesQuesPaperService;

@RestController
@RequestMapping("/questionsasso")
public class QuesQuesPaperAssoController {
	
	@Autowired
	QuesQuesPaperService quesQuesPaperService;

	@PostMapping(value = "/createasso")
	public void createQuestion(@RequestBody QuestionsQuespaperAssoPojo questionsQuespaperAssoPojo) {
		quesQuesPaperService.saveQuestionsAssociation(questionsQuespaperAssoPojo);
	}
	
	@PostMapping(value = "/deleteasso")
	public void deleteQuestionAsso(@RequestBody QuestionsQuespaperAssoPojo questionsQuespaperAssoPojo) {
		quesQuesPaperService.deleteQuestionsAssociation(questionsQuespaperAssoPojo);
	}

	
}
