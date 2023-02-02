import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ServiceEdityComponent } from './service-edity.component';

describe('ServiceEdityComponent', () => {
  let component: ServiceEdityComponent;
  let fixture: ComponentFixture<ServiceEdityComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ServiceEdityComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ServiceEdityComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
