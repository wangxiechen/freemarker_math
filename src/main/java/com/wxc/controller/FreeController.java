package com.wxc.controller;

import com.wxc.FreemarkerTemple.SortMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("demo")
public class FreeController {

    @RequestMapping("list")
    public String list(ModelMap modelMap){
        modelMap.addAttribute("sort_int",new SortMethod());
        modelMap.addAttribute("name","王燮晨");
        return "product";
    }
}
