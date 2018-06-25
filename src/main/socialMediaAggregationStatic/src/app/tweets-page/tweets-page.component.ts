import {Component, Input, OnInit, Host} from '@angular/core';
import {TweetsService} from '../service/tweets-service.service';
import {Tweet} from '../model/Tweet';
import {Board} from '../model/Board';
import {BoardsPageComponent} from '../boards-page/boards-page.component';


@Component({
  selector: 'app-tweets-page',
  templateUrl: './tweets-page.component.html',
  styleUrls: ['./tweets-page.component.css']
})
export class TweetsPageComponent implements OnInit {

  @Input() board: string;
  tweets: Tweet[];

  constructor(private tweetsService: TweetsService) { }

  ngOnInit() {
    console.log(this.board);
    this.tweetsService.getTweets(this.board).then(data => {
      this.tweets = data;
    });

  }


}
