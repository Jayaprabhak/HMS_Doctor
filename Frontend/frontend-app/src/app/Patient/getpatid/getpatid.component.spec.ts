import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetpatidComponent } from './getpatid.component';

describe('GetpatidComponent', () => {
  let component: GetpatidComponent;
  let fixture: ComponentFixture<GetpatidComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GetpatidComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GetpatidComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
