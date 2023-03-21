import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OrderDetailsAddComponent } from './order-details-add.component';

describe('OrderDetailsAddComponent', () => {
  let component: OrderDetailsAddComponent;
  let fixture: ComponentFixture<OrderDetailsAddComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OrderDetailsAddComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(OrderDetailsAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
