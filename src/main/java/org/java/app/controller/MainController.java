package org.java.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.java.app.pojo.Movie;
import org.java.app.pojo.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {

	@GetMapping("/")
	public String title(Model model) {
		
		final String name = "Mirko";
		
		model.addAttribute("name", name);
		
		return "index";
	}
	
	@GetMapping("/movies")
	public String movies(Model model) {
		
		List<Movie> movies = getBestMovies();
		
		model.addAttribute("movies", movies);
		
		return "movies";
	}
	
	
	@GetMapping("/songs")
	public String songs(Model model) {
		
		List<Song> songs = getBestSongs();
		
		model.addAttribute("songs", songs);
		
		return "songs";
	}
	
	
	///MOVIES
	private List<Movie> getBestMovies() {
		
		List<Movie> movies = new ArrayList<>();
		
		movies.add(new Movie(1, "I Mercenari 1"));
		movies.add(new Movie(2, "I Mercenari 2"));
		movies.add(new Movie(3, "I Mercenari 3"));
		movies.add(new Movie(4, "I Mercenari 4"));
		movies.add(new Movie(5, "John Wick 1"));
		movies.add(new Movie(6, "John Wick 2"));
		movies.add(new Movie(7, "John Wick 3"));
		movies.add(new Movie(8, "John Wick 4"));
		movies.add(new Movie(9, "Watcher"));
		movies.add(new Movie(10, "Mia"));
		
		return movies;
	}
	
	///SONGS
	private List<Song> getBestSongs() {
		
		List<Song> songs = new ArrayList<>();
		
		songs.add(new Song(1, "Respect"));
		songs.add(new Song(2, "Fight the Power"));
		songs.add(new Song(3, "A Change is Gonna Come"));
		songs.add(new Song(4, "Like a Rolling Stone"));
		songs.add(new Song(5, "Smells Like Teen Spirit"));
		songs.add(new Song(6, "What’s Going On "));
		songs.add(new Song(7, "Strawberry Fields Forever"));
		songs.add(new Song(8, "Get Ur Freak On"));
		songs.add(new Song(9, "Dreams"));
		songs.add(new Song(10, "Hey Ya"));
		
		return songs;
	}
}
