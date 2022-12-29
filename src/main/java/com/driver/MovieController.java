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

    @GetMapping("/getmoviebyname/{mvName}")
    public  ResponseEntity<Movie> getMovieByName(@PathVariable("mvName")String mvName){
        Movie movie=movieService.getmoviebyname(mvName);
        return new ResponseEntity<>(movie,HttpStatus.FOUND);
    }

    @GetMapping("/getdirectorbyname/{dirName}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable("dirName") String dirName){
        Director obj=movieService.getdirectorbyname(dirName);
        return new ResponseEntity<>(obj,HttpStatus.ACCEPTED);
    }

    @PutMapping("/addMovieDirectorPair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("mvName") String mvName,@RequestParam("dirName") String dirName){
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
    public  ResponseEntity<List> getMoviesByDirectorName(@RequestParam("dirName") String dirName){
        List movieNames=movieService.getMoviesByDirectorName(dirName);
        return new ResponseEntity<>(movieNames,HttpStatus.OK);
    }

}
