import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InterestPageComponent } from './interest-page.component';

describe('InterestPageComponent', () => {
  let component: InterestPageComponent;
  let fixture: ComponentFixture<InterestPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InterestPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InterestPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
