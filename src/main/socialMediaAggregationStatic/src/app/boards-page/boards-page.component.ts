import {Component, OnInit} from '@angular/core';
import {Board} from '../model/Board';
import {BoardsService} from '../service/boards-service.service';
import {TweetsService} from '../service/tweets-service.service';


@Component({
  selector: 'app-boards-page',
  templateUrl: './boards-page.component.html',
  styleUrls: ['./boards-page.component.css']
})
export class BoardsPageComponent implements OnInit {

  boards: Board[];

  constructor(private boardsService: BoardsService, private tweetsService: TweetsService) {
  }

  ngOnInit() {
    this.boardsService.getBoards().then(data => {
      this.boards = data;
    });

  }

}
