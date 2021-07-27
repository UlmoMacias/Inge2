import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IncorrectoComponent } from './incorrecto.component';

describe('IncorrectoComponent', () => {
  let component: IncorrectoComponent;
  let fixture: ComponentFixture<IncorrectoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ IncorrectoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(IncorrectoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
