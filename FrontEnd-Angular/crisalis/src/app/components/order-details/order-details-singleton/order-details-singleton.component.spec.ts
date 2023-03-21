import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OrderDetailsSingletonComponent } from './order-details-singleton.component';

describe('OrderDetailsSingletonComponent', () => {
  let component: OrderDetailsSingletonComponent;
  let fixture: ComponentFixture<OrderDetailsSingletonComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OrderDetailsSingletonComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(OrderDetailsSingletonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
