package com.blackcode.department_service.utils;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ApiResponse<T> {
    private String status;
    private int statusCode;
    private String message;
    private T data;

    public ApiResponse(String status, int statusCode, String message, T data) {
        this.status = status;
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
    }

    public static <T> ApiResponse<T> error(String message, int statusCode){
        return new ApiResponse<>("error", statusCode, message, null);
    }

    public static <T> ApiResponse<T> success(String message, int statusCode, T data) {
        return new ApiResponse<>("success", statusCode, message, data);
    }
}
