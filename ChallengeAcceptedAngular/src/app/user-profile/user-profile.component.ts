import { Challenge } from './../models/challenge';
import { TopSkillsPipe } from './../pipes/top-skills.pipe';
import { UserChallengeService } from './../user-challenge.service';
import { CompletedStatusPipe } from './../pipes/completed-status.pipe';
import { Component, OnInit } from '@angular/core';
import { User } from '../models/user';
import { ChallengesCreatedPipe } from '../pipes/challenges-created.pipe';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  title = 'Profile of {{ user.username }}';

  user = new User();

  getNumCompletedChallenges = function() {
    return this.completedChallenges.transform(this.user.challenges).length;
  };

  getLocation = function() {
    return this.user.location;
  };

  getTopSkills = function() {
    return this.topSkills.transform(this.user.skills);
  };

  getChallengesCreated = function(id) {
    return this.challengesCreated.transform(this.user.challenges, this.user);
  };

  constructor(private userChallengeService: UserChallengeService,
              private completedChallenges: CompletedStatusPipe,
              private topSkills: TopSkillsPipe,
              private challengesCreated: ChallengesCreatedPipe) { }

  ngOnInit() {
  }

}
