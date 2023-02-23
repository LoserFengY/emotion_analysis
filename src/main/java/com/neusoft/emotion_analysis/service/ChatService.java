package com.neusoft.emotion_analysis.service;

import com.neusoft.emotion_analysis.entity.Chat;
import com.neusoft.emotion_analysis.entity.ChatVo;
import com.neusoft.emotion_analysis.entity.TextBody;

import java.io.IOException;
import java.util.List;

public interface ChatService {
    public int deleteChat(int chatId);
    public List<ChatVo> findAllChat();
    public String analysisEmotion(TextBody textBody) throws IOException;
    public int saveChat(Chat chat);
}
