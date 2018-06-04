import { User } from './../models/user';
import { Pipe, PipeTransform } from '@angular/core';
import { Challenge } from '../models/challenge';

@Pipe({
  name: 'challengesCreated'
})
export class ChallengesCreatedPipe implements PipeTransform {

  transform(challenges: Challenge[], user: User): any {
    const createdChallenges = [];

    challenges.forEach(element => {
      if (element.creator.id === user.id) {
        createdChallenges.push(element);
      }
    });
    return createdChallenges;
  }

}
