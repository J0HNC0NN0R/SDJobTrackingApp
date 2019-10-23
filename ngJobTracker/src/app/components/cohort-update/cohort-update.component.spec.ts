import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CohortUpdateComponent } from './cohort-update.component';

describe('CohortUpdateComponent', () => {
  let component: CohortUpdateComponent;
  let fixture: ComponentFixture<CohortUpdateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CohortUpdateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CohortUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
