package com.cg.baseproject.base;

/**
 * @author sam
 * @version 1.0
 * @date 2018/3/14
 * https://www.jianshu.com/p/337c06f322c2
 * https://www.jianshu.com/p/c105a4177982
 * 可能错误情况
    一般情况这是我们的返回json格式：
    {
        "code":200,
        "msg":"成功",
        "data":{}
    }
    失败的时候返回的实体又是一个数组，这样子就会抱一个json解析异常拿不多失败的状态码和提示信息
    {
    "code":200,
    "msg":"成功",
    "data":[]
    }
    解决：
    方法1：我们可以让后台返回的json数据中的data永远是个数组。
    方法2：1、自定义Gson响应体变换器 2、自定义一个响应变换工厂 继承自 retrofit的 converter.Factory
           3、在我们的自定义的Rxjava订阅者 subscriber中的onError（）中加入我们刚才定义的ResultException。
 */
public class BaseResponse<T> {
    public int code;
    public String message;
    public T data;
    
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
