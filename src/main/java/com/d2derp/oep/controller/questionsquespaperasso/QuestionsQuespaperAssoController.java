package com.d2derp.oep.controller.questionsquespaperasso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.d2derp.oep.pojo.QuestionsPojo;
import com.d2derp.oep.pojo.QuestionsQuespaperAssoPojo;
import com.d2derp.oep.service.questions.QuestionsService;
import com.d2derp.oep.service.questionsquespaperasso.QuestionsQuespaperAssoService;

@RestController
@RequestMapping("questionsquespaperasso")
public class QuestionsQuespaperAssoController {
	
	@Autowired
	private QuestionsQuespaperAssoService questionsQuespaperAssoService ;

	
	
	public QuestionsQuespaperAssoService getQuestionsQuespaperAssoService() {
		return questionsQuespaperAssoService;
	}



	public void setQuestionsQuespaperAssoService(QuestionsQuespaperAssoService questionsQuespaperAssoService) {
		this.questionsQuespaperAssoService = questionsQuespaperAssoService;
	}



	@PostMapping(value = "/save")
	public void createQuestion(@RequestBody QuestionsQuespaperAssoPojo questionsQuespaperAssoPojo) {
	
		questionsQuespaperAssoService.saveQuestionsQuesPaperAsso(questionsQuespaperAssoPojo);
	}

}
