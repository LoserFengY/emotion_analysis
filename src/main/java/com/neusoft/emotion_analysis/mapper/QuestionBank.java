package com.neusoft.emotion_analysis.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QuestionBank {
    public int addQuestion(QuestionBank questionBank);
    public int deleteQuestion(int questionId);
    public List<QuestionBank> findAllQuestionBank();
    public int updateQuestionBank(QuestionBank questionBank);
}
