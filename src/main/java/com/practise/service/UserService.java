package com.practise.service;

import com.practise.entities.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    Movie searchByMovieId(String MovieId);

    List<Movie> searchByMovieName(String keyword);

    List<Movie> searchByMovieCollection(int min, int max);
}
