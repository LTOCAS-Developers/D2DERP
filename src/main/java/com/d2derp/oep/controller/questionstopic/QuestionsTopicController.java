package com.d2derp.oep.controller.questionstopic;

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

import com.d2derp.oep.entity.QuestionsTopic;
import com.d2derp.oep.pojo.QuestionsTopicPojo;
import com.d2derp.oep.pojo.UserPojo;
import com.d2derp.oep.service.questionstopic.QuestionsTopicService;

@RestController
@RequestMapping("/questionsTopics")
public class QuestionsTopicController {

	@Autowired
	private QuestionsTopicService questionsTopicService;

	public QuestionsTopicService getQuestionsTopicService() {
		return questionsTopicService;
	}

	public void setQuestionsTopicService(QuestionsTopicService questionsTopicService) {
		this.questionsTopicService = questionsTopicService;
	}

	@PostMapping(value = "/save")
	public void saveQuestionsTopic(@RequestBody QuestionsTopicPojo questionsTopicPojo) {
		questionsTopicService.save(questionsTopicPojo);
	}

	@GetMapping(value = "/list")
	public ResponseEntity<List<QuestionsTopicPojo>> listQuestionTopic() {
		return ResponseEntity.ok(questionsTopicService.listQuestionsTopic());
	}

	@GetMapping(value = "/get/{id}")
	public ResponseEntity<QuestionsTopicPojo> getQuestionsTopic(@PathVariable(value = "id") int id) {
		return ResponseEntity.ok(questionsTopicService.findQuestionstopic(id));
	}

	@PutMapping(value = "/edit")
	public ResponseEntity<QuestionsTopicPojo> updateQuestionsTopic(@RequestBody QuestionsTopicPojo questionsTopicPojo) {

		if (questionsTopicService.findQuestionstopic(questionsTopicPojo.getId()) != null) {
			ResponseEntity.badRequest().build();
		}
		 return ResponseEntity.ok(questionsTopicService.editQuestionstopic(questionsTopicPojo));
	}

	@DeleteMapping(value = "delete/{id}")
	public ResponseEntity deleteQuestionsTopic(@PathVariable(value = "id") int id) {
		if (questionsTopicService.findQuestionstopic(id) != null) {
			ResponseEntity.badRequest().build();
		}

		questionsTopicService.deleteQuestionsTopic(id);

		return ResponseEntity.ok().build();
	}
}
