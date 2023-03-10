import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BusinessAddComponent } from './business-add.component';

describe('BusinessAddComponent', () => {
  let component: BusinessAddComponent;
  let fixture: ComponentFixture<BusinessAddComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BusinessAddComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BusinessAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
