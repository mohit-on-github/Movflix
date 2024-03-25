package com.practise.controller;

import com.practise.entities.Movie;
import com.practise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String home(){
        return "index";
    }

    @GetMapping("/byId")
    public String searchByIdPage(){
        return "search-by-id";
    }

    @PostMapping("search-id")
    public String searchById(@RequestParam String movieId, Model model){
        Movie movie = userService.searchByMovieId(movieId);
        if(movie!=null)
            model.addAttribute("movie",movie);
        else
            model.addAttribute("movieNotFound",true);
        return "search-by-id";
    }
    @GetMapping("/byName")
    public String searchByNamePage(){
        return "search-by-name";
    }

    @PostMapping("search-name")
    public String searchByName(@RequestParam("movieName") String name,
                               Model model) {
        List<Movie> movies = userService.searchByMovieName(name);
        if(movies.isEmpty())
            model.addAttribute("movieNotFound",true);
        else
            model.addAttribute("movies",movies);
        return "search-by-name";
    }

    @GetMapping("/byCollection")
    public String searchByCollectionPage(){
        return "search-by-collection";
    }

    @PostMapping("/search-collection")
    public String searchByCollection(@RequestParam int min,
                                     @RequestParam int max,
                                     Model model) {
        List<Movie> movies = userService.searchByMovieCollection(min, max);
        if(movies.isEmpty())
            model.addAttribute("movieNotFound",true);
        else
            model.addAttribute("movies",movies);
        return "search-by-collection";
    }
}
