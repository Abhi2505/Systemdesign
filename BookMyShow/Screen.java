package com.SystemDesign.BookMyShow;

import java.util.List;

public class Screen {
    int sid;

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    List<Seat> seats;

}
