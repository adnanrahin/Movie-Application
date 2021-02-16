import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {MovieFormService} from '../../services/movie-form.service';
import {Language} from '../../model/language';

@Component({
  selector: 'app-add-film',
  templateUrl: './add-film.component.html',
  styleUrls: ['./add-film.component.css']
})
export class AddFilmComponent implements OnInit {

  addFilmFormGroup: FormGroup;

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
        rating: [''],
        lastUpdate: ['']
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
    console.log(this.addFilmFormGroup.get('film').value);
  }
}
