package com.graph.Util;

import java.io.Serializable;

public class ResponseResult<T> implements Serializable {

    public static final int STATE_ERROR=-1;

    public static final int STATE_OK=1;

    private static final long serialVersionUID = 2158690201147047546L;

    private int status;           //返回状态

    private String message;       //返回信息

    private T data;               //返回数据

    public ResponseResult() {
        super();
    }

    public ResponseResult(int status, String message, T data) {
        super();
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((data == null) ? 0 : data.hashCode());
        result = prime * result + ((message == null) ? 0 : message.hashCode());
        result = prime * result + status;
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ResponseResult other = (ResponseResult) obj;
        if (data == null) {
            if (other.data != null)
                return false;
        } else if (!data.equals(other.data))
            return false;
        if (message == null) {
            if (other.message != null)
                return false;
        } else if (!message.equals(other.message))
            return false;
        if (status != other.status)
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "ResponseResult [status=" + status + ", message=" + message + ", data=" + data + "]";
    }


}