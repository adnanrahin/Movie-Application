import {Component, Input, OnInit} from '@angular/core';
import {FormArray, FormBuilder, FormGroup} from '@angular/forms';
import {MovieFormService} from '../../services/movie-form.service';
import {Movie, Rating} from '../../model/movie';
import {Language} from '../../model/language';


@Component({
  selector: 'app-add-film',
  templateUrl: './add-film.component.html',
  styleUrls: ['./add-film.component.css']
})
export class AddFilmComponent implements OnInit {

  addFilmFormGroup: FormGroup;

  @Input() currentMovie: Movie;
  languages: Language[] = [];
  releaseYears: number[] = [];

  currentRating = Rating;
  enumKeys = [];
  features: Array<string> = ['Trailers', 'Commentaries', 'Deleted Scenes', 'Behind the Scenes'];
  selectedFeatures = [];


  constructor(private formBuilder: FormBuilder, private movieFormService: MovieFormService) {
    this.enumKeys = Object.keys(this.currentRating);
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
        specialFeatures: this.addSpecialFeaturesControls(),
        lastUpdate: [''],
        rating: ['']
      })
    });
    this.movieFormService.getCreditCardYears().subscribe(data => {
      this.releaseYears = data;
    });
    this.movieFormService.getAllLanguage().subscribe(data => {
      this.languages = data;
    });
    /*this.movieFormService.getAllSpecialFeatures().subscribe(data => {
      this.specialFeatures = data;
    });*/
  }

  // tslint:disable-next-line:typedef
  addSpecialFeaturesControls() {
    const arr = this.features.map(element => {
      return this.formBuilder.control(false);
    });
    return this.formBuilder.array(arr);
  }

  // tslint:disable-next-line:typedef
  onSubmit() {
    console.log('Handing the submit button');
    console.log(this.selectedFeatures);
    const currentDate = new Date();
    const saveMovie = new Movie(0,
      this.addFilmFormGroup.get('film.title').value,
      this.addFilmFormGroup.get('film.description').value, this.addFilmFormGroup.get('film.releaseYear').value,
      this.addFilmFormGroup.get('film.language').value,
      null,
      this.addFilmFormGroup.get('film.rentalDuration').value,
      this.addFilmFormGroup.get('film.rentalRate').value,
      this.addFilmFormGroup.get('film.length').value, this.addFilmFormGroup.get('film.replacementCost').value,
      this.selectedFeatures, currentDate,
      this.addFilmFormGroup.get('film.rating').value,
      []);


    this.movieFormService.addNewFilm(saveMovie).subscribe(response => {
      console.log(response);
    });
  }

  // tslint:disable-next-line:typedef
  get specialFeaturesArray() {
    return this.addFilmFormGroup.get('film.specialFeatures') as FormArray;
  }

  // tslint:disable-next-line:typedef
  getSelectedFeaturesValue() {
    this.selectedFeatures = [];
    this.specialFeaturesArray.controls.forEach((control, i) => {
      if (control.value) {
        this.selectedFeatures.push(this.features[i]);
      }
    });

    console.log(this.selectedFeatures);
  }

}
