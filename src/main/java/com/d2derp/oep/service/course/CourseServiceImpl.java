package com.d2derp.oep.service.course;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.d2derp.oep.dao.client.ClientDao;
import com.d2derp.oep.dao.course.CourseDao;
import com.d2derp.oep.dao.user.UserDao;
import com.d2derp.oep.dao.user.UserTypeDao;
import com.d2derp.oep.entity.Client;
import com.d2derp.oep.entity.Course;
import com.d2derp.oep.entity.User;
import com.d2derp.oep.entity.UserType;
import com.d2derp.oep.pojo.ClientPojo;
import com.d2derp.oep.pojo.CoursePojo;
import com.d2derp.oep.pojo.UserPojo;
import com.d2derp.oep.pojo.UserTypePojo;

@Transactional
@Service("courseService")
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseDao courseDao;

	public CourseDao getCourseDao() {
		return courseDao;
	}

	public void setCourseDao(CourseDao courseDao) {
		this.courseDao = courseDao;
	}

	public void save(CoursePojo coursePojo) {
		Course course = new Course();
		course.setName(coursePojo.getName());
		courseDao.save(course);
	}

	@Override
	public List<CoursePojo> listCourse() {
		List<CoursePojo> coursePojoList = new ArrayList();
		List<Course> courseList = courseDao.findAll();
		for (int i = 0; i < courseList.size(); i++) {

			Course course = courseList.get(i);

			CoursePojo coursePojo = new CoursePojo();
			coursePojo.setName(course.getName());
			coursePojo.setId(course.getId());

			coursePojoList.add(coursePojo);

		}

		return coursePojoList;
	}

	@Override
	public void deleteCourse(int id) {

		courseDao.deleteById(id);

	}

	public CoursePojo editCourse(CoursePojo coursePojo) {

		Optional<Course> course = courseDao.findById(coursePojo.getId());
		System.out.println(coursePojo.getId());
		course.get().setName(coursePojo.getName());
		course.get().setId(coursePojo.getId());

		return coursePojo;
	}

	public CoursePojo findCourse(int id) {

		Optional<Course> course = courseDao.findById(id);
		CoursePojo coursePojo = new CoursePojo();
		coursePojo.setName(course.get().getName());
		coursePojo.setId(course.get().getId());

		return coursePojo;
	}



}
