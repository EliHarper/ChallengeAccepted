import { Challenge } from './../models/challenge';
import { User } from './../models/user';
import { Pipe, PipeTransform } from '@angular/core';
import { Status } from '../models/status';

@Pipe({
  name: 'completedStatus'
})
export class CompletedStatusPipe implements PipeTransform {

  completedChallenges = [];

  transform(challenges: Challenge[]): any {
    challenges.forEach(element => {
      if (element.status.id === 3) {
        this.completedChallenges.push(element);
      }
    });
    return this.completedChallenges;
  }

}
