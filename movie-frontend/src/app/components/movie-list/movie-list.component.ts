import {Component, OnInit} from '@angular/core';
import {MovieService} from '../../services/movie.service';
import {Movie} from '../../model/movie';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-movie-list',
  templateUrl: './movie-list.component.html',
  styleUrls: ['./movie-list.component.css']
})
export class MovieListComponent implements OnInit {

  movies: Movie[] = [];
  searchMode: boolean;

  constructor(private movieService: MovieService, private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.handleListMovie();
  }

  // tslint:disable-next-line:typedef
  public handleListMovie() {

    this.searchMode = this.route.snapshot.paramMap.has('keyword');

    if (this.searchMode) {
      this.handleSearchMode();
    } else {
      this.movieService.getAllMovie().subscribe(data => {
        this.movies = data;
      });
    }
  }

  // tslint:disable-next-line:typedef
  private handleSearchMode() {
    const theKeyWord: string = this.route.snapshot.paramMap.get('keyword');
    this.movieService.findByTitleContaining(theKeyWord).subscribe(data => {
      this.movies = data;
    });
  }
}
