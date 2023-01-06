import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BusinessDeleteComponent } from './business-delete.component';

describe('BusinessDeleteComponent', () => {
  let component: BusinessDeleteComponent;
  let fixture: ComponentFixture<BusinessDeleteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BusinessDeleteComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BusinessDeleteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
