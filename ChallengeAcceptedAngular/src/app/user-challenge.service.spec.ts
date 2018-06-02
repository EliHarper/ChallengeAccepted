import { TestBed, inject } from '@angular/core/testing';

import { UserChallengeService } from './user-challenge.service';

describe('UserChallengeService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [UserChallengeService]
    });
  });

  it('should be created', inject([UserChallengeService], (service: UserChallengeService) => {
    expect(service).toBeTruthy();
  }));
});
