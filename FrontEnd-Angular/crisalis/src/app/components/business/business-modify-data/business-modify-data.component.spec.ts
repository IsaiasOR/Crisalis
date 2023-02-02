import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BusinessModifyDataComponent } from './business-modify-data.component';

describe('BusinessModifyDataComponent', () => {
  let component: BusinessModifyDataComponent;
  let fixture: ComponentFixture<BusinessModifyDataComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BusinessModifyDataComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BusinessModifyDataComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
