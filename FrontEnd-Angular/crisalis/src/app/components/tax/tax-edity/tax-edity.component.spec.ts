import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TaxEdityComponent } from './tax-edity.component';

describe('TaxEdityComponent', () => {
  let component: TaxEdityComponent;
  let fixture: ComponentFixture<TaxEdityComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TaxEdityComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TaxEdityComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
