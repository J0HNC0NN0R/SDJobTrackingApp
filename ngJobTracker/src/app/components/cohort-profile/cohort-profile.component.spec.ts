import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CohortProfileComponent } from './cohort-profile.component';

describe('CohortProfileComponent', () => {
  let component: CohortProfileComponent;
  let fixture: ComponentFixture<CohortProfileComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CohortProfileComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CohortProfileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
