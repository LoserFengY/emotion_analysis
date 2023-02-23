package com.neusoft.emotion_analysis.entity;

import lombok.Data;

import java.util.List;

@Data
public class Item {
    private String prob;
    private List<String> replies;
    private List<SubItem> subitems;
    private String label;
}
