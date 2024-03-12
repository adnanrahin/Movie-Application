import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Category} from '../model/category';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  private readonly apiUrl: string = 'movie-backend-service.movie-application.svc.cluster.local:8080/api/category';

  constructor(private http: HttpClient) { }

  public getAllCategory(): Observable<Category[]>{
    return this.http.get<Category[]>(this.apiUrl + '/getAllCategory');
  }

}
