package com.d2derp.oep.controller.feedbackasso;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.d2derp.oep.entity.Course;
import com.d2derp.oep.pojo.CoursePojo;
import com.d2derp.oep.pojo.FeedBackAssoPojo;
import com.d2derp.oep.service.feedbackAsso.FeedBackAssoSerive;

@RestController
@RequestMapping("/feedbackAsso")
public class FeedBackAssoController {

	@Autowired
	private FeedBackAssoSerive feedBackAssoService;
	
	
	@PostMapping("/create")
	public void  cretaeFeedBackAsso(@RequestBody FeedBackAssoPojo feedBackAssoPojo) {
		System.out.println(feedBackAssoPojo.getFeedBack_Id());
		feedBackAssoService.createFeedBackAsso(feedBackAssoPojo);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<List<CoursePojo>> getFeedBackAsso(@PathVariable (value="id") int id){
		return ResponseEntity.ok(feedBackAssoService.getFeedBackAsso(id));
	}
	
	@PostMapping("/delete")
	public void deleteFeedBackAsso(@RequestBody FeedBackAssoPojo feedBackAssoPojo ) {
		feedBackAssoService.deleteFeedBackAsso(feedBackAssoPojo);
	}
}
