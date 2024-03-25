package com.practise.impl;

import com.practise.entities.Movie;
import com.practise.repositories.MovieRepo;
import com.practise.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private MovieRepo movieRepo;

    @Autowired
    HttpSession session;

    @Override
    public boolean checkCredentials(String userId, String password) {
        final String id = "stella@gmail.com";
        final String pass = "stellar";
       if(userId.matches(id) && password.matches(pass)) {
           session.setAttribute("admin", true);
           return true;
       }
       else {
           return false;
       }
    }

    @Override
    public boolean addMovie(Movie movie) {
        Movie newMovie = new Movie();
        newMovie.setMovieId(movie.getMovieId());
        newMovie.setMovieName(movie.getMovieName());
        newMovie.setMovieCollection(movie.getMovieCollection());
        Optional<Movie> byMovieId = movieRepo.findByMovieId(movie.getMovieId());
        if(byMovieId.isEmpty()) {
            movieRepo.save(newMovie);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public Movie fetchMovieById(String movieId) {
        return movieRepo.findByMovieId(movieId).orElse(null);
    }

    @Override
    public void updateMovie(Movie movie) {
        movieRepo.save(movie);
    }


    @Override
    public void deleteMovie(String id) {
        try {
            movieRepo.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
