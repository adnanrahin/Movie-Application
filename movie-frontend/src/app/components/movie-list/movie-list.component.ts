import {Component, OnInit} from '@angular/core';
import {MovieService} from '../../services/movie.service';
import {Movie} from '../../model/movie';

@Component({
  selector: 'app-movie-list',
  templateUrl: './movie-list.component.html',
  styleUrls: ['./movie-list.component.css']
})
export class MovieListComponent implements OnInit {

  movies: Movie[] = [];

  constructor(private movieService: MovieService) {
  }

  ngOnInit(): void {
    this.movieService.getAllMovie().subscribe(data => {
      this.movies = data;
    });

  }

}
