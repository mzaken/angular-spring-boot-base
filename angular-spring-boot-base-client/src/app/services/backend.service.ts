import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {environment} from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class BackendService {
  baseUrl = environment.API_BASE_URL;
  constructor(private http: HttpClient) { }

  apiGet<T>(url: string): Observable<T> {
    return this.http.get<T>(this.baseUrl + url);
  }

  apiPost<T>(url: string, body: any): Observable<T> {
    return this.http.post<T>(this.baseUrl + url, body);
  }
}
