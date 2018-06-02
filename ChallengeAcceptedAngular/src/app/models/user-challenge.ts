import { Challenge } from './challenge';
import { User } from './user';

export class UserChallenge {
  user: User;
  challenge: Challenge;
  accepted: boolean;
  acceptTime: Date;
  acceptorWon: boolean;
}
