package com.neusoft.emotion_analysis.mapper;

import com.neusoft.emotion_analysis.entity.Chat;
import com.neusoft.emotion_analysis.entity.ChatVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ChatMapper {

    public int deleteChat(int chatId);
    public List<ChatVo> findAllChat();

    public int saveChat(Chat chat);

}
