import { UserChallengeService } from './../user-challenge.service';
import { CompletedStatusPipe } from './../pipes/completed-status.pipe';
import { Component, OnInit } from '@angular/core';
import { User } from '../models/user';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  title = 'User Profile';

  user = new User();

  getNumChallenges = function() {
    return this.completedChallenges.transform(this.user.challenges).length;
  };

  constructor(private userChallengeService: UserChallengeService,
              private completedChallenges: CompletedStatusPipe) { }

  ngOnInit() {
  }

}
