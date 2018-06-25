import {Component, Input, OnInit} from '@angular/core';
import {InterestsService} from '../service/interests-service.service';

@Component({
  selector: 'app-interest-page',
  templateUrl: './interest-page.component.html',
  styleUrls: ['./interest-page.component.css']
})
export class InterestPageComponent implements OnInit {

  @Input() board: string;
  @Input() tag: string;
  @Input() selectedOption: string;

  constructor(private interestService: InterestsService) { }

  ngOnInit() {
  }


  add() {
    this.interestService.addInterest(this.selectedOption, this.tag, this.board);
  }
}
