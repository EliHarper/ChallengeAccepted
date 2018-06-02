import { UserChallenge } from './user-challenge';
import { Skill } from './skill';
import { User } from './user';
import { Tag } from './tag';
import { Status } from './status';

export class Challenge {
  id: number;
  location: string;
  name: string;
  description: string;
  wager: number;
  minNumberOfChallengers: number;
  maxNumberOfChallengers: number;
  status: Status;
  tags: Tag[];
  creator: User;
  skill: Skill;
  userChallenges: UserChallenge[];
  timeCreated: Date;

}
