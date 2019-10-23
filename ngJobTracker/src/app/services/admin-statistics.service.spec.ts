import { TestBed } from '@angular/core/testing';

import { AdminStatisticsService } from './admin-statistics.service';

describe('AdminStatisticsService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AdminStatisticsService = TestBed.get(AdminStatisticsService);
    expect(service).toBeTruthy();
  });
});
