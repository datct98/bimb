package com.example.demo.controller.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;


public class RestAPIResponse<T> extends ResponseEntity<Response<T>> {

    private RestAPIResponse(HttpStatus status) {
        super(status);
    }


    private RestAPIResponse(MultiValueMap<String, String> headers, HttpStatus status) {
        super(headers, status);
    }

    private RestAPIResponse(Response<T> body, MultiValueMap<String, String> headers, HttpStatus status) {
        super(body, headers, status);
    }

    public RestAPIResponse(T data) {
        super(new Response<T>(data), HttpStatus.OK);
    }

    public RestAPIResponse(T data, HttpStatus status) {
        super(new Response<T>(data), status);
    }

    public RestAPIResponse(String errorCode, String errorMessage) {
        super(new Response<T>(errorCode,errorMessage), HttpStatus.BAD_REQUEST);
    }

    public RestAPIResponse(Response<T> body, HttpStatus status) {
        super(body, status);
    }

    public static <D> RestAPIResponse<D> fromData(D data) {
        return new RestAPIResponse<D>(data);
    }

    public static RestAPIResponse<String> emptyResponse() {
        return new RestAPIResponse<String>("",HttpStatus.OK);
    }

    public static RestAPIResponse fromError(String error, String message){
        return new RestAPIResponse(error,message);
    }
}
