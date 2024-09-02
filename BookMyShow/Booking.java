package com.SystemDesign.BookMyShow;
import java.util.List;
public class Booking {
    Show show;

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public List<Seat> getSeatsBooked() {
        return seatsBooked;
    }

    public void setSeatsBooked(List<Seat> seatsBooked) {
        this.seatsBooked = seatsBooked;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    List<Seat>seatsBooked;

    Payment payment;

}
