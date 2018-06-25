import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Board} from '../model/Board';
import {environment} from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class InterestsService {
  readonly API_URL = environment.apiUrl;

  constructor(private http: HttpClient) { }
// /users/{username}/boards/{board}/interests/{interest}/usertag
  addInterest(selectedOption: string, tag: string, board: string) {
      let headers = new HttpHeaders();
      headers = headers.append('Authorization', 'Basic ' + btoa('app:abc123'));
      headers = headers.append('Content-Type', 'application/x-wwsw-form-urlencoded');
      console.log(this.API_URL + '/boards/' + board + '/interests/' + selectedOption);
      console.log(this.http.put(this.API_URL + '/boards/' + board + '/interests/' + selectedOption, {headers: headers}));
    }


}
