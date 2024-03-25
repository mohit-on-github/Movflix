package com.practise.impl;

import com.practise.entities.Movie;
import com.practise.repositories.MovieRepo;
import com.practise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private MovieRepo movieRepo;
    @Override
    public Movie searchByMovieId(String movieId) {
        return movieRepo.findByMovieId(movieId).get();
    }

    @Override
    public List<Movie> searchByMovieName(String keyword) {
        return movieRepo.findMovieByMovieNameContaining(keyword);
    }

    @Override
    public List<Movie> searchByMovieCollection(int min, int max) {
        return movieRepo.findMovieByMovieCollectionBetween(min,max);
    }

}
