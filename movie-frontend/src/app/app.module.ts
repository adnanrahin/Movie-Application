import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {ActorListComponent} from './components/actor-list/actor-list.component';
import {HttpClientModule} from '@angular/common/http';
import {ActorService} from './services/actor.service';
import {RouterModule, Routes} from '@angular/router';
import { CategoryComponent } from './components/movie-category-menu/category.component';
import { MovieListComponent } from './components/movie-list/movie-list.component';

const routes: Routes = [
  {path: 'actor-list', component: ActorListComponent},
  {path: 'category/:id', component: MovieListComponent},
  {path: 'category', component: MovieListComponent},
];

@NgModule({
  declarations: [
    AppComponent,
    ActorListComponent,
    CategoryComponent,
    MovieListComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule
  ],
  providers: [ActorService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
