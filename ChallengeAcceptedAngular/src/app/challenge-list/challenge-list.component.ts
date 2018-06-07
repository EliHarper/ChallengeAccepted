import { Challenge } from './../models/challenge';
import { ChallengeService } from './../challenge.service';
import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { AuthService } from '../auth.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-challenge-list',
  templateUrl: './challenge-list.component.html',
  styleUrls: ['./challenge-list.component.css']
})
export class ChallengeListComponent implements OnInit {
  url = 'http://localhost:8080/api';
  challengeList;
  userList = [];

  getAllPendingChallenges() {

    this.challengeService.showChallengesByStatusId(1).subscribe(
      data => {
        this.challengeList = data;
        // console.log(data);
      },
      error => {
        console.log(error);
      }
    );
  }

  getIcons(name) {
    name = name.split(' ').join('');
    console.log(name);
    return '../../assets/img/icon/' + name + '.png';
  }

  constructor(
    private challengeService: ChallengeService,
    private userService: UserService,
    private authService: AuthService,
    private http: HttpClient
    ) {}

  ngOnInit() {
    this.getAllPendingChallenges();
  }
}
