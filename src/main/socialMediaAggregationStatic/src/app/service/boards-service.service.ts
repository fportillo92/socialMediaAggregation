import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { Board } from '../model/Board';
import { HttpClient } from '@angular/common/http';
import {Observable} from 'rxjs';


@Injectable({
  providedIn: 'root'
})

@Injectable()
export class BoardsService {
  readonly API_URL = environment.apiUrl;

  constructor(private http: HttpClient) { }

  getBoards(): Observable<Board[]> {
     return this.http.get<Board[]>(this.API_URL);
  }

}


