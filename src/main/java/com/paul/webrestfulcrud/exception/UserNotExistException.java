package com.paul.webrestfulcrud.exception;

/**
 * @author Paul
 * @version 1.0
 * @date 2020/4/7 15:38
 */
public class UserNotExistException extends RuntimeException {
    public UserNotExistException(){
        super("用户不存在");
    }
}
