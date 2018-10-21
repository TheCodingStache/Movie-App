package com.timbuchalka.top10downloader.model;

/**
 * Created by usuario on 28/03/2018.
 */

public class Movie {

    int id;
    String title;
    String description;
    String director;
    int year;
    int runtime;
    String rating;
    int votes;
    float revenue;
    int[] genres;
    int[] actor;
    String image_url;

    public void Movie(int id, String title, String description, String director, int year, int runtime, String rating, int votes, float revenue, int[] genres, int[] actor, String image_url) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.director = director;
        this.year = year;
        this.runtime = runtime;
        this.rating = rating;
        this.votes = votes;
        this.revenue = revenue;
        this.genres = genres;
        this.actor = actor;
        // this.image_url = image_url;

    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    public float getRevenue() {
        return revenue;
    }

    public void setRevenue(float revenue) {
        this.revenue = revenue;
    }


    public int[] getGenres() {
        return genres;
    }

    public void setGenres(int[] genres) {
        this.genres = genres;
    }

//    public Actor getActor() {
//        return actor;
//    }

    public void setActor(int[] actor) {
        this.actor = actor;
    }
}
