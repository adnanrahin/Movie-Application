import { TestBed } from '@angular/core/testing';

import { MovieFormService } from './movie-form.service';

describe('MovieFormService', () => {
  let service: MovieFormService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MovieFormService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
