import { TagsService } from './../tags.service';
import { UserService } from './../user.service';
import { HttpHeaders } from '@angular/common/http';
import { UserChallenge } from './../models/user-challenge';
import { Challenge } from './../models/challenge';
import { ChallengeService } from './../challenge.service';
import { Component, OnInit } from '@angular/core';
import { UserChallengeService } from '../user-challenge.service';
import { User } from '../models/user';
import { Router, ActivatedRoute } from '@angular/router';
import { Tag } from '../models/tag';


@Component({
  selector: 'app-challenge-view',
  templateUrl: './challenge-view.component.html',
  styleUrls: ['./challenge-view.component.css']
})
export class ChallengeViewComponent implements OnInit {

  displayChallenge: Challenge;
  user = new User(); // change to localstorage user when ready
  flag = false;
  testUser: User = new User(2);
  tags: Tag[] = [];
  selectedTags: Tag[] = [];
  userIdList: number[] = [];
  challengers: UserChallenge[] = [];



  acceptChallenge () {
    const dto = {'challengeId': this.displayChallenge.id,
    'acceptorId': this.testUser.id};
    this.userChallengeService.hasUserAcceptedChallenge(dto).subscribe(
      data => {
        if (!data) {
          this.userChallengeService.acceptingAMarketChallenge(dto).subscribe(
            data2 => {
              this.getChallengeData();
            },
            error2 => {
              console.log(error2);
            }
            );
        } else {
          console.log('ALREADY IN THERE');
        }
      },
      error => {
        console.log(error);
      }
    );
  }

  setChallengeToActive(id) {
    this.challengeService.setChallengeToActive(id).subscribe(
      data => {
        this.getChallengeData();
      },
      error => {
        console.log(error);
      }
    );
  }

  setChallengeToExpired(id) {
    this.challengeService.setChallengeToExpired(id).subscribe(
      data => {
        this.getChallengeData();
      },
      error => {
        console.log(error);
      }
    );
  }

  setChallengeToCompleted(id) {
    this.challengeService.setChallengeToCompleted(id).subscribe(
      data => {
        this.getChallengeData();
      },
      error => {
        console.log(error);
      }
    );
  }

  navigateToUserProfile () {

  }
  getAcceptedData(id) {
    this.userChallengeService.getAllPendingAndAcceptedChallenges(id).subscribe(
      data => {
        this.challengers = data;
      },
      error => {
        console.log(error);
      }
    );
  }

  getChallengeData() {
    this.challengeService.showOneChallenge(this.route.snapshot.paramMap.get('id')).subscribe(
      data => {
        console.log(data);
        // console.log(data.users);
        // console.log(data.users[0]);
        this.displayChallenge = data;
        this.getAcceptedData(data.id);
      },
      error => {
        this.displayChallenge = null;
      }
    );
  }

  getTags() {
    this.tagService.getAllTags().subscribe(
      data => {
        console.log(data);
        this.tags = data;
      },
      error => {
        this.tags = null;
        console.log(error);

      }
    );
  }
  updateUserIdList(id: number) {
    console.log(this.userIdList.indexOf(id));

    if (this.userIdList.includes(id)) {
      this.userIdList.splice(this.userIdList.indexOf(id) , 1);
    } else {
      this.userIdList.push(id);
    }
    console.log(this.userIdList);

  }

  updateWholeUserList(id, challenge) {
    console.log(challenge);

    for (let index = 0; index < this.userIdList.length; index++) {
      this.userChallengeService.updateUserWinner(id, this.userIdList[index], this.displayChallenge).subscribe(
        data => {
          if (this.userIdList[this.userIdList.length - 1] === data.id) {
            this.setChallengeToCompleted(this.displayChallenge.id);
          }
        },
        error => {
          console.log(error);
        }
      );
    }
  }

  constructor(private challengeService: ChallengeService,
  private userChallengeService: UserChallengeService,
  private route: ActivatedRoute,
  private tagService: TagsService) { }

  ngOnInit() {
    this.getChallengeData();
  }

}
