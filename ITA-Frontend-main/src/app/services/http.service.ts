import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class HttpService {
  private apiUrl = "http://localhost:8080/api/v1";
  
  constructor(private httpClient: HttpClient) {}

  get(path: string) {
    return this.httpClient.get(this.apiUrl.concat(path), {responseType: 'json'});
  }
}
