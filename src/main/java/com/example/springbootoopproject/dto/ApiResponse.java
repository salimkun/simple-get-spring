package com.example.springbootoopproject.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {
    private int status;
    private String message;
    private T data;
    private String error;

    public ApiResponse() {}

    public ApiResponse(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public ApiResponse(int status, String message, T data, String error) {
        this.status = status;
        this.message = message;
        this.data = data;
        this.error = error;
    }

    // Static factory methods for success responses
    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(200, "Success", data);
    }

    public static <T> ApiResponse<T> success(String message, T data) {
        return new ApiResponse<>(200, message, data);
    }

    public static <T> ApiResponse<T> created(T data) {
        return new ApiResponse<>(201, "Created successfully", data);
    }

    public static <T> ApiResponse<T> created(String message, T data) {
        return new ApiResponse<>(201, message, data);
    }

    // Static factory methods for error responses
    public static <T> ApiResponse<T> error(int status, String error) {
        return new ApiResponse<>(status, null, null, error);
    }

    public static <T> ApiResponse<T> badRequest(String error) {
        return new ApiResponse<>(400, null, null, error);
    }

    public static <T> ApiResponse<T> notFound(String error) {
        return new ApiResponse<>(404, null, null, error);
    }

    public static <T> ApiResponse<T> internalServerError(String error) {
        return new ApiResponse<>(500, null, null, error);
    }

    // Getters and Setters
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

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
