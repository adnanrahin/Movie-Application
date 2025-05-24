import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Category} from '../model/category';
import { environment } from '../../environments/environment';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  private readonly baseUrl = `${environment.apiUrl}/category`;

  constructor(private http: HttpClient) { }

  public getAllCategory(): Observable<Category[]>{
    return this.http.get<Category[]>(this.baseUrl + '/getAllCategory');
  }

}
