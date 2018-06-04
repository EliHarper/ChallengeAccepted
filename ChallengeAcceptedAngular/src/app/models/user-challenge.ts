import { Challenge } from './challenge';
import { User } from './user';

export class UserChallenge {
  id: number;
  user: User;
  challenge: Challenge;
  accepted: boolean;
  acceptTime: Date;
  acceptorWon: boolean;

  constructor(user?: User, challenge?: Challenge,
    accepted?: boolean, acceptorWon?: boolean, acceptTime?: Date ) {
      this.user = user;
      this.challenge = challenge;
      this.accepted = accepted;
      this.acceptorWon = acceptorWon;
      this.acceptTime = acceptTime;
    }
}
