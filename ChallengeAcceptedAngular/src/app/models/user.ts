import { Skill } from './skill';
import { Challenge } from './challenge';
import { UserChallenge } from './user-challenge';
import { UserSkill } from './user-skill';
export class User {
  id: number;
  username: string;
  password: string;
  email: string;
  location: string;
  role: string;
  challenges: Challenge[];
  skills: Skill[];
  userChallenges: UserChallenge[];
  userSkills: UserSkill[];

  constructor(id?: number, username?: string, password?: string, email?: string, location?: string,
                role?: string, challenges?: Challenge[], skills?: Skill[], userChallenges?: UserChallenge[],
                userSkills?: UserSkill[] ) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.email = email;
    this.location = location;
    this.role = role;
    this.challenges = challenges;
    this.skills = skills;
    this.userChallenges = userChallenges;
    this.userSkills = userSkills;
  }
}
