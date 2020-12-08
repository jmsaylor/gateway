package com.johnmsaylor.gateway.payload;

public class Payload {
    private String action;
    private Object data;

    public Payload() {
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
