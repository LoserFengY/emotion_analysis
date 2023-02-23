package com.neusoft.emotion_analysis.entity;

import lombok.Data;

import java.util.List;

@Data
public class AnalysisResult {
    private String log_id;
    private String text;
    private List<Item> items;
}
