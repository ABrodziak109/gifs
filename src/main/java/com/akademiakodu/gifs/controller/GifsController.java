package com.akademiakodu.gifs.controller;

import com.akademiakodu.gifs.model.Gif;
import com.akademiakodu.gifs.repository.GifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller

public class GifsController {


    final GifRepository gifRepository;

    public GifsController(GifRepository gifRepository){
        this.gifRepository = gifRepository;
    }

    @GetMapping("/")
    @ResponseBody
    public String hello() {
        return "działa";
    }

    @GetMapping("/showgifinbrowser")
    @ResponseBody
    public String showGifNames(){
        return gifRepository.getGifNames();
    }


}
