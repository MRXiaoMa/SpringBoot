package com.mc.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    @RequestMapping("/hello")
    public String index(ModelMap map) throws Exception{
//        throw new Exception("发生错误");
        map.addAttribute("host","http://www.baidu.com");
        return "index";
    }

    @RequestMapping("/json")
    public String json() throws Exception{
        throw new MyException("发生错误");
    }
}
