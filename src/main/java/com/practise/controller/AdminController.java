package com.practise.controller;

import com.practise.entities.Movie;
import com.practise.repositories.MovieRepo;
import com.practise.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    HttpSession session;

    @Autowired
    private MovieRepo movieRepo;

    @GetMapping("/login")
    public String adminLoginPage() {
        return "login-page";
    }

    @PostMapping("/login")
    public String login(@RequestParam("userid") String userId, @RequestParam String password,
                        Model model) {
        if (adminService.checkCredentials(userId, password))
            return "dashboard";
        else
            return "error-login";
    }

    @GetMapping("/dashboard")
    public String dashboard() {

        if (session.getAttribute("admin") != null)
            return "dashboard";
        else
            return "redirect:/login";
    }

    @GetMapping("/add-movie")
    public String AddMovieForm() {
        if (session.getAttribute("admin") != null) {
            return "add-page";
        } else
            return "redirect:/login";
    }

    @PostMapping("/add-movie")
    public String AddMovie(Movie movie, Model model) {

        if (adminService.addMovie(movie))
            model.addAttribute("added", true);
        else
            model.addAttribute("notAdded", true);

        return "add-confirmation";
    }

    @GetMapping("/modify-movie")
    public String modifyPage(Model model) {
        if (session.getAttribute("admin") != null) {
            List<Movie> allMovies = movieRepo.findAll();
            model.addAttribute("movies", allMovies);
            return "modify-page";
        } else
            return "redirect:/login";
    }

    @GetMapping("/updateMovie")
    public String updateMoviePage(@RequestParam("id") String movieId,
                                  Model model) {
        if (session.getAttribute("admin") != null) {
            Movie movie = adminService.fetchMovieById(movieId);
            model.addAttribute("movie", movie);
            return "update-movie";
        } else
            return "redirect:/login";
    }

    @PostMapping("/update")
    public String updateMovie(Movie movie) {
        adminService.updateMovie(movie);
        return "redirect:/modify-movie";
    }

    @GetMapping("/deleteMovie")
    public String deleteMovie(@RequestParam("id") String movieId) {
        if (session.getAttribute("admin") != null) {
            adminService.deleteMovie(movieId);
            return "redirect:/modify-movie";
        } else
            return "redirect:/login";
    }

    @GetMapping("/logout")
    public String logoutAdmin(){
        session.invalidate();
        return "redirect:/login";
    }
}
