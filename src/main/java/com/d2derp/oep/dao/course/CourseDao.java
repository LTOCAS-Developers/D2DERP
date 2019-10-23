package com.d2derp.oep.dao.course;

import org.springframework.data.jpa.repository.JpaRepository;

import com.d2derp.oep.entity.Course;

public interface CourseDao extends JpaRepository<Course,Integer> {

}
