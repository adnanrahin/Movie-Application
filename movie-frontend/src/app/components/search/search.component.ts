import {Component, OnInit} from '@angular/core';
import {MovieService} from '../../services/movie.service';
import {Movie} from '../../model/movie';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  searchResult: Movie[] = [];

  constructor(private movieService: MovieService) {
  }

  ngOnInit(): void {
  }

  // tslint:disable-next-line:typedef
  doSearch(value: string) {
    this.movieService.findByTitle(value).subscribe(data => {
      this.searchResult = data;
    });
  }
}
