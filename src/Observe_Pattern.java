import java.util.ArrayList;

public class Observe_Pattern {
    public static void main(String[] args) {
        MyYoutube youtube = new MyYoutube();
        Subscriber Nimal = new CricketSubscriber();
        Subscriber Yureni = new MovieSubscriber();
        youtube.register(Nimal);
        youtube.register(Yureni);

        Movie flash = new Movie("Flash",2012);
        Cricket AsianCup = new Cricket("Sri Lanka", "Pakistan", "ODI");

        youtube.liveNewMovie(flash);
        youtube.liveNewCricketVideo(AsianCup);
        youtube.liveVideoChanged();
    }
}



/*Subject or Publisher*/
interface Subject {

    public void register(Subscriber subscriber);

    public void unregister(Subscriber subscriber);

    public void notifyObservers();
}

class MyYoutube implements Subject {

    ArrayList<Subscriber> channelSubscribers;
    private Movie movie;
    private Cricket cricket;

    MyYoutube() {
        channelSubscribers = new ArrayList<>();
    }

    @Override
    public void register(Subscriber subscriber) {
        this.channelSubscribers.add(subscriber);
    }

    @Override
    public void unregister(Subscriber subscriber) {
        int i = channelSubscribers.indexOf(subscriber);
        if (i >= 0) {
            this.channelSubscribers.remove(i);
        }
    }

    @Override
    public void notifyObservers() {
        for (Subscriber subscriber: channelSubscribers) {
            subscriber.update(movie, cricket);
        }
    }

    public void liveVideoChanged(){
        this.notifyObservers();
    }

    public void liveNewMovie(Movie movie){
        this.movie = movie;
    }

    public void liveNewCricketVideo(Cricket cricket){
        this.cricket = cricket;
    }

    public ArrayList<Subscriber> getChannelSubscribers() {
        return channelSubscribers;
    }

}



/*Observer classes*/
interface Subscriber {
    public void update(Movie movie, Cricket cricket);
}

class CricketSubscriber implements Subscriber, LiveVideosDisplay {
    private Cricket cricket;

    @Override
    public void update(Movie movie, Cricket cricket) {
        this.cricket = cricket;
        live();
    }


    @Override
    public void live() {
        System.out.println("This is cricket live time. Now live --> Match: " + cricket.getMatch() + ", Type:" + cricket.getType());
    }
}

class MovieSubscriber implements Subscriber, LiveVideosDisplay {
    private Movie movie;
    @Override
    public void update(Movie movie, Cricket cricket) {
        this.movie = movie;
        live();
    }


    @Override
    public void live() {
        System.out.println("This is movie live time. Now live --> Movie: " + movie.getName() + ", Year:" + movie.getYear());
    }
}



/*Update details*/
interface LiveVideosDisplay {
    public void live();
}

class Movie {
    private String name;
    private int year;

    Movie(String name, int year) {
        this.name = name;
        this.year = year;
        System.out.println(name + "(" + this.year + ") now uploaded to the channel.");
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }
}

class Cricket {
    private String Match;
    private String type;

    Cricket(String teamA, String teamB, String type) {
        this.Match = teamA + " vs " + teamB;
        this.type = type;
        System.out.println(this.Match + " " + this.type + " match now uploaded to the channel.");
    }

    public String getMatch() {
        return Match;
    }

    public String getType() {
        return type;
    }
}

