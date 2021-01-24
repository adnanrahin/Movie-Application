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

  public findByTitleContaining(value: string): Observable<Movie[]> {
    const searchUrl = `${this.apiUrl}/search/${value}`;
    console.log(searchUrl + 'api url testing');
    return this.http.get<Movie[]>(searchUrl);
  }

  public findFilmByCategoryId(value: string): Observable<Movie[]> {
    const categoryUrl = `${this.apiUrl}/category/${value}`;
    console.log(categoryUrl);
    return this.http.get<Movie[]>(categoryUrl);
  }

}
