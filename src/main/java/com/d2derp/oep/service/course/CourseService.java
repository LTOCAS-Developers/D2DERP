package com.d2derp.oep.service.course;

import java.util.List;

import com.d2derp.oep.pojo.CoursePojo;

public interface CourseService {
	
	void save( CoursePojo coursePojo);
	
	List<CoursePojo> listCourse();

	CoursePojo findCourse(int id);

	void deleteCourse(int id);

	CoursePojo editCourse(CoursePojo coursePojo);


}
