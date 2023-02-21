package com.neusoft.emotion_analysis.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {
    /**
     * 响应代码
     */
    private String code;

    /**
     * 响应消息
     */
    private String message;

    /**
     * 响应结果
     */
    private T result;

    public Result(BaseErrorInfoInterface errorInfo) {
        this.code = errorInfo.getResultCode();
        this.message = errorInfo.getResultMsg();
    }

    /**
     * 成功
     *
     * @return
     */
    public static Result success() {
        return success(null);
    }

    /**
     * 成功
     * 返回响应信息
     * @return
     */
    public static Result success(String message) {
        Result re = new Result();
        re.setCode(CommonEnum.SUCCESS.getResultCode());
        re.setMessage(message);
        re.setResult(null);
        return re;
    }

    /**
     * 成功
     * 返回响应体
     * @param data
     * @return
     */
    public static Result success(Object data) {
        Result re = new Result();
        re.setCode(CommonEnum.SUCCESS.getResultCode());
        re.setMessage(CommonEnum.SUCCESS.getResultMsg());
        re.setResult(data);
        return re;
    }

    /**
     * 失败
     */
    public static Result error(BaseErrorInfoInterface errorInfo) {
        Result re = new Result();
        re.setCode(errorInfo.getResultCode());
        re.setMessage(errorInfo.getResultMsg());
        re.setResult(null);
        return re;
    }

    /**
     * 失败
     */
    public static Result error(String code, String message) {
        Result re = new Result();
        re.setCode(code);
        re.setMessage(message);
        re.setResult(null);
        return re;
    }

    /**
     * 失败
     */
    public static Result error( String message) {
        Result re = new Result();
        re.setCode("-1");
        re.setMessage(message);
        re.setResult(null);
        return re;
    }
}
