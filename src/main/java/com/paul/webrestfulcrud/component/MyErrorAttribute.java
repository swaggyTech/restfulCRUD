package com.paul.webrestfulcrud.component;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * @author Paul
 * @version 1.0
 * @date 2020/4/7 16:29
 */
//给容器中加入自己的定义的ErrorAttribute
@Component
public class MyErrorAttribute extends DefaultErrorAttributes {

    //能取到exception
    public MyErrorAttribute(){
        super(true);
    }
    //返回值的map就是页面和json能获取的所有字段
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, includeStackTrace);
        errorAttributes.put("company","aka");
        Map<String,Object> ext = (Map<String,Object>)webRequest.getAttribute("ext", 0);
        errorAttributes.put("ext",ext);
        return errorAttributes;
    }
}
