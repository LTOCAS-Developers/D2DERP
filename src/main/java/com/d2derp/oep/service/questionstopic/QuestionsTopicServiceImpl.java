package com.d2derp.oep.service.questionstopic;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.d2derp.oep.dao.course.CourseDao;
import com.d2derp.oep.dao.questionstopic.QuestionsTopicDao;
import com.d2derp.oep.entity.Course;
import com.d2derp.oep.entity.QuestionsTopic;
import com.d2derp.oep.pojo.CoursePojo;
import com.d2derp.oep.pojo.QuestionsTopicPojo;

@Transactional
@Service("questionsTopicService")

public class QuestionsTopicServiceImpl implements QuestionsTopicService {

	@Autowired
	private QuestionsTopicDao questionsTopicDao;

	@Autowired
	private CourseDao courseDao;
	
	public CourseDao getCourseDao() {
		return courseDao;
	}

	public void setCourseDao(CourseDao courseDao) {
		this.courseDao = courseDao;
	}

	public QuestionsTopicDao getQuestionsTopicDao() {
		return questionsTopicDao;
	}

	public void setQuestionsTopicDao(QuestionsTopicDao questionsTopicDao) {
		this.questionsTopicDao = questionsTopicDao;
	}

	public void save(QuestionsTopicPojo questionsTopicPojo) {
		QuestionsTopic questionsTopic = new QuestionsTopic();
		System.out.println(questionsTopicPojo.getTopic());
		Course course = null;
		CoursePojo coursePojo = new CoursePojo();
		if (questionsTopicPojo.getCoursePojo().getId() == 0) {
			
			course = courseDao.getOne(1);
			System.out.println(questionsTopicPojo.getTopic());

		} else {
			course = courseDao.getOne(questionsTopicPojo.getCoursePojo().getId());
		}

		questionsTopic.setTopic(questionsTopicPojo.getTopic());
		questionsTopic.setCourse(course);
		System.out.println(questionsTopic.getTopic());
		
		questionsTopicDao.save(questionsTopic);
	}

	@Override
	public List<QuestionsTopicPojo> listQuestionsTopic() {

		List<QuestionsTopicPojo> questionsTopicPojoList = new ArrayList();
		List<QuestionsTopic> questionsTopicList = questionsTopicDao.findAll();
		CoursePojo coursePojo = new CoursePojo();

		for (int i = 0; i < questionsTopicList.size(); i++) {

			QuestionsTopic questionsTopic = questionsTopicList.get(i);

			QuestionsTopicPojo questionsTopicPojo = new QuestionsTopicPojo();

			questionsTopicPojo.setTopic(questionsTopic.getTopic());
			questionsTopicPojo.setId(questionsTopic.getId());

			coursePojo.setName(questionsTopic.getCourse().getName());
			coursePojo.setId(questionsTopic.getCourse().getId());

			questionsTopicPojo.setCoursePojo(coursePojo);

			questionsTopicPojoList.add(questionsTopicPojo);

		}
		return questionsTopicPojoList;
	}

	public QuestionsTopicPojo findQuestionstopic(int id) {

		Optional<QuestionsTopic> questionsTopic = questionsTopicDao.findById(id);
		QuestionsTopicPojo questionsTopicPojo = new QuestionsTopicPojo();
		questionsTopicPojo.setTopic(questionsTopic.get().getTopic());
		questionsTopicPojo.setId(questionsTopic.get().getId());
		CoursePojo coursePojo = new CoursePojo();

		coursePojo.setName(questionsTopic.get().getCourse().getName());
		coursePojo.setId(questionsTopic.get().getId());
		questionsTopicPojo.setCoursePojo(coursePojo);

		return questionsTopicPojo;
	}

	@Override
	public void deleteQuestionsTopic(int id) {

		questionsTopicDao.deleteById(id);
	}

	public QuestionsTopicPojo editQuestionstopic(QuestionsTopicPojo questionsTopicPojo) {

		Optional<QuestionsTopic> questionsTopic = questionsTopicDao.findById(questionsTopicPojo.getId());

		questionsTopic.get().setTopic(questionsTopicPojo.getTopic());
		questionsTopic.get().setId(questionsTopicPojo.getId());

		Course course = questionsTopic.get().getCourse();
		course.setName(questionsTopicPojo.getCoursePojo().getName());
		course.setId(questionsTopicPojo.getCoursePojo().getId());   
		System.out.println(questionsTopicPojo);
		return questionsTopicPojo;
	}

	public List<QuestionsTopic> findQuestionsTopicByCourseId(int id) {
		
		
		List<QuestionsTopic> questionsTopic=questionsTopicDao.findByCourseId(id);
		return questionsTopic;
	}     

}
