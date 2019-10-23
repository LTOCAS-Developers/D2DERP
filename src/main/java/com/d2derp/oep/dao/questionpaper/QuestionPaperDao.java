package com.d2derp.oep.dao.questionpaper;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.d2derp.oep.entity.QuestionPaper;
import com.d2derp.oep.entity.Questions;

public interface QuestionPaperDao extends JpaRepository<QuestionPaper, Integer> {

}
