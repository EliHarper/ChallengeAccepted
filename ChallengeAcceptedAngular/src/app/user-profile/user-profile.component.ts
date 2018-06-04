import { SkillService } from './../skill.service';
import { UserSkillService } from './../user-skill.service';
import { UserService } from './../user.service';
import { ChallengeService } from './../challenge.service';
import { ChallengesAcceptedPipe } from './../pipes/challenges-accepted.pipe';
import { Challenge } from './../models/challenge';
import { TopSkillsPipe } from './../pipes/top-skills.pipe';
import { UserChallengeService } from './../user-challenge.service';
import { CompletedStatusPipe } from './../pipes/completed-status.pipe';
import { Component, OnInit } from '@angular/core';
import { User } from '../models/user';
import { ChallengesCreatedPipe } from '../pipes/challenges-created.pipe';
import { userInfo } from 'os';
import { ActivatedRoute } from '@angular/router';
import { UserSkill } from '../models/user-skill';
import { Skill } from '../models/skill';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  title = 'Profile of {{ user.username }}';
  user = new User();
  userSkills: UserSkill[] = [];

  getNumCompletedChallenges = function(id) {
    return this.completedChallenges.transform(this.user.challenges).length;
  };

  getLocation = function(id) {
    return this.user.location;
  };

  getTopSkills = function(id) {
    return this.topSkills.transform(this.user.skills);
  };

  getChallengesCreated = function(id) {
    this.user = this.userService.findUserById();
    return this.challengesCreated.transform(this.user.challenges, this.user);
  };

  getChallengesAccepted = function(id) {
    this.user = this.userService.findUserById();
    return this.challengesAccepted.transform(this.user.challenges, this.user.userChallenges, this.user);
  };

  getUserLevelOfSkill(id) {
    return this.userSkillService.findUserSkillById(id).subscribe(
      data => this.userSkills = data,
      error => this.user = null);
  }

  getSkillNameById(id) {
    this.skillService.getSkillById(id).subscribe(
      data => data,
      errror => null);
  }

  getUserProgressToNextLevel = function(id) {
    this.user = this.userService.findUserById(id);
    return this.userSkillService.getUserProgressToNextLevel(this.user);
  };

  getUserData() {
    console.log(this.route.snapshot.paramMap.get('id'));
    this.userService.findUserById(this.route.snapshot.paramMap.get('id')).subscribe(
      data => {
        this.user = data;
      },
      error => {
        this.user = null;
      }
    );
  }

  constructor(private userChallengeService: UserChallengeService,
    private completedChallenges: CompletedStatusPipe,
    private topSkills: TopSkillsPipe,
    private challengesCreated: ChallengesCreatedPipe,
    private challengeService: ChallengeService,
    private route: ActivatedRoute,
    private userService: UserService,
    private userSkillService: UserSkillService,
    private skillService: SkillService ) { }

  ngOnInit() {
    this.getUserData();
    this.userSkillService.findUserSkillById(this.user.id);
  }
}
