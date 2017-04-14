package com.hzmoyan.javabean;

import lombok.Data;

@Data
public class AjaxRequestResult<T> {
     private T result;
    
    private boolean isSuccess;
    
    private String successMsg;
    
    private String errorMsg;
}
