import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClientModifyDataComponent } from './client-modify-data.component';

describe('ClientModifyDataComponent', () => {
  let component: ClientModifyDataComponent;
  let fixture: ComponentFixture<ClientModifyDataComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ClientModifyDataComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ClientModifyDataComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
