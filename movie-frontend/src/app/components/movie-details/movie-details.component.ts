import {Component, OnInit} from '@angular/core';
import {Movie} from '../../model/movie';
import {ActivatedRoute} from '@angular/router';
import {MovieService} from '../../services/movie.service';

@Component({
  selector: 'app-movie-details',
  templateUrl: './movie-details.component.html',
  styleUrls: ['./movie-details.component.css']
})
export class MovieDetailsComponent implements OnInit {

  movie: Movie;

  constructor(private movieService: MovieService, private router: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.router.paramMap.subscribe(() => {
      this.movieDetails();
    });
  }

  // tslint:disable-next-line:typedef
  private movieDetails() {

    const theMovieId: number = +this.router.snapshot.paramMap.get('id');

    this.movieService.getFilmById(theMovieId).subscribe(data => {
      this.movie = data;
    });

  }

}
