package com.SystemDesign.BookMyShow;

import java.util.List;

public class Show {
    int showId;
    Movie movie;
    Screen screen;
    int startTime;

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public int getShowId() {
        return showId;
    }

    public void setShowId(int showId) {
        this.showId = showId;
    }




    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public List<Integer> getBookedseatIds() {
        return bookedseatIds;
    }

    public void setBookedseatIds(List<Integer> bookedseatIds) {
        this.bookedseatIds = bookedseatIds;
    }

    List<Integer> bookedseatIds;
}
