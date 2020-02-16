package com.akademiakodu.gifs.controller;

import com.akademiakodu.gifs.model.Gif;
import com.akademiakodu.gifs.repository.GifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller

public class GifsController {


    final GifRepository gifRepository;

    public GifsController(GifRepository gifRepository){
        this.gifRepository = gifRepository;
    }

    @GetMapping("/")
    public String hello(ModelMap modelMap) {
        // 1, wyciągnięcie gifów
        List<Gif> gifList = gifRepository.getGifs();

        //2. przekazanie do warstwy widoków
        modelMap.put("gifs", gifList);

        // 3. zwrócenie widoku
        return "home";
    }

    @GetMapping("/showgifinbrowser")
    @ResponseBody
    public String showGifNames(){
        return gifRepository.getGifNames();
    }


    @GetMapping("/favorites")
    public String favoritesGifs(ModelMap modelMap){

        //1.wyciągnięcie gifs
        List<Gif> favoritesGifs = gifRepository.getFavoritesGifs();
        //2. przekazanie do widoku

        modelMap.put("gifs", favoritesGifs);
        //3. zwrócenie widoku

        return "favorites";

    }
    @GetMapping("/gif/{name}")
    public String getGifByName(@PathVariable String name, ModelMap modelMap){
        //wyciągnięcie
        Gif g = gifRepository.getGifByName(name);
        //przekazanie
        modelMap.put("gif", g);
        //zwrócenie
        return "gif-details";


    }


}
