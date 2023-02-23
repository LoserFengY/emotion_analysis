package com.neusoft.emotion_analysis.service.impl;

import com.neusoft.emotion_analysis.analysis.EmotionAnalysis;
import com.neusoft.emotion_analysis.entity.Chat;
import com.neusoft.emotion_analysis.entity.ChatVo;
import com.neusoft.emotion_analysis.entity.TextBody;
import com.neusoft.emotion_analysis.mapper.ChatMapper;
import com.neusoft.emotion_analysis.service.ChatService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;
@Service
public class ChatServiceImpl implements ChatService {
    @Resource
    ChatMapper mapper;
    @Resource
    EmotionAnalysis analysis;
    @Override
    public int deleteChat(int chatId) {
        return mapper.deleteChat(chatId);
    }

    @Override
    public List<ChatVo> findAllChat() {
        return mapper.findAllChat();
    }
    @Override
    public String analysisEmotion(TextBody textBody) throws IOException {
        return analysis.analysis(textBody);
    }

    @Override
    public int saveChat(Chat chat) {

        return mapper.saveChat(chat);
    }
}
