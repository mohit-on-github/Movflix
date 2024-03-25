package com.practise.repositories;

import com.practise.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MovieRepo extends JpaRepository<Movie,String> {
    Optional<Movie> findByMovieId(String movieId);
    List<Movie> findMovieByMovieNameContaining(String keyword);

    List<Movie> findMovieByMovieCollectionBetween(int min,int max);
}
