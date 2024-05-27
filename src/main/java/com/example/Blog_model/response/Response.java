package com.example.Blog_model.response;



public class Response {
    private int status;
    private String message;
    private Object data;

    static public Response successResponse(Object data) {
        return new Response(1, "success", data);
    }
    static public Response errorResponse(Object data) {
        return new Response(0, "error", data);
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }



    public Response(int status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
}
