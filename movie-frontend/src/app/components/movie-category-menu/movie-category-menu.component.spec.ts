import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MovieCategoryMenuComponent } from './movie-category-menu.component';

describe('MovieCategoryMenuComponent', () => {
  let component: MovieCategoryMenuComponent;
  let fixture: ComponentFixture<MovieCategoryMenuComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MovieCategoryMenuComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MovieCategoryMenuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
