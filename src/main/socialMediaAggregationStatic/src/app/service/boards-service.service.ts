import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { Board } from '../model/Board';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';

import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})

@Injectable()
export class BoardsService {
  readonly API_URL = environment.apiUrl;

  constructor(private http: HttpClient) { }

  getAllBoards(): Observable<Board[]> {
     return this.http.get<Board[]>(this.API_URL);
  }
  // apiUrl: 'http://localhost:8080/users/fitibirlo1/boards/',
  getBoards(): Promise<Board[]> {
    return new Promise((resolve, reject) => {
      let headers = new HttpHeaders();
      headers = headers.append('Authorization', 'Basic ' + btoa('app:abc123'));
      headers = headers.append('Content-Type', 'application/x-wwsw-form-urlencoded');
      this.http.get(this.API_URL + '/boards/', {headers: headers}).subscribe( data => resolve(data as Board[]));
    });

  }
}


