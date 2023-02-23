package com.neusoft.emotion_analysis.entity;

import lombok.Data;

@Data
public class QuestionBank {
    private int questionId;
    private String question;
    private String selectA;
    private String selectB;
    private String selectC;
    private String selectD;
}
