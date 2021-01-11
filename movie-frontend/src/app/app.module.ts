import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {ActorListComponent} from './components/actor-list/actor-list.component';
import {HttpClientModule} from '@angular/common/http';
import {ActorServiceService} from './services/actor-service.service';

@NgModule({
  declarations: [
    AppComponent,
    ActorListComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [ActorServiceService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
