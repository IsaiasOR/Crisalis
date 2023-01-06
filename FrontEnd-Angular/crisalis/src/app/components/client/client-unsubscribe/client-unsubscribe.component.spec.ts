import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClientUnsubscribeComponent } from './client-unsubscribe.component';

describe('ClientUnsubscribeComponent', () => {
  let component: ClientUnsubscribeComponent;
  let fixture: ComponentFixture<ClientUnsubscribeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ClientUnsubscribeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ClientUnsubscribeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
