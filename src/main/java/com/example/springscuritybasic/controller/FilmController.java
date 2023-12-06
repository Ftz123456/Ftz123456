package com.example.springscuritybasic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author ftz
 * 创建时间:6/12/2023 上午10:27
 * 描述: TODO
 */
@Controller
public class FilmController {
    //影片详情
    @GetMapping("/detail/{type}/{path}")
    public String detail(@PathVariable ("type")String type,@PathVariable("path")String path){
        return "detail/"+type+"/"+path;
    }
 @GetMapping("/")
    public String index(){
        return "index";
    }
}
