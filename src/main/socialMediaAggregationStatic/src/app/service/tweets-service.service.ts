import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Tweet } from '../model/Tweet';
import {environment} from '../../environments/environment';


@Injectable({
  providedIn: 'root'
})
export class TweetsService {
  readonly API_URL = environment.apiUrl;
// apiUrlTweets: 'http://localhost:8080/users/fitibirlo1/boards/deportes/interests'
  constructor(private http: HttpClient) {
  }

  getTweets(board: string): Promise<Tweet[]> {
    let headers = new HttpHeaders();
    headers = headers.append('Authorization', 'Basic ' + btoa('app:abc123'));
    headers = headers.append('Content-Type', 'application/x-wwsw-form-urlencoded');
    return new Promise((resolve, reject) => {
      this.http.get(this.API_URL + '/boards/' + board + '/interests',  {headers: headers}).subscribe(data => resolve(data as Tweet[]));
    });
  }
}
