package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;
    String addmovie(Movie movie){
        String res=movieRepository.addMovie(movie);
        return res;
    }
    String adddirector(Director director){
        String res=movieRepository.addDirector(director);
        return res;
    }
    Movie getmoviebyname(String name){
        Movie obg=movieRepository.getmovie(name);
        return obg;
    }
    Director getdirectorbyname(String name){
        Director obj=movieRepository.getdirecor(name);
        return obj;
    }
    String addmoviedirectorPair(String mvName, String dirName){
        String res=movieRepository.addpair(mvName,dirName);
        return res;
    }

    List getallmovies(){
     List st=   movieRepository.getAllMovies();
     return st;
    }

    String deleteDirectorByName(String dirName){
        String res=movieRepository.deleteDirectorByName(dirName);
        return res;
    }
    String deleteAllDirectors(){
        String res=movieRepository.deleteAllDirectors();
        return res;
    }

    List getMoviesByDirectorName(String dirName){
        List movieNames=movieRepository.getMoviesByDirectorName(dirName);
        return movieNames;
    }
}
