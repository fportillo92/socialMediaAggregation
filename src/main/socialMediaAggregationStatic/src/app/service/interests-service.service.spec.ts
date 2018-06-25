import { TestBed, inject } from '@angular/core/testing';

import { InterestsService } from './interests-service.service';

describe('InterestsServiceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [InterestsService]
    });
  });

  it('should be created', inject([InterestsService], (service: InterestsService) => {
    expect(service).toBeTruthy();
  }));
});
