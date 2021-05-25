import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormLoginRegistroComponent } from './form-login-registro.component';

describe('FormLoginRegistroComponent', () => {
  let component: FormLoginRegistroComponent;
  let fixture: ComponentFixture<FormLoginRegistroComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FormLoginRegistroComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FormLoginRegistroComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
