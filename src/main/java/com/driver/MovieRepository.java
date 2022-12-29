package com.driver;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
//class  pair(){
//   private Movie mv;
//    private Director dir;
//
//    public pair(Movie mv, Director dir) {
//        this.mv = mv;
//        this.dir = dir;
//    }
//
//    public Movie getMv() {
//        return mv;
//    }
//
//    public void setMv(Movie mv) {
//        this.mv = mv;
//    }
//
//    public Director getDir() {
//        return dir;
//    }
//
//    public void setDir(Director dir) {
//        this.dir = dir;
//    }
//}
@Repository
public class MovieRepository {
    List<Movie> movies=new ArrayList<>();
    List<Director> directors=new ArrayList<>();

 String addMovie(Movie movie){
    movies.add(movie);
    return "Successfully Added Movie";
}
String addDirector(Director director){
     directors.add(director);
     return "Successfully Added Director";
}
Movie getmovie(String name){
    Iterator<Movie> movie=movies.listIterator();
    while (movie.hasNext()){
        Movie req=movie.next();
        if(req.getName().equals(name)){
            return req;
        }
    }
    return null;
}
Director getdirecor(String name){
     Iterator<Director> dir=directors.listIterator();
     while(dir.hasNext()){
         Director obj=dir.next();
         if(obj.getName().equals(name)){
             return obj;
         }
     }
    return null;
}
    List<Movie> pairmovies;
    HashMap<String,List> pair=new HashMap<>();
String addpair(String mvName,String dirName){

     if(movies.contains(mvName) && directors.contains(dirName)){
        if(!pair.containsKey(dirName)){
            pairmovies=new ArrayList<>();
            Movie obj=movies.get(movies.indexOf(mvName));
            pairmovies.add(obj);
            pair.put(dirName,pairmovies);

        }else {
            Movie obj=movies.get(movies.indexOf(mvName));
            pair.put(dirName, Collections.singletonList(pair.get(dirName).add(obj)));
        }
         return "Paired Successfully";
     }

    return null;
}

    List getAllMovies(){
    List<String> st=new ArrayList<>();
        Iterator<Movie> list=movies.listIterator();
        while (list.hasNext()){
            Movie obj=list.next();
            String s=obj.getName();
           st.add(s);
        }
        return st;
    }
    String deleteDirectorByName(String dirName){
    pair.remove(dirName);
    return "SUCCESSFULLY DELETED ";
    }


    String deleteAllDirectors(){
    pair.clear();
    return  "SUCCESSFULLY DELETED ALL DIRECTORS";
    }

    List getMoviesByDirectorName(String dirName){
    List<String> movieNames=new ArrayList<>();
    if (pair.containsKey(dirName)){
        List dummy=pair.get(dirName);
        Iterator<Movie> list=dummy.listIterator();
        while (list.hasNext()){
            Movie mv=list.next();
            movieNames.add(mv.getName());
        }

    }
    return movieNames;
    }
}
