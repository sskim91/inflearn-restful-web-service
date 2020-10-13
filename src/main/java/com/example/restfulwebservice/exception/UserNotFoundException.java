package com.example.restfulwebservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//HTTP Status code
//2xx -> OK 성공
//4XX -> Client 존재하지 않는 리소스를 요청햇다던가, 권한이 없다던가 Client의 잘못
//5xx -> 서버쪽의 오류
@ResponseStatus(HttpStatus.NOT_FOUND)   //오류가 발생하면 이 Http의 코드가 전송된다.
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
