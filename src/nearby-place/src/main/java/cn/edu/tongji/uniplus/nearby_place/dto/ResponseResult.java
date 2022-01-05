package cn.edu.tongji.uniplus.nearby_place.dto;

import lombok.Getter;

/*
    这个类是用来给前端呈现统一格式的数据的
 */
public class ResponseResult<T> {
    @Getter
    private Integer code;

    @Getter
    private String message;

    @Getter
    private T data;

    /*
        这是通知类的各种构造函数重载，适用于不同的需求
        需要什么就返回什么
        一般来说 void就不返回数据，其他格式的数据自便
     */
    public ResponseResult() {
    }

    public ResponseResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
