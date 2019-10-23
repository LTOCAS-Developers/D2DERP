package com.d2derp.oep.dao.exam;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.d2derp.oep.entity.Exam;

@Repository
public interface ExamDao extends JpaRepository<Exam, Integer>{

}
