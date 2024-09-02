package com.SystemDesign.BookMyShow;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BookMyShow {

    MovieController movieController;
    TheatreController theatreController;

    BookMyShow(){
        this.movieController=new MovieController();
        this.theatreController=new TheatreController();
    }
    public void initialize(){
        createMovie();
        createTheatre();
    }
    public void createMovie(){
        Movie bahubali= new Movie();
        bahubali.setMovieId(1);
        bahubali.setName("Bahubali");
        bahubali.setDuration(120);

        Movie avengers = new Movie();
        avengers.setMovieId(1);
        avengers.setName("AVENGERS");
        avengers.setDuration(128);

        movieController.addMovie(bahubali,City.Banglore);
        movieController.addMovie(bahubali,City.Bhopal);
        movieController.addMovie(bahubali,City.Pune);
        movieController.addMovie(avengers,City.Bhopal);
        movieController.addMovie(avengers,City.Pune);


    }
    public void createTheatre(){
        Theatre inox=new Theatre();
        inox.setId(1);
        inox.setCity(City.Pune);
        inox.setScreen(createScreen());
        List<Show>inoxshows=new ArrayList<>();
        Movie avenger=movieController.getMovieByName("AVENGERS");
        Movie bahubali=movieController.getMovieByName("Bahubali");
        Show morningshow1=createShow(1,inox.getScreen().get(0),avenger,7);
        Show eveningshow2=createShow(2,inox.getScreen().get(0),bahubali,15);
        inoxshows.add(morningshow1);
        inoxshows.add(eveningshow2);
        inox.setShows(inoxshows);

        Theatre pvr=new Theatre();
        pvr.setId(2);
        pvr.setCity(City.Bhopal);
        pvr.setScreen(createScreen());
        List<Show>pvrshows=new ArrayList<>();
        Show morningshow=createShow(3,pvr.getScreen().get(0),avenger,9);
        Show eveningshow=createShow(4,pvr.getScreen().get(0),bahubali,16);
        pvrshows.add(morningshow);
        pvrshows.add(eveningshow);

        theatreController.addTheatre(inox,City.Pune);
        theatreController.addTheatre(pvr,City.Bhopal);
    }
    public Show createShow(int showId,Screen screen,Movie movie,int showStartTime){
        Show show=new Show();
        show.setShowId(showId);
        show.setScreen(screen);
        show.setMovie(movie);
        show.setStartTime(showStartTime);
        return show;
    }
    public List<Screen> createScreen(){
        List<Screen>screens=new ArrayList<>();
        Screen screen1=new Screen();
        screen1.setSid(1);
        screen1.setSeats(createSeat(10,30,40));
        screens.add(screen1);
        return screens;
    }
    public List<Seat>createSeat(int seatgold,int seatsilver,int seatplatinum){
        List<Seat>seatlist=new ArrayList<>();
        for(int i=0;i<seatgold;i++){
            Seat seat=new Seat();
            seat.setSeatId(i);
            seat.setSeatCategory(SeatCategory.GOLD);
            seatlist.add(seat);
        }
        for(int i=seatgold;i<seatsilver;i++){
            Seat seat=new Seat();
            seat.setSeatId(i);
            seat.setSeatCategory(SeatCategory.SILVER);
            seatlist.add(seat);
        }
        for(int i=seatsilver;i<seatplatinum;i++){
            Seat seat=new Seat();
            seat.setSeatId(i);
            seat.setSeatCategory(SeatCategory.PLATINUM);
            seatlist.add(seat);
        }
        return seatlist;
    }
    private void createBooking(City city,String moviename){
        List<Movie>movies=movieController.getMovieByCity(city);
        Movie interestedMovie=null;
        for(Movie m:movies){
            if(m.getName().equals(moviename)){
                interestedMovie =m;
                break;
            }
        }
        Map<Theatre,List<Show>> showsTheatreWise =theatreController.getTheatreAlongWithShowsForMovie(interestedMovie.getName(),city);
        //4. select the particular show user is interested in
        Map.Entry<Theatre,List<Show>>entry=showsTheatreWise.entrySet().iterator().next();
        List<Show>runningShow =entry.getValue();
        Show interestedShow=runningShow.get(0);

        //select seat num
        int seatNumber =8;
        List<Integer>bookedseats=interestedShow.getBookedseatIds();
        if(!bookedseats.contains(seatNumber)){
            bookedseats.add(seatNumber);
            Booking booking=new Booking();
            List<Seat>myBookedSeats=new ArrayList<>();
            for(Seat seat:interestedShow.getScreen().getSeats()){
                if(seatNumber==seat.getSeatId()){
                    myBookedSeats.add(seat);
                }
            }
            booking.setSeatsBooked(myBookedSeats);
            booking.setShow(interestedShow);
        }
        else{
            System.out.println("seat already booked ,try again");
            return ;
        }
        System.out.println("BOOKING SUCCESSFULL");
    }
    public static void main(String[] args) {
        BookMyShow bookMyShow=new BookMyShow();
        bookMyShow.initialize();
        bookMyShow.createBooking(City.Pune,"Bahubali");
    }
}
