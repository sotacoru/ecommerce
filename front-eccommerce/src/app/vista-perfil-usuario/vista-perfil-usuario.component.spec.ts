import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VistaPerfilUsuarioComponent } from './vista-perfil-usuario.component';

describe('VistaPerfilUsuarioComponent', () => {
  let component: VistaPerfilUsuarioComponent;
  let fixture: ComponentFixture<VistaPerfilUsuarioComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VistaPerfilUsuarioComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(VistaPerfilUsuarioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
