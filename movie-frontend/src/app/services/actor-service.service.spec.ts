import { TestBed } from '@angular/core/testing';

import { ActorServiceService } from './actor-service.service';

describe('ActorServiceService', () => {
  let service: ActorServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ActorServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
