import {Component, Input, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {MovieFormService} from '../../services/movie-form.service';
import {Language} from '../../model/language';
import {Movie} from '../../model/movie';

@Component({
  selector: 'app-add-film',
  templateUrl: './add-film.component.html',
  styleUrls: ['./add-film.component.css']
})
export class AddFilmComponent implements OnInit {

  addFilmFormGroup: FormGroup;

  @Input() currentMovie: Movie;

  releaseYears: number[] = [];
  languages: Language[] = [];
  ratings: any[] = [];


  constructor(private formBuilder: FormBuilder, private movieFormService: MovieFormService) {
  }

  ngOnInit(): void {

    this.addFilmFormGroup = this.formBuilder.group({
      film: this.formBuilder.group({
        title: [''],
        description: [''],
        releaseYear: [''],
        rentalDuration: [''],
        language: [''],
        rentalRate: [''],
        length: [''],
        replacementCost: [''],
        specialFeatures: [''],
        rating: ['']
      })
    });
    this.movieFormService.getCreditCardYears().subscribe(data => {
      this.releaseYears = data;
    });
    this.movieFormService.getAllLanguage().subscribe(data => {
      this.languages = data;
    });
  }

  // tslint:disable-next-line:typedef
  onSubmit() {
    console.log('Handing the submit button');
    console.log(this.addFilmFormGroup.get('film.title').value);

    this.currentMovie.title = this.addFilmFormGroup.get('film.title').value;
    this.currentMovie.description = this.addFilmFormGroup.get('film.description').value;
    this.currentMovie.releaseYear = this.addFilmFormGroup.get('film.releaseYear').value;
    this.currentMovie.rentalDuration = this.addFilmFormGroup.get('film.rentalDuration').value;
    this.currentMovie.length = this.addFilmFormGroup.get('film.length').value;
    this.currentMovie.language = this.addFilmFormGroup.get('film.language').value;
    this.currentMovie.rentalRate = this.addFilmFormGroup.get('film.rentalRate').value;
    this.currentMovie.specialFeatures = this.addFilmFormGroup.get('film.specialFeatures').value;
    this.currentMovie.replacementCost = this.addFilmFormGroup.get('film.replacementCost').value;
    this.currentMovie.rating = this.addFilmFormGroup.get('film.rating').value;
    this.currentMovie.actors = [];

    this.movieFormService.addNewFilm(this.currentMovie).subscribe(response => {
      console.log(response);
    });
  }
}
