import {Component, OnInit} from '@angular/core';
import {Movie} from '../../model/movie';

@Component({
  selector: 'app-movie-details',
  templateUrl: './movie-details.component.html',
  styleUrls: ['./movie-details.component.css']
})
export class MovieDetailsComponent implements OnInit {

  movie: Movie[] = [];

  constructor() {
  }

  ngOnInit(): void {
  }

}
