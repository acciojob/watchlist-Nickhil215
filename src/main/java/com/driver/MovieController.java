package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {
    @Autowired
    MovieService movieService;
    @PostMapping("/addmovie")
    public ResponseEntity<String> addMovie(@RequestBody() Movie movie){
    String res=movieService.addmovie(movie);
    return new ResponseEntity<>(res, HttpStatus.OK);
}
    @PostMapping("/adddirector")
    public  ResponseEntity<String> addDirector(@RequestBody() Director director){
        String res=movieService.adddirector(director);
        return new ResponseEntity<>(res,HttpStatus.ACCEPTED);
    }

    @GetMapping("/getmoviebyname")
    public  ResponseEntity<Movie> getMovieByName(@RequestParam()String name){
        Movie movie=movieService.getmoviebyname(name);
        return new ResponseEntity<>(movie,HttpStatus.FOUND);
    }

    @GetMapping("/getdirectorbyname")
    public ResponseEntity<Director> getDirectorByName(@RequestParam() String name){
        Director obj=movieService.getdirectorbyname(name);
        return new ResponseEntity<>(obj,HttpStatus.ACCEPTED);
    }

    @PutMapping("/addMovieDirectorPair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam() String mvName,@RequestParam() String dirName){
        String res=movieService.addmoviedirectorPair(mvName,dirName);
        return new ResponseEntity<>(res,HttpStatus.ACCEPTED);
    }

    @GetMapping("/getallmovies")
    public ResponseEntity<List> findAllMovies(){
        List st=movieService.getallmovies();
        return new ResponseEntity<>(st,HttpStatus.CREATED);
    }
    @DeleteMapping("/deleteDirectorByName")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam() String dirName){
        String res=movieService.deleteDirectorByName(dirName);
        return new ResponseEntity<>(res,HttpStatus.OK);
    }

    @DeleteMapping("/deleteAllDirectors")
    public ResponseEntity<String> deleteAllDirectors(){
        String res=movieService.deleteAllDirectors();
        return new ResponseEntity<>(res,HttpStatus.OK);
    }

    @GetMapping("/getMoviesByDirectorName")
    public  ResponseEntity<List> getMoviesByDirectorName(@RequestParam() String dirName){
        List movieNames=movieService.getMoviesByDirectorName(dirName);
        return new ResponseEntity<>(movieNames,HttpStatus.OK);
    }
}
