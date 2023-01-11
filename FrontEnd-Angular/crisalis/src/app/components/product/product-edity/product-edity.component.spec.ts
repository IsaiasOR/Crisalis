import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProductEdityComponent } from './product-edity.component';

describe('ProductEdityComponent', () => {
  let component: ProductEdityComponent;
  let fixture: ComponentFixture<ProductEdityComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProductEdityComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProductEdityComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
