import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HardmodeCountdownComponent } from './hardmode-countdown.component';

describe('HardmodeCountdownComponent', () => {
  let component: HardmodeCountdownComponent;
  let fixture: ComponentFixture<HardmodeCountdownComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HardmodeCountdownComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HardmodeCountdownComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
