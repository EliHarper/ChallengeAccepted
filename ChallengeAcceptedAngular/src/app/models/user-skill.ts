import { Skill } from './skill';
import { User } from './user';

export class UserSkill {
  id: number;
  skill: Skill;
  user: User;
  points: number;
}
