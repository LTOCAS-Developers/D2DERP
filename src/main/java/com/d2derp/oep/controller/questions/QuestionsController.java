package com.d2derp.oep.controller.questions;

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

import com.d2derp.oep.entity.Questions;
import com.d2derp.oep.pojo.CourseTopicIdsPojo;
import com.d2derp.oep.pojo.QuestionsPojo;
import com.d2derp.oep.service.questions.QuestionsService;

@RestController
@RequestMapping("/questions")
public class QuestionsController {


	@Autowired
	private QuestionsService questionsService;

	public QuestionsService getQuestionsService() {
		return questionsService;
	}

	public void setQuestionsService(QuestionsService questionsService) {
		this.questionsService = questionsService;
	}

	@PostMapping(value = "/createQuestion")
	public void createQuestion(@RequestBody QuestionsPojo questionsPojo) {
		questionsService.saveQuestions(questionsPojo);
	}

	@GetMapping(value = "/getQuestions")
	public ResponseEntity<List<QuestionsPojo>> getQuestion() {
		return ResponseEntity.ok(questionsService.getQuestions());
	}

	@GetMapping(value = "/getQuestionsById/{Id}")
	public ResponseEntity<QuestionsPojo> getQuestionById(@PathVariable(name = "Id") int id) {
		return ResponseEntity.ok(questionsService.getQuestionsById(id));
	}

	@DeleteMapping(value = "/deleteQuestion/{Id}")
	public ResponseEntity deleteQuestion(@PathVariable(name = "Id") int id) {
		if (questionsService.getQuestionsById(id) != null) {

			ResponseEntity.badRequest().build();
		}

		questionsService.deleteQuestions(id);

		return ResponseEntity.ok().build();

	}

	@PutMapping(value = "/editQuestions")
	public ResponseEntity<QuestionsPojo> editQuestions(@RequestBody QuestionsPojo questionsPojo) {
		if (questionsService.getQuestionsById(questionsPojo.getQuestionNumber()) != null) {
			ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(questionsService.editQuestion(questionsPojo));

	}

	@PostMapping(value = "/getQuestionsByAsso")
	public ResponseEntity<List<Questions>> getQuestionByCourseAndTopic(@RequestBody CourseTopicIdsPojo courseTopicIds) {
		System.out.println(courseTopicIds.getCourseId());
		return ResponseEntity.ok(questionsService.getQuestionByCourseAndTopic(courseTopicIds));
	}
}
