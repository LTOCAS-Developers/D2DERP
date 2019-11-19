package com.d2derp.oep.dao.exam;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.d2derp.oep.entity.Exam;
import com.d2derp.oep.entity.QuestionsTopic;

@Repository
public interface ExamDao extends JpaRepository<Exam, Integer>{

	List<Exam> findByBatch_Id(int id);

}
