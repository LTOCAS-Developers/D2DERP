package com.d2derp.oep.controller.feedback;

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

import com.d2derp.oep.pojo.FeedBackPojo;
import com.d2derp.oep.service.feedback.FeedBackService;

@RestController
@RequestMapping("/feedback")
public class FeedBackController {

	@Autowired
	private FeedBackService feedBackService;

	public FeedBackService getFeedBackService() {
		return feedBackService;
	}

	public void setFeedBackService(FeedBackService feedBackService) {
		this.feedBackService = feedBackService;
	}
	
	@PostMapping(value="/save")
	public void save(@RequestBody FeedBackPojo feedBackPojo) {
		feedBackService.save(feedBackPojo);
	}
	
	@GetMapping(value="/get")
	public ResponseEntity<List<FeedBackPojo>> listFeedBack(){
		return ResponseEntity.ok(feedBackService.listFeedBack());
		
	}
	
	@GetMapping(value="/get/{id}")
	public ResponseEntity<FeedBackPojo>  listById(@PathVariable (value="id")int id){
		return ResponseEntity.ok(feedBackService.listById(id));
		
	}
	
	@PutMapping(value="/edit")
	public  ResponseEntity<FeedBackPojo> edit(@RequestBody FeedBackPojo feedBackPojo){
		return ResponseEntity.ok(feedBackService.editFeedBack(feedBackPojo));
	}
	
	@DeleteMapping(value="/delete/{id}")
	public ResponseEntity delete(@PathVariable (value="id")int id){
		feedBackService.deleteFeedBack(id);
		return ResponseEntity.ok().build();
	}
}
