import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OrderDetailsEdityComponent } from './order-details-edity.component';

describe('OrderDetailsEdityComponent', () => {
  let component: OrderDetailsEdityComponent;
  let fixture: ComponentFixture<OrderDetailsEdityComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OrderDetailsEdityComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(OrderDetailsEdityComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
