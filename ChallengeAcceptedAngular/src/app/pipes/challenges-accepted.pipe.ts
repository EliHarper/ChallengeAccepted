import { element } from 'protractor';
import { UserChallenge } from './../models/user-challenge';
import { Pipe, PipeTransform } from '@angular/core';
import { Challenge } from '../models/challenge';
import { User } from '../models/user';

@Pipe({
  name: 'challengesAccepted'
})
export class ChallengesAcceptedPipe implements PipeTransform {

  acceptedChallenges = [];

  transform(challenges: Challenge[], userChallenges: UserChallenge[], user: User): any {
    // tslint:disable-next-line:no-shadowed-variable
    challenges.forEach(element => {
      if (element.creator.id === user.id ) {
        this.acceptedChallenges.push(element);
      }
    });
  }
}
