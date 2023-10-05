package org.java.app.controller;

import java.util.Arrays;
import java.util.List;

import org.java.app.pojo.Movie;
import org.java.app.pojo.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@Controller
public class MainController {

	@GetMapping("/")
	public String title(Model model) {
		
		final String name = "Mirko";
		
		model.addAttribute("name", name);
		
		return "index";
	}
	
	///MOVIES
	@GetMapping("/movies")
	public String getMoviesIndex(Model model) {
		
//		String strMovies = "";
//		for (Movie movie : getBestMovies()) {
//			
//			strMovies += movie.getTitle() + ", ";
//		}
//		strMovies = strMovies.substring(0, strMovies.length() - 2);
		
		List<Movie> movies = getBestMovies();
		model.addAttribute("movies", movies);
		
		return "movies";
	}
	
	///MOVIE ID
	@GetMapping("/movies/{id}")
	public String getMovieDetails(@PathVariable int id, Model model) {
		
		Movie movie = getBestMovies().stream()
						.filter(m -> m.getId() == id)
						.findFirst().get();
//		String movieTitle = movie.getTitle();
		
		
		model.addAttribute("movie", movie);
		
		return "movie-details";
	}
	
	///MOVIES
	private List<Movie> getBestMovies() {
		
		return Arrays.asList(new Movie[] {
				new Movie(1, "I Mercenari 1"),
				new Movie(2, "I Mercenari 2"),
				new Movie(3, "I Mercenari 3"),
				new Movie(4, "I Mercenari 4"),
				new Movie(5, "John Wick 1"),
				new Movie(6, "John Wick 2"),
				new Movie(7, "John Wick 3"),
				new Movie(8, "John Wick 4"),
				new Movie(9, "Watcher"),
				new Movie(10, "Mia")
		});
	}
	
	
	
	
	///SONGS
	@GetMapping("/songs")
	public String getSongsIndex(Model model) {
		
//		String strSongs = "";
//		for (Song song : getBestSongs()) {
//			
//			strSongs += song.getTitle() + ", ";
//		}
//		strSongs = strSongs.substring(0, strSongs.length() - 2);
		
		List<Song> songs = getBestSongs();
		model.addAttribute("songs", songs);
		
		return "songs";
	}
	
	///SONG ID
		@GetMapping("/songs/{id}")
		public String getSongDetails(@PathVariable int id, Model model) {
			
//			Song song = getBestSongs().get(id);
//			String songTitle = song.getTitle();
			
			Song song = getBestSongs().stream()
					.filter(s -> s.getId() == id)
					.findFirst().get();
			
			model.addAttribute("song", song);
			
			return "song-details";
		}
	
	///SONGS
	private List<Song> getBestSongs() {
		
		return Arrays.asList(new Song[] {
				new Song(1, "Respect"),
				new Song(2, "Fight the Power"),
				new Song(3, "A Change is Gonna Come"),
				new Song(4, "Like a Rolling Stone"),
				new Song(5, "Smells Like Teen Spirit"),
				new Song(6, "What’s Going On "),
				new Song(7, "Strawberry Fields Forever"),
				new Song(8, "Get Ur Freak On"),
				new Song(9, "Dreams"),
				new Song(10, "Hey Ya")
		});
	}
}
