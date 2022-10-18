import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetDocidComponent } from './get-docid.component';

describe('GetDocidComponent', () => {
  let component: GetDocidComponent;
  let fixture: ComponentFixture<GetDocidComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GetDocidComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GetDocidComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
