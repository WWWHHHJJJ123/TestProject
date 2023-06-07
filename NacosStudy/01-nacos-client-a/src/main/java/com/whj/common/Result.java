package com.whj.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @创建人 JieSi
 * @创建时间 2023/5/8
 * @描述
 */
@Data
public class Result<T> implements Serializable {


    /**
     * 返回的信息
     */
    private String msg;

    /**
     * 返回的代码
     */
    private Integer code;

    /**
     * 返回的数据
     */
    private T data;


    private final static Integer COMMIT_OK = 200;

    public Result() {
        super();
    }

    public Result(String msg, Integer code, T data) {
        this.msg = msg;
        this.code = code;
        this.data = data;
    }

    //建造者模式块
    //- - - - - - - - - - - - start - - - - - - - - - - - - -
    public static <T> Result<T> success(){
        return new Result<T>().returnSuccess("操作成功");
    }

    public static <T> Result<T> success(String msg){
        return new Result<T>().returnSuccess(msg);
    }

    public static <T> Result<T> success(T data){
        return new Result<T>().returnSuccess("操作成功", data);
    }

    public static <T> Result<T> success(String msg, T data){
        return new Result<T>().returnSuccess(msg, data);
    }

    public static <T> Result<T> error(){
        return new Result<T>().returnError("操作失败!");
    }

    public static <T> Result<T> error(String msg){
        return new Result<T>().returnError(msg);
    }

    public static <T> Result<T> error(int errorCode, String msg){
        return new Result<T>().returnError(errorCode, msg);
    }

    public static <T> Result<T> error(int errorCode, String msg, T data){
        return new Result<T>().returnError(errorCode, msg, data);
    }

    public static <T> Result<T> build(){
        return new Result<>();
    }

    public Result<T> buildMsg(String msg){
        this.msg = msg;
        return this;
    }

    public Result<T> buildData(T data){
        this.data = data;
        return this;
    }

    public Result<T> buildCode(Integer code){
        this.code = code;
        return this;
    }

    //- - - - - - - - - - - - end - - - - - - - - - - - - -

    public Result<T> returnError(String msg){
        this.code = 500;
        this.msg = msg;
        return this;
    }

    /**
     * 错误内容返回
     * @param errorCode     错误代码
     * @param msg  错误信息
     */
    public Result<T> returnError(int errorCode, String msg){
        this.code = errorCode;
        this.msg = msg;
        return this;
    }

    /**
     * 错误内容返回
     * @param errorCode     错误代码
     * @param msg  错误信息
     * @param data  返回对象
     */
    public Result<T> returnError(int errorCode, String msg, T data){
        this.code = errorCode;
        this.msg = msg;
        this.data = data;
        return this;
    }

    /**
     * 返回正确的信息 有返回值
     * @param msg
     */
    public Result<T> returnSuccess(String msg){
        this.code = COMMIT_OK;
        this.msg = msg;
        return this;
    }

    /**
     * 返回正确的信息 有返回值
     * @param msg  返回信息
     * @param data  返回对象
     */
    public Result<T> returnSuccess(String msg, T data){
        this.code = COMMIT_OK;
        this.msg = msg;
        this.data = data;
        return this;
    }
}
