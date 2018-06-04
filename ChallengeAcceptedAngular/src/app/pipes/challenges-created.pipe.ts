import { User } from './../models/user';
import { Pipe, PipeTransform } from '@angular/core';
import { Challenge } from '../models/challenge';

@Pipe({
  name: 'challengesCreated'
})
export class ChallengesCreatedPipe implements PipeTransform {

  createdChallenges = [];

  transform(challenges: Challenge[], user: User): any {
    challenges.forEach(element => {
      if (element.creator.id === user.id) {
        this.createdChallenges.push(element);
      }
    });
    return this.createdChallenges;
  }

}
