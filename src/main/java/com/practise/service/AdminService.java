package com.practise.service;

import com.practise.entities.Movie;
import org.springframework.stereotype.Service;

@Service
public interface AdminService {
    boolean checkCredentials(String userId, String password);

    boolean addMovie(Movie movie);

    Movie fetchMovieById(String movieId);

    void updateMovie(Movie movie);

    void deleteMovie(String id);

}
