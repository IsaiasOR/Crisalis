import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OrderEdityComponent } from './order-edity.component';

describe('OrderEdityComponent', () => {
  let component: OrderEdityComponent;
  let fixture: ComponentFixture<OrderEdityComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OrderEdityComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(OrderEdityComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
