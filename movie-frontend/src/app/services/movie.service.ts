import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Movie} from '../model/movie';
import { environment } from '../../environments/environment'; // Correct import path

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class MovieService {

  private readonly baseUrl = `${environment.apiUrl}/film`;

  constructor(private http: HttpClient) {
  }

  public getAllMovie(): Observable<Movie[]> {
    return this.http.get<Movie[]>(this.baseUrl + '/getAllFilm');
  }

  public findByTitleContaining(value: string): Observable<Movie[]> {
    const searchUrl = `${this.baseUrl}/search/${value}`;
    console.log(searchUrl + 'api url testing');
    return this.http.get<Movie[]>(searchUrl);
  }

  public findFilmByCategoryId(value: string): Observable<Movie[]> {
    const categoryUrl = `${this.baseUrl}/category/${value}`;
    console.log(categoryUrl);
    return this.http.get<Movie[]>(categoryUrl);
  }

  public getFilmById(value: number): Observable<Movie> {
    const movieUrl = `${this.baseUrl}/movieDetails/${value}`;
    return this.http.get<Movie>(movieUrl);
  }

}
