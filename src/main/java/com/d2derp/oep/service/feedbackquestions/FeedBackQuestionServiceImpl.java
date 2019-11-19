package com.d2derp.oep.service.feedbackquestions;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.d2derp.oep.dao.course.CourseDao;
import com.d2derp.oep.dao.feedbackquestions.FeedBackQuestionDao;
import com.d2derp.oep.entity.Course;
import com.d2derp.oep.entity.FeedBackQuestions;
import com.d2derp.oep.pojo.CoursePojo;
import com.d2derp.oep.pojo.FeedBackQuestionsPojo;

@Transactional
@Service
public class FeedBackQuestionServiceImpl implements FeedBackQuestionService {

	@Autowired
	private FeedBackQuestionDao feedBackQuestionDao;
	
	@Autowired
	private CourseDao courseDao;

	public FeedBackQuestionDao getFeedBackQuestionDao() {
		return feedBackQuestionDao;
	}

	public void setFeedBackQuestionDao(FeedBackQuestionDao feedBackQuestionDao) {
		this.feedBackQuestionDao = feedBackQuestionDao;
	}

	@Override
	public void createFeedBackQuestions(FeedBackQuestionsPojo feedBackQuestionsPojo) {
		
		FeedBackQuestions feedBackQuestion = new  FeedBackQuestions();
		Course course = courseDao.getOne(feedBackQuestionsPojo.getCoursePojo().getId()) ;
		
		feedBackQuestion.setQuestions(feedBackQuestionsPojo.getQuestions());
		feedBackQuestion.setCourse(course);
		
		feedBackQuestionDao.save(feedBackQuestion);
		
	}

	@Override
	public List<FeedBackQuestionsPojo> getFeedBackQuestions() {
		
		List<FeedBackQuestionsPojo> feedBackQuestionsPojoList = new ArrayList<>();
		List<FeedBackQuestions> feedBackQuestionsList = feedBackQuestionDao.findAll();
		CoursePojo coursePojo = new CoursePojo();
		
		for(int i=0;i<feedBackQuestionsList.size();i++) {
			
			FeedBackQuestions feedBackQuestions = feedBackQuestionsList.get(i);
			FeedBackQuestionsPojo feedBackQuestionsPojo = new FeedBackQuestionsPojo();
			
			
			feedBackQuestionsPojo.setId(feedBackQuestions.getId());
			feedBackQuestionsPojo.setQuestions(feedBackQuestions.getQuestions());
			
			coursePojo.setId(feedBackQuestions.getCourse().getId());
			
			feedBackQuestionsPojo.setCoursePojo(coursePojo);
			
			feedBackQuestionsPojoList.add(feedBackQuestionsPojo);
		}
		return feedBackQuestionsPojoList;
	}

	@Override
	public FeedBackQuestionsPojo getFeedBackQuestionById(int id) {
		
		Optional<FeedBackQuestions> feedBackQuestions = feedBackQuestionDao.findById(id);
		FeedBackQuestionsPojo feedBackQuestionsPojo = new FeedBackQuestionsPojo();
		CoursePojo coursePojo = new CoursePojo();
		
		feedBackQuestionsPojo.setId(feedBackQuestions.get().getId());
		feedBackQuestionsPojo.setQuestions(feedBackQuestions.get().getQuestions());
		
		coursePojo.setId(feedBackQuestions.get().getId());
		
		feedBackQuestionsPojo.setCoursePojo(coursePojo);
		
		return feedBackQuestionsPojo;
	}

	@Override
	public FeedBackQuestionsPojo putFeedBackQuestion(FeedBackQuestionsPojo feedBackQuestionsPojo) {
		
		Optional<FeedBackQuestions> feedBackQuestions = feedBackQuestionDao.findById(feedBackQuestionsPojo.getId());
		
		feedBackQuestions.get().setId(feedBackQuestionsPojo.getId());
		feedBackQuestions.get().setQuestions(feedBackQuestionsPojo.getQuestions());
		
		Course course = feedBackQuestions.get().getCourse();
		course.setId(feedBackQuestionsPojo.getCoursePojo().getId());
		course.setName(feedBackQuestionsPojo.getCoursePojo().getName());
		return feedBackQuestionsPojo;
	}

	@Override
	public void deleteFeedBackQuestion(int id) {
		feedBackQuestionDao.deleteById(id);
	}
	
	
	
}
