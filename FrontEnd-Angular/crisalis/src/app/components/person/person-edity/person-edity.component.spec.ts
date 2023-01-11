import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PersonEdityComponent } from './person-edity.component';

describe('PersonEdityComponent', () => {
  let component: PersonEdityComponent;
  let fixture: ComponentFixture<PersonEdityComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PersonEdityComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PersonEdityComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
