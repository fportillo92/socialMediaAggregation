import { TestBed, inject } from '@angular/core/testing';

import { BoardsServiceService } from './boards-service.service';

describe('BoardsServiceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [BoardsServiceService]
    });
  });

  it('should be created', inject([BoardsServiceService], (service: BoardsServiceService) => {
    expect(service).toBeTruthy();
  }));
});
