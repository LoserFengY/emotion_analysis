package com.neusoft.emotion_analysis.config;

import com.alibaba.fastjson.JSON;
import com.neusoft.emotion_analysis.analysis.EmotionAnalysis;
import com.neusoft.emotion_analysis.analysis.Scene;
import com.neusoft.emotion_analysis.entity.AnalysisResult;
import com.neusoft.emotion_analysis.entity.Chat;
import com.neusoft.emotion_analysis.entity.Item;
import com.neusoft.emotion_analysis.entity.TextBody;
import com.neusoft.emotion_analysis.service.ChatService;
import com.neusoft.emotion_analysis.util.SpringContextUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Component
@ServerEndpoint("/websocket/{userId}")
@Slf4j
public class WebSocketServer {
    //存储客户端的连接对象,每个客户端连接都会产生一个连接对象
    private static ConcurrentHashMap<String,WebSocketServer> map=new ConcurrentHashMap();
    //每个连接都会有自己的会话
    private Session session;
    private String name;
    @OnOpen
    public void open(@PathParam("userId") String name, Session session){
        map.put(name,this);
        log.info(name+"连接服务器成功");
        log.info("客户端连接个数:"+getConnetNum());
        this.session=session;
        this.name=name;
    }
    @OnClose
    public void close(){
        map.remove(name);
        log.info(name+"断开了服务器连接");
    }
    @OnError
    public void error(Throwable error){
        error.printStackTrace();
        log.info(name+"出现了异常");
    }
    private ChatService chatService;
    @OnMessage
    public void getMessage(String message) throws IOException {
        chatService= (ChatService) SpringContextUtil.getBean("chatServiceImpl");

        Chat chat =JSON.parseObject(message, Chat.class);
        Chat result = analysis_emotion(chat);
        chatService.saveChat(chat);

        if(map.containsKey(chat.getRecipientId()))
        {
            map.get(chat.getRecipientId()).send(JSON.toJSONString(result));
        }else
        {
            map.get(chat.getSenderId()).send("改用户未上线");
        }


    }
    public void send(String message) throws IOException {
        if(session.isOpen()){
            session.getBasicRemote().sendText(message);
        }
    }

    public int  getConnetNum(){
        return map.size();
    }

    public Chat analysis_emotion(Chat chat) throws IOException {
        EmotionAnalysis emotionAnalysis=(EmotionAnalysis) SpringContextUtil.getBean("emotionAnalysis");
        TextBody textBody = new TextBody(Scene.TALK.getKey(), chat.getMessage());
        String result=emotionAnalysis.analysis(textBody);
        System.out.println(JSON.parse(result));
        AnalysisResult analysisResult = JSON.parseObject(result, AnalysisResult.class);
        log.info(analysisResult.getLog_id());

        List<Item> i= analysisResult.getItems();
        chat.setPrimaryLabel(i.get(0).getLabel());//取出Item中的分析结果
        chat.setSencondaryLabel(i.get(0).getSubitems().get(0).getLabel());
        chat.setPrimaryProb(i.get(0).getProb());
        chat.setSecondaryProb(i.get(0).getSubitems().get(0).getProb());
        return chat;
    }

}
