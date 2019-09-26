package com.d2derp.oep.controller.course;

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

import com.d2derp.oep.pojo.CoursePojo;
import com.d2derp.oep.service.course.CourseService;

@RestController
@RequestMapping("course")
public class CourseController {
	
	@Autowired
	private CourseService courseService;

	public CourseService getCourseService() {
		return courseService;
	}
	
	public void setCourseService(CourseService courseService) {
		this.courseService= courseService;
	}
	
	
	@PostMapping(value = "/save")
	public void saveCourse( @RequestBody CoursePojo coursePojo) {	
		System.out.println(coursePojo.getName());
		courseService.save(coursePojo);
	}

	
	
	@GetMapping(value = "/getCourse/{id}")
	public ResponseEntity<CoursePojo> getCourse(@PathVariable(value = "id") int id) {
		return ResponseEntity.ok(courseService.findCourse(id)); 

	}

	@GetMapping(value = "/list") 
	public ResponseEntity<List<CoursePojo>> listCourse() {
		
		return ResponseEntity.ok(courseService.listCourse());
	}

	@PutMapping(value = "/edit")
	public ResponseEntity<CoursePojo> updateCourse(@RequestBody CoursePojo coursePojo) {

		if (courseService.findCourse(coursePojo.getId())!=null) {
            ResponseEntity.badRequest().build();
        }

	        return ResponseEntity.ok(courseService.editCourse(coursePojo));
	}

	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity  deleteCourse(@PathVariable(value ="id") int id) {
        if (courseService.findCourse(id)!=null) {
            ResponseEntity.badRequest().build();
        }

        courseService.deleteCourse(id);

        return ResponseEntity.ok().build();
 
	}
	
	
	
	
}
