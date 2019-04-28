package com.github.commonweb;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

public class RestResponse {

    Integer code;
    Object data;

    public RestResponse(Integer code, Object data) {
        this.code = code;
        this.data = data;
    }
    public Integer getCode() {
        return code;
    }
    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "RestResult{" +
                "code=" + code +
                ", data=" + data +
                '}';
    }



    public static RestResponse success(Object object) {
        if (object instanceof String
                || object instanceof Integer
                || object instanceof Float
                || object instanceof Double
                || object instanceof Long
        ) {
            Map<String, Object> data = new HashMap<String, Object>();
            data.put("result", object);
            return new RestResponse(0, data);
        } else {
            return new RestResponse(0, object);
        }
    }

    public static RestResponse fail(int code, String message) {
        HashMap<String, Object> data = new HashMap<String, Object>();
        data.put("message", message);
        return new RestResponse(code, data);
    }


    /**
     * 获取stack trace信息
     * @param throwable
     * @return
     */
    private static String getStackTrace(Throwable throwable) {
        StringWriter writer = null;
        PrintWriter ps = null;
        try {
            writer = new StringWriter();
            ps = new PrintWriter(writer);
            throwable.printStackTrace(ps);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("stackTrace", writer.toString());
            return writer.toString();
        } finally {
            if (ps != null) {
                ps.flush();
                ps.close();
            }
        }
    }



}