import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserModifyDataComponent } from './user-modify-data.component';

describe('UserModifyDataComponent', () => {
  let component: UserModifyDataComponent;
  let fixture: ComponentFixture<UserModifyDataComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserModifyDataComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UserModifyDataComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
