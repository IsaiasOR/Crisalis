import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserUnsubscribeComponent } from './user-unsubscribe.component';

describe('UserUnsubscribeComponent', () => {
  let component: UserUnsubscribeComponent;
  let fixture: ComponentFixture<UserUnsubscribeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserUnsubscribeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UserUnsubscribeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
