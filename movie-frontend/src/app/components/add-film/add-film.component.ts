import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {MovieFormService} from '../../services/movie-form.service';

@Component({
  selector: 'app-add-film',
  templateUrl: './add-film.component.html',
  styleUrls: ['./add-film.component.css']
})
export class AddFilmComponent implements OnInit {

  addFilmFormGroup: FormGroup;

  releaseYears: number[] = [];

  constructor(private formBuilder: FormBuilder, private movieFormService: MovieFormService) {
  }

  ngOnInit(): void {

    this.addFilmFormGroup = this.formBuilder.group({
      film: this.formBuilder.group({
        title: [''],
        description: [''],
        releaseYear: [''],
        rentalDuration: [''],
        rentalRate: [''],
        length: [''],
        replacementCost: [''],
        specialFeatures: [''],
        lastUpdate: ['']
      })
    });

  }

  // tslint:disable-next-line:typedef
  onSubmit() {
    console.log('Handing the submit button');
    console.log(this.addFilmFormGroup.get('film').value);
  }

  // tslint:disable-next-line:typedef
  handleYears() {
    this.movieFormService.getCreditCardYears().subscribe(data => {
      this.releaseYears = data;
    });
  }
}
