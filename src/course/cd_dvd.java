package course;

public class cd_dvd {

    int id;
    String title;
    String artist;
    String price;
    String songs;
    String genre;
    int year;
    double rating;
    String size;
    String type;

    public cd_dvd() {
        this.id = 0;
        this.title = "";
        this.artist = "";
        this.price = "";
        this.songs = "";
        this.genre = "";
        this.year = 0;
        this.rating = 0;
        this.size = "";
        this.type = "";
    }

    public cd_dvd(String title, String artist, String price, String songs, String genre, int year, double rating, String size, String type) {
        this.id = 0;
        this.title = title;
        this.artist = artist;
        this.price = price;
        this.songs = songs;
        this.genre = genre;
        this.year = year;
        this.rating = rating;
        this.size = size;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSongs() {
        return songs;
    }

    public void setSongs(String songs) {
        this.songs = songs;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "cd_dvd " + "id = " + id
                + ", title = " + title + ", artist = " + artist
                + ", price = " + price + ", songs = " + songs + ", genre = " + genre
                + ", year = " + year + ", rating = " + rating + ", size = " + size
                + ", type = " + type + "/n";
    }
}
