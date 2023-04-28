package com.gs.bbs.util;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
public class ResponseDTO {

    private int status;
    private String message;
    private Object data;

    public ResponseDTO(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public static ResponseDTO of(HttpStatus httpStatus, String message) {
        int status = Optional.ofNullable(httpStatus)
                .orElse(HttpStatus.OK)
                .value();
        return new ResponseDTO(status, message);
    }

    public static ResponseDTO of(HttpStatus httpStatus, String message, Object data) {
        int status = Optional.ofNullable(httpStatus)
                .orElse(HttpStatus.OK)
                .value();
        return new ResponseDTO(status, message, data);
    }
}