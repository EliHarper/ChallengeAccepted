import { TestBed, inject } from '@angular/core/testing';

import { UserSkillService } from './user-skill.service';

describe('UserSkillService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [UserSkillService]
    });
  });

  it('should be created', inject([UserSkillService], (service: UserSkillService) => {
    expect(service).toBeTruthy();
  }));
});
