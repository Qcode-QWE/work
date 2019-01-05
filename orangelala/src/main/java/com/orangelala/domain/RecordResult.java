package com.orangelala.domain;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**  
* <p>Title: RecordResult.java</p>  
* <p>Description:自定义响应结构 </p>   
* @author QEcode  
* @date 2019年1月5日  
* @version 1.0  
*/ 
public class RecordResult {

    // 定义jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();
    // 响应业务状态
    private Integer status;
    // 响应消息
    private String msg;
    // 响应中的数据
    private Object data;

    public static RecordResult build(Integer status, String msg, Object data) {
        return new RecordResult(status, msg, data);
    }

    public static RecordResult ok(Object data) {
        return new RecordResult(data);
    }

    public static RecordResult ok() {
        return new RecordResult(null);
    }

    public RecordResult() {

    }

    public static RecordResult build(Integer status, String msg) {
        return new RecordResult(status, msg, null);
    }

    public RecordResult(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public RecordResult(Object data) {
        this.status = 200;
        this.msg = "OK";
        this.data = data;
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
