import { TopSkillsPipe } from './../pipes/top-skills.pipe';
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

  title = 'Profile of {{ user.username }}';

  user = new User();

  getNumChallenges = function() {
    return this.completedChallenges.transform(this.user.challenges).length;
  };

  getTopSkills = function() {
    return this.topSkills.transform(this.user.skills);
  };

  constructor(private userChallengeService: UserChallengeService,
              private completedChallenges: CompletedStatusPipe,
              private topSkills: TopSkillsPipe) { }

  ngOnInit() {
  }

}
