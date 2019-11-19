package com.d2derp.oep.controller.feedbackQuestions;

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

import com.d2derp.oep.entity.FeedBackQuestions;
import com.d2derp.oep.pojo.FeedBackPojo;
import com.d2derp.oep.pojo.FeedBackQuestionsPojo;
import com.d2derp.oep.service.feedbackquestions.FeedBackQuestionService;

@RestController
@RequestMapping("/feedBackQuestion")
public class FeedBackQuestionController {
	
	@Autowired
	private FeedBackQuestionService feedBackQuestionService;

	public FeedBackQuestionService getFeedBackQuestionService() {
		return feedBackQuestionService;
	}

	public void setFeedBackQuestionService(FeedBackQuestionService feedBackQuestionService) {
		this.feedBackQuestionService = feedBackQuestionService;
	}
	
	
	@PostMapping(value="/create")
	public void  creatreFeedBackQuestion(@RequestBody FeedBackQuestionsPojo feedBackQuestionsPojo ) {
		feedBackQuestionService.createFeedBackQuestions(feedBackQuestionsPojo);
	}

	@GetMapping(value="/get")
	public List<FeedBackQuestionsPojo> getFeedBackQuestion(){
		return feedBackQuestionService.getFeedBackQuestions();	
	}
	
	@GetMapping(value="/get/{id}")
	public FeedBackQuestionsPojo getFeedBackQuestionId(@PathVariable (value="id")int id){
		return feedBackQuestionService.getFeedBackQuestionById(id);
	}
	
	@PutMapping(value="/put")
	public FeedBackQuestionsPojo putFeedBackQuestion(@RequestBody FeedBackQuestionsPojo feedBackQuestionsPojo) {
		return feedBackQuestionService.putFeedBackQuestion(feedBackQuestionsPojo);	
	}
	
	@DeleteMapping(value="/delete/{id}")
	public void deleteFeedBackQuestion(@PathVariable (value="id") int id) {
		feedBackQuestionService.deleteFeedBackQuestion(id);
	}
	
}
