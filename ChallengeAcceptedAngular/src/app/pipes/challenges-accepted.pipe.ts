import { element } from 'protractor';
import { UserChallenge } from './../models/user-challenge';
import { Pipe, PipeTransform } from '@angular/core';
import { Challenge } from '../models/challenge';
import { User } from '../models/user';

@Pipe({
  name: 'challengesAccepted'
})
export class ChallengesAcceptedPipe implements PipeTransform {

  transform(challenges: Challenge[], userChallenges: UserChallenge[], user: User): any {
    const acceptedChallenges = [];

    challenges.forEach(challenge => {
      if (challenge.creator.id === user.id ) {
        acceptedChallenges.push(challenge);
      }
    });
    return acceptedChallenges;
  }
}
