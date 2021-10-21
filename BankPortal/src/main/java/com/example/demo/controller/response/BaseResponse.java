
package com.example.demo.controller.response;

public class BaseResponse<D> extends MessageResponse {

    public BaseResponse() {
    }

    public BaseResponse(D response) {
        this.response = response;
    }

    private D response;

    public D getResponse() {
        return response;
    }

    public void setResponse(D response) {
        this.response = response;
    }

}
