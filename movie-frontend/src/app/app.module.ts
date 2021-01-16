import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {ActorListComponent} from './components/actor-list/actor-list.component';
import {HttpClientModule} from '@angular/common/http';
import {ActorService} from './services/actor.service';
import {RouterModule, Routes} from '@angular/router';

const routes: Routes = [
  {path: 'actor-list', component: ActorListComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    ActorListComponent
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
