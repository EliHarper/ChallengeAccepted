import { UserService } from './../user.service';
import { AuthService } from './../auth.service';
import { SkillService } from './../skill.service';
import { TagsService } from './../tags.service';
import { Tag } from './../models/tag';
import { Router } from '@angular/router';
import { ChallengeViewComponent } from './../challenge-view/challenge-view.component';
import { Challenge } from './../models/challenge';
import { ChallengeService } from './../challenge.service';
import { Component, OnInit } from '@angular/core';
import { throwError } from 'rxjs';
import { Skill } from '../models/skill';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  challenge: Challenge = new Challenge();
  tags: Tag[] = [];
  skills: Skill[] = [];

  getTags() {
    this.tagService.getAllTags().subscribe(
      data => {
        this.tags = data;
      },
      error => {
        this.tags = null;
      }
    );
  }

  getSkills() {
    this.skillService.getAllSkills().subscribe(
      data => {
        this.skills = data;
      },
      error => {
        this.skills = null;
      }
    );
  }

  createChallenge(challenge) {
    this.userService.findUserByUsername(this.authService.getLoggedInUserName()).subscribe(
      data => {
        this.challengeService.create(challenge, data.id).subscribe(
        userData => this.router.navigateByUrl('challview/' + userData.id),
        err => throwError(err)
        );
      },
      error => {
        console.log(error);
      }
    );

  }

  checkLogin() {
    return this.authService.checkLogin();
  }

  userProfile() {
    const token = this.authService.getToken();
    const unpw = atob(token);
    console.log(unpw);
    const un = unpw.split(':')[0];
    this.router.navigateByUrl(`userprofile/${un}`);
  }

  constructor(private challengeService: ChallengeService,
              private router: Router,
              private tagService: TagsService,
              private skillService: SkillService,
              private authService: AuthService,
              private userService: UserService) { }

  ngOnInit() {
    this.getSkills();
    this.getTags();
  }

}
