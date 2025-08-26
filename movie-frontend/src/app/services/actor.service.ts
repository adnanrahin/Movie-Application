import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment'; // Correct import path

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class ActorService {
  private readonly baseUrl = `${environment.apiUrl}/actor`; // Using template literals

  constructor(private http: HttpClient) { }

  getAllActor(): Observable<any> {
    return this.http.get(`${this.baseUrl}/getAllActor`);
  }

  saveActor(actor: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/save`, actor, httpOptions);
  }
}
