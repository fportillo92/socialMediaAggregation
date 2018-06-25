import { Injectable } from '@angular/core';
import {environment} from '../../environments/environment';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  readonly API_URL = environment.apiUrl;

  constructor(private http: HttpClient) { }
}
