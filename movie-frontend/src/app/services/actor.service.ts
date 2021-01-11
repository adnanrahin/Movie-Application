import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Actor } from '../model/actor';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class ActorService {

  private readonly actorUrl: string;

  constructor(private http: HttpClient) {
    this.actorUrl = 'http://localhost:8080/actor';
   }

   public findAll(): Observable<Actor[]> {
    return this.http.get<Actor[]>(this.actorUrl);
  }

}
