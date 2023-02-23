package com.neusoft.emotion_analysis.analysis;

import com.alibaba.fastjson.JSON;
import com.neusoft.emotion_analysis.entity.TextBody;
import okhttp3.*;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class EmotionAnalysis {
    private static   final String API_KEY = "GiwBfgDNx3dn49PpFppoknnm";
    private  static   final String SECRET_KEY = "9Cpqah1uRpUTf4AfKurITTCc2Qu9Yh2D";
    private static final OkHttpClient HTTP_CLIENT = new OkHttpClient().newBuilder().build();

    private static String getAccessToken() throws IOException {
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "grant_type=client_credentials&client_id=" + API_KEY
                + "&client_secret=" + SECRET_KEY);
        Request request = new Request.Builder()
                .url("https://aip.baidubce.com/oauth/2.0/token")
                .method("POST", body)
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .build();
        Response response = HTTP_CLIENT.newCall(request).execute();
        return new JSONObject(response.body().string()).getString("access_token");
    }
    public String analysis(TextBody text)throws IOException
    {
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(text));
        Request request = new Request.Builder()
                .url("https://aip.baidubce.com/rpc/2.0/nlp/v1/emotion?charset=UTF-8&access_token=" + getAccessToken())
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .build();
        Response response = HTTP_CLIENT.newCall(request).execute();
        return response.body().string();
    }
}
