import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Tweet } from '../model/Tweet';
import {environment} from '../../environments/environment';


@Injectable({
  providedIn: 'root'
})
export class TweetsService {
  readonly API_URL = environment.apiUrlTweets;

  constructor(private http: HttpClient) {
  }

  getTweets(): Promise<Tweet[]> {
    return new Promise((resolve, reject) => {
      this.http.get(this.API_URL).subscribe(data => resolve(data as Tweet[]));
    });
  }
}
