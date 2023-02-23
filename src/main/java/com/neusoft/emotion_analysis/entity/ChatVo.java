package com.neusoft.emotion_analysis.entity;

import lombok.Data;

@Data
public class ChatVo {
    private  int chatId;
    private String senderName;
    private int recipientName;
    private String message;
    private String primaryLabel;
    private String sencondaryLabel;
    private String primaryProb;
    private String secondaryProb;
}
