package com.akademiakodu.gifs.repository;

import com.akademiakodu.gifs.model.Gif;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Repository
public class GifRepository {

    private static List<Gif> ALL_GIFS = Arrays.asList(
            new Gif("android-explosion", "mols", true, 1),
            new Gif("ben-and-mike", "mika", true, 2),
            new Gif("book-dominos", "mem", true, 0),
            new Gif("compiler-bot", "bot", true, 1),
            new Gif("cowboy-coder", "code", true, 1),
            new Gif("infinite-andrew", "andrew", false, 2)
    );

    public List<Gif> getGifs() {
        return ALL_GIFS;

    }
    public String getGifNames(){
        String result = "";
        for (Gif gif: ALL_GIFS){
            result += gif.getName();
        }
        return result;
    }

    public List<Gif> getFavoritesGifs(){
       return ALL_GIFS.stream()
               .filter(Gif::getFavorite)
               .collect(Collectors.toList());
    }



    public Gif getGifByName(String name) {
        for (Gif allGif : ALL_GIFS) {
            if (allGif.getName().equals(name)){
                return allGif;
            }
        }
        return null;
    }
}
