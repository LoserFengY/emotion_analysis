package com.neusoft.emotion_analysis.entity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Chat {
    private  int chatId;
    private String senderId;
    private String recipientId;
    private String message;
    private String primaryLabel;
    private String sencondaryLabel;
    private String primaryProb;
    private String secondaryProb;

}
