package com.d2derp.oep.service.feedbackAsso;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.d2derp.oep.dao.course.CourseDao;
import com.d2derp.oep.dao.feedback.FeedBackDao;
import com.d2derp.oep.entity.Course;
import com.d2derp.oep.entity.FeedBack;
import com.d2derp.oep.pojo.CoursePojo;
import com.d2derp.oep.pojo.FeedBackAssoPojo;

@Transactional
@Service
public class FeedBackAssoImpl implements FeedBackAssoSerive{

	@Autowired
	private FeedBackDao feedBackDao;
	
	@Autowired
	private CourseDao courseDao;
	
	@Override
	public void createFeedBackAsso(FeedBackAssoPojo feedBackAssoPojo) {
		
		List<Integer> courseId=new ArrayList<>();
		
		FeedBack feedBack = feedBackDao.getOne(feedBackAssoPojo.getFeedBack_Id());
		
		 List<Course> courseList = new ArrayList<>();
		 
		 for(int i = 0;i<feedBackAssoPojo.getCourseId().size();i++) {
			 
			 Course course = new Course();
			 course.setId(feedBackAssoPojo.getCourseId().get(i));
			 
			 courseList.add(course);			 
		 }
		 
		 feedBack.getCourseList().addAll(courseList);
		
	}
   
	
	
	
	
	
	@Override
	public List<CoursePojo> getFeedBackAsso(int id) {
				
		FeedBack feedBack = feedBackDao.getOne(id);

		List<CoursePojo> coursePojoList = new ArrayList<>();
				
		for(int i=0;i<feedBack.getCourseList().size();i++) {
			
			CoursePojo coursePojo=new CoursePojo();
			
			coursePojo.setId(feedBack.getCourseList().get(i).getId());
			coursePojo.setName(feedBack.getCourseList().get(i).getName());
			coursePojoList.add(coursePojo);
			coursePojoList.get(i).getName();
		}	
		return coursePojoList;
	}






	@Override
	public void deleteFeedBackAsso(FeedBackAssoPojo feedBackAssoPojo) {
		
		FeedBack feedBack = feedBackDao.getOne(feedBackAssoPojo.getFeedBack_Id());
		
		List<Course> courseList = feedBack.getCourseList();
		
		for(int i=0;i<feedBackAssoPojo.getCourseId().size();i++) {

			for(int j =0;j<courseList.size();j++) { 
				if(feedBackAssoPojo.getCourseId().get(i) == courseList.get(j).getId() ) {
					courseList.remove(j);
				}
			}
			
		}
	}
}
