import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PriceIndexComponent } from './price-index.component';

describe('PriceIndexComponent', () => {
  let component: PriceIndexComponent;
  let fixture: ComponentFixture<PriceIndexComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PriceIndexComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PriceIndexComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
