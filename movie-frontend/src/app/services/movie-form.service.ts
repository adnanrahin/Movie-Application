import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable, of} from 'rxjs';
import {Movie} from '../model/movie';
import {Language} from '../model/language';

@Injectable({
  providedIn: 'root'
})
export class MovieFormService {

  private readonly apiUrl: string = 'movie-backend-service.movie-application.svc.cluster.local:8080/api';

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

  public getAllLanguage(): Observable<Language[]> {
    return this.http.get<Language[]>(this.apiUrl + '/language/getAllLanguage');
  }

  public addNewFilm(movie: Movie): Observable<Movie> {
    return this.http.post<Movie>(this.apiUrl + '/film/save', movie);
  }

  public getAllSpecialFeatures(): Observable<any> {
    const specialFeatures = ['Trailers', 'Commentaries', 'Deleted Scenes', 'Behind the Scenes'];
    return of(specialFeatures);
  }

}
