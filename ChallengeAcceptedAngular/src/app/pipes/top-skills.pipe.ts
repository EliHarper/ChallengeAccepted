import { Skill } from './../models/skill';
import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'topSkills'
})
export class TopSkillsPipe implements PipeTransform {

  // completedChallenges = [];

  // transform(challenges: Challenge[]): any {
  //   challenges.forEach(element => {
  //     if (element.status.id === 3) {
  //       this.completedChallenges.push(element);
  //     }
  //   });
  //   return this.completedChallenges;
  // }

  topSkills = [];

  transform(skills: Skill[]): any {
    skills.forEach(function(skill, idx) {
      if (idx <= 2) {
        this.topSkills.push(skill);
      }
    });

    return this.topSkills;

  }

}
