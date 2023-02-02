import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TaxAddComponent } from './tax-add.component';

describe('TaxAddComponent', () => {
  let component: TaxAddComponent;
  let fixture: ComponentFixture<TaxAddComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TaxAddComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TaxAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
