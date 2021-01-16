import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Actor} from '../model/actor';
import {Observable} from 'rxjs';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class ActorService {

  private readonly apiUrl: string = 'http://localhost:8080/api/actor';

  constructor(private http: HttpClient) {
  }

  public getAllActor(): Observable<Actor[]> {
    return this.http.get<Actor[]>(this.apiUrl + '/getAllActor');
  }

  public saveActor(actor: Actor): Observable<any> {
    return this.http.post(this.apiUrl + '/save', actor);
  }

}
