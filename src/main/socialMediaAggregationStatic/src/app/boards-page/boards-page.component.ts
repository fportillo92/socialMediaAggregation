import { Component, OnInit } from '@angular/core';
import { Board } from '../model/Board';
import { BoardsService } from '../service/boards-service.service';
import {Observable} from 'rxjs';



@Component({
  selector: 'app-boards-page',
  templateUrl: './boards-page.component.html',
  styleUrls: ['./boards-page.component.css']
})
export class BoardsPageComponent implements OnInit {

  boards: Observable<Board[]>;

  constructor(private boardsService: BoardsService) { }

  ngOnInit() {
    this.boards = this.boardsService.getBoards();
  }

}
