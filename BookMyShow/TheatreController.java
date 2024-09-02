package com.SystemDesign.BookMyShow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheatreController {
    Map<City,List<Theatre>> cityTheatreMap;
    List<Theatre> allTheatres;
    TheatreController() {
        cityTheatreMap=new HashMap<>();
        allTheatres=new ArrayList<>();
    }

    void addTheatre(Theatre theatre,City city){
        allTheatres.add(theatre);
        List<Theatre>t=cityTheatreMap.getOrDefault(city,new ArrayList<>());
        t.add(theatre);
        cityTheatreMap.put(city,t);
    }
    //get me the map of the theatere along with list of shows of a paritcular movie given as an input
    Map<Theatre,List<Show>>getTheatreAlongWithShowsForMovie(String moviename,City city){
        List<Theatre>alltheatreInCity=cityTheatreMap.get(city);
        HashMap<Theatre,List<Show>>theatreShowInfoForAMovie=new HashMap<>();
        for(Theatre t:alltheatreInCity){
            List<Show>givenMovieShow=new ArrayList<>();
            for(Show show:t.getShows()){
                if(show.getMovie().getName().equals(moviename)){
                    givenMovieShow.add(show);
                }
            }
            if(!givenMovieShow.isEmpty())theatreShowInfoForAMovie.put(t,givenMovieShow);
        }
        return theatreShowInfoForAMovie;
    }
}
