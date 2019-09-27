package com.d2derp.oep.service.questions;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.d2derp.oep.dao.course.CourseDao;
import com.d2derp.oep.dao.questions.QuestionsDao;
import com.d2derp.oep.dao.questionstopic.QuestionsTopicDao;
import com.d2derp.oep.entity.Course;
import com.d2derp.oep.entity.Questions;
import com.d2derp.oep.pojo.CoursePojo;
import com.d2derp.oep.pojo.QuestionsPojo;

@Transactional
@Service("questionsService")
public class QuestionsServiceImpl implements QuestionsService {

	@Autowired
	public QuestionsDao questionDao;

	@Autowired
	public CourseDao courseDao;

	public QuestionsDao getQuestionDao() {
		return questionDao;
	}

	public void setQuestionDao(QuestionsDao questionDao) {
		this.questionDao = questionDao;
	}

	public CourseDao getCourseDao() {
		return courseDao;
	}

	public void setCourseDao(CourseDao courseDao) {
		this.courseDao = courseDao;
	}

	@Override
	public void saveQuestions(QuestionsPojo questionsPojo) {

		Questions questions = new Questions();
		Course course = null;
		CoursePojo coursePojo = new CoursePojo();
		if (questionsPojo.getCourse().getId() == 0) {

			course = courseDao.getOne(1);

		} else {
			course = courseDao.getOne(questionsPojo.getCourse().getId());
		}

		questions.setQuestions(questionsPojo.getQuestions());
		questions.setOption1(questionsPojo.getOption1());
		questions.setOption2(questionsPojo.getOption2());
		questions.setOption3(questionsPojo.getOption3());
		questions.setOption4(questionsPojo.getOption4());
		questions.setAnswer(questionsPojo.getAnswer());
		questions.setCourse(course);

		questionDao.save(questions);

	}

	@Override
	public List<QuestionsPojo> getQuestions() {

		List<Questions> questionsList = questionDao.findAll();
		List<QuestionsPojo> questionsPojoList = new ArrayList<>();
		CoursePojo coursePojo = new CoursePojo();

		for (int i = 0; i < questionsList.size(); i++) {

			Questions questions = questionsList.get(i);
			QuestionsPojo questionPojo = new QuestionsPojo();

			coursePojo.setId(questions.getCourse().getId());
			coursePojo.setName(questions.getCourse().getName());

			questionPojo.setQuestionNumber(questions.getQuestionNumber());
			questionPojo.setQuestions(questions.getQuestions());
			questionPojo.setOption1(questions.getOption1());
			questionPojo.setOption2(questions.getOption2());
			questionPojo.setOption3(questions.getOption3());
			questionPojo.setOption4(questions.getOption4());
			questionPojo.setAnswer(questions.getAnswer());

			questionPojo.setCourse(coursePojo);

			questionsPojoList.add(questionPojo);

		}
		return questionsPojoList;
	}

	@Override
	public QuestionsPojo getQuestionsById(int id) {

		Optional<Questions> questions = questionDao.findById(id);

		CoursePojo coursePojo = new CoursePojo();

		coursePojo.setId(questions.get().getCourse().getId());
		coursePojo.setName(questions.get().getCourse().getName());

		QuestionsPojo questionPojo = new QuestionsPojo();

		questionPojo.setQuestionNumber(questions.get().getQuestionNumber());
		questionPojo.setQuestions(questions.get().getQuestions());
		questionPojo.setOption1(questions.get().getOption1());
		questionPojo.setOption2(questions.get().getOption2());
		questionPojo.setOption3(questions.get().getOption3());
		questionPojo.setOption4(questions.get().getOption4());
		questionPojo.setAnswer(questions.get().getAnswer());

		questionPojo.setCourse(coursePojo);

		return questionPojo;
	}

	@Override
	public void deleteQuestions(int id) {
		questionDao.deleteById(id);

	}

	@Override
	public QuestionsPojo editQuestion(QuestionsPojo questionsPojo) {

		Optional<Questions> question = questionDao.findById(questionsPojo.getQuestionNumber());

		question.get().setQuestions(questionsPojo.getQuestions());
		question.get().setOption1(questionsPojo.getOption1());
		question.get().setOption2(questionsPojo.getOption2());
		question.get().setOption3(questionsPojo.getOption3());
		question.get().setOption4(questionsPojo.getOption4());
		question.get().setAnswer(questionsPojo.getAnswer());

		Course course = question.get().getCourse();
		course.setId(questionsPojo.getCourse().getId());
		course.setName(questionsPojo.getCourse().getName());

		return questionsPojo;
	}

}
