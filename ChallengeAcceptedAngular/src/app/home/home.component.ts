import { HomeService } from './../home.service';
import { UserSkill } from './../models/user-skill';
import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  userskills: UserSkill[] = [];
  leaderboard: UserSkill[] = [];

  getLeaderboard(userskills) {
    for (let index = 0; index < 5; index++) {
      this.leaderboard.push(userskills[index]);
    }
  }
  constructor(private homeService: HomeService,
              private authService: AuthService,
              private http: HttpClient) { }

  ngOnInit() {
    this.homeService.getAllUserSkills().subscribe(
      data => {
        this.userskills = data;
        console.log(this.userskills);
        this.getLeaderboard(this.userskills);
      },
      error => {
        console.log(error);
      }
    );
  }

}
