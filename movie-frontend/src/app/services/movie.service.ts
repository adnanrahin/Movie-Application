import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Movie} from '../model/movie';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class MovieService {

  private readonly apiUrl: string = 'http://localhost:8080/api/film';

  constructor(private http: HttpClient) {
  }

  public getAllMovie(): Observable<Movie[]> {
    return this.http.get<Movie[]>(this.apiUrl + '/getAllFilm');
  }

  public findByTitle(value: string): Observable<Movie[]> {
    return this.http.get<Movie[]>(this.apiUrl + '/findByTitle/' + value);
  }

}
