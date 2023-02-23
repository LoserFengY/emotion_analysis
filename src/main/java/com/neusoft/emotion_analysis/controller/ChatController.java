package com.neusoft.emotion_analysis.controller;

import com.neusoft.emotion_analysis.entity.ChatVo;
import com.neusoft.emotion_analysis.service.ChatService;
import com.neusoft.emotion_analysis.util.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class ChatController {
    @Resource
    ChatService chatService;
    @RequestMapping("/findAllChat")
    public Result findAllChat()
    {
        List<ChatVo> r=chatService.findAllChat();
        if(r!=null &&r.size()>0)
        {
            return Result.success(r);
        }
        return Result.success("无记录");
    }
    @RequestMapping("/deleteChat")
    public Result deleteChat(int chatId)
    {
        int r=chatService.deleteChat(chatId);
        if(r>0)
        {
            return Result.success("删除成功");
        }
        return Result.success("删除失败");
    }

}
