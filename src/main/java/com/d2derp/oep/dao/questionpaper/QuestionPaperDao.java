package com.d2derp.oep.dao.questionpaper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.d2derp.oep.entity.QuestionPaper;


@Repository
public interface QuestionPaperDao extends JpaRepository <QuestionPaper, Integer> {

}
