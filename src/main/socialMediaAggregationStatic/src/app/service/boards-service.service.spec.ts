import { TestBed, inject } from '@angular/core/testing';

import { BoardsService } from './boards-service.service';

describe('BoardsServiceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [BoardsService]
    });
  });

  it('should be created', inject([BoardsService], (service: BoardsService) => {
    expect(service).toBeTruthy();
  }));
});
