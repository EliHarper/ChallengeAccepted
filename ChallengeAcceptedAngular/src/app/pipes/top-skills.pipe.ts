import { Skill } from './../models/skill';
import { Pipe, PipeTransform } from '@angular/core';
import { UserSkill } from '../models/user-skill';

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


  transform(skills: UserSkill[]): any {
    const topSkills = [];
    skills.forEach(function(skill, idx) {
      if (idx <= 2) {
        topSkills.push(skill);
      }
    });

    return topSkills;

  }

}
