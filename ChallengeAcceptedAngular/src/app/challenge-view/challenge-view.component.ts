import { Challenge } from './../models/challenge';
import { ChallengeService } from './../challenge.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-challenge-view',
  templateUrl: './challenge-view.component.html',
  styleUrls: ['./challenge-view.component.css']
})
export class ChallengeViewComponent implements OnInit {

  displayChallenge = new Challenge();




  constructor(private challengeService: ChallengeService) { }

  ngOnInit() {
  }

}
