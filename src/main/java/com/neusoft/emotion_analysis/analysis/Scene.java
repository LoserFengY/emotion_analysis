package com.neusoft.emotion_analysis.analysis;

public enum Scene {
    DEFAULT("default","默认项-不区分场景"),
    TALK("talk","闲聊对话-如度秘聊天等"),
    TASK("task","默认项-不区分场景"),
    CUSTOMER_SERVICE("customer_service","默认项-不区分场景");
    private String key;
    private String name;
    Scene(String key, String name)
    {
        this.key=key;
        this.name=name;
    }

    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }
}
