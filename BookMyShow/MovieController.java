package com.SystemDesign.BookMyShow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieController {
    Map<City, List<Movie>> cityMovieMap;
    List<Movie> allmovies;

    MovieController() {
        this.cityMovieMap = new HashMap<>();
        this.allmovies = new ArrayList<>();
    }

    void addMovie(Movie m, City city) {
        allmovies.add(m);
        List<Movie> movieList = cityMovieMap.getOrDefault(city, new ArrayList<Movie>());
        movieList.add(m);
        cityMovieMap.put(city, movieList);
    }

    Movie getMovieByName(String name) {
        for (Movie m : allmovies) {
            if (m.getName().equals(name)) return m;
        }
        return null;
    }

    List<Movie> getMovieByCity(City city) {
        return cityMovieMap.get(city);
    }
    boolean removeMovieFromCity(City city, String name) {
        List<Movie> movies = cityMovieMap.get(city);
        for (Movie m : movies) {
            if (m.getName().equals(name)) {
                movies.remove(m);
                cityMovieMap.put(city, movies);
                return true;
            }
        }
        return false;
        }
    }

