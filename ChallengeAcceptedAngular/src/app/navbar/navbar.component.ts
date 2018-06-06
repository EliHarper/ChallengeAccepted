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
    this.challengeService.create(challenge).subscribe(
      data => this.router.navigateByUrl('challview/' + data.id),
      err => throwError(err)
    );
  }

  constructor(private challengeService: ChallengeService,
              private router: Router,
              private tagService: TagsService,
              private skillService: SkillService) { }

  ngOnInit() {
    this.getSkills();
    this.getTags();
  }

  hover(element) {
    element.setAttribute('src', 'http://dummyimage.com/100x100/eb00eb/000');
  }

  unhover(element) {
    element.setAttribute('src', 'http://dummyimage.com/100x100/000/fff');
  }

}
