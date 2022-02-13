import { TestBed } from '@angular/core/testing';

import { ContactowsService } from './contactows.service';

describe('ContactowsService', () => {
  let service: ContactowsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ContactowsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
