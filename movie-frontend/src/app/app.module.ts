import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {ActorListComponent} from './components/actor-list/actor-list.component';
import {HttpClientModule} from '@angular/common/http';
import {ActorService} from './services/actor.service';
import {RouterModule, Routes} from '@angular/router';
import {MovieListComponent} from './components/movie-list/movie-list.component';
import {MovieCategoryMenuComponent} from './components/movie-category-menu/movie-category-menu.component';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {SearchComponent} from './components/search/search.component';
import {MovieDetailsComponent} from './components/movie-details/movie-details.component';
import {AddFilmComponent} from './components/add-film/add-film.component';
import {ReactiveFormsModule} from '@angular/forms';
import { LoginComponent } from './components/login/login.component';

const routes: Routes = [
  {path: 'category/:id', component: MovieListComponent},
  {path: 'category', component: MovieListComponent},
  {path: 'movieDetails/:id', component: MovieDetailsComponent},
  {path: 'movies', component: MovieListComponent},
  {path: 'category', component: MovieListComponent},
  {path: 'addFilm', component: AddFilmComponent},
  {path: 'category/:id', component: MovieListComponent},
  {path: 'search/:keyword', component: MovieListComponent},
  {path: '', redirectTo: '/movies', pathMatch: 'full'},
  {path: '**', redirectTo: '/movies', pathMatch: 'full'}
];

@NgModule({
  declarations: [
    AppComponent,
    ActorListComponent,
    MovieListComponent,
    MovieCategoryMenuComponent,
    SearchComponent,
    MovieDetailsComponent,
    AddFilmComponent,
    LoginComponent
  ],
  imports: [
    RouterModule.forRoot(routes),
    BrowserModule,
    HttpClientModule,
    RouterModule,
    NgbModule,
    ReactiveFormsModule
  ],
  providers: [ActorService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
