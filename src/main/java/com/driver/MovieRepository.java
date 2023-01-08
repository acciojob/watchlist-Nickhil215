package com.driver;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@Repository
public class MovieRepository {

    HashMap<String,Movie> movies=new HashMap<>();
    HashMap<String,Director> directors=new HashMap<>();
    HashMap<String,List<String>> pair=new HashMap<>();

    String addMovie(Movie movie){
        String mv=movie.getName();
        movies.put(mv,movie);
        return "Successfully Added Movie";
    }
    String addDirector(Director director){
        directors.put(director.getName(),director);
        return "Successfully Added Director";
    }
    Movie getmovie(String name){
        return movies.get(name);

    }
    Director getdirecor(String name){
        return directors.get(name);
    }

    String addpair(String mvName,String dirName){
        if(movies.containsKey(mvName) && directors.containsKey(dirName)){
            if(pair.containsKey(dirName)){
                pair.get(dirName).add(mvName);
            }else {
                ArrayList<String> mv=new ArrayList<>();
                mv.add(mvName);
                pair.put(dirName,mv);
            }
        }
        return "SUCCESSFULLY PAIRED";
    }

    List getAllMovies(){
        ArrayList<String> mvs=new ArrayList<>();
        for(String s:movies.keySet()){
            mvs.add(s);
        }
        return mvs;
    }

    String deleteDirectorByName(String dirName){
        if(directors.containsKey(dirName)){
            if(pair.containsKey(dirName)){
                List<String> movies1=pair.get(dirName);
                for(String mv:movies1){
                    movies.remove(mv);
                }
                pair.remove(dirName);
            }
            directors.remove(dirName);
            return "SUCCESSFULLY DELETED ";
        }
        return null;
    }

    String deleteAllDirectors(){
        ArrayList<String> list=new ArrayList<>();
        for(String s:pair.keySet()){
            for(String m:pair.get(s)){
                list.add(m);
            }
        }
        for(String i:list){
            movies.remove(i);
        }
        return  "SUCCESSFULLY DELETED ALL DIRECTORS";
    }
    List getMoviesByDirectorName(String dirName){
        List<String> movieNames=new ArrayList<>();
        if(pair.containsKey(dirName)){

            movieNames=(pair.get(dirName));
        }
        return movieNames;
    }

    String getDirectorByMovieName(String mvName){

        for(String director:pair.keySet()){
            List<String> movies=pair.get(director);
            if(movies.contains(mvName)){
                return director;
            }
        }
        return "Not exist";
    }
}
