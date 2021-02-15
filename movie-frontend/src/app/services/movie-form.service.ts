import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable, of} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MovieFormService {

  private readonly apiUrl: string = 'http://localhost:8080/api/film';

  constructor(private http: HttpClient) {
  }

  public getCreditCardYears(): Observable<number[]> {
    const data: number[] = [];

    const startYear: number = new Date().getFullYear();
    const endYear: number = startYear - 50;

    for (let theYear = startYear; theYear >= endYear; theYear--) {
      data.push(theYear);
    }
    return of(data);
  }

}
