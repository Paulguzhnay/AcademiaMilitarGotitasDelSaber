import { TestBed } from '@angular/core/testing';

import { HistoriaAcademicawsService } from './historia-academicaws.service';

describe('HistoriaAcademicawsService', () => {
  let service: HistoriaAcademicawsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(HistoriaAcademicawsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
