import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import { ClubsComponent } from './clubs/clubs.component';
import { RulesComponent } from './rules/rules.component';
import { LocationComponent } from './location/location.component';
import { ContactusComponent } from './contactus/contactus.component';
import { SliderComponent } from './location/slider/slider.component';
import { MatchpageComponent } from './matchpage/matchpage.component';
import { CommentformComponent } from './commentform/commentform.component';
import { AdminAppComponent } from './admin-app/admin-app.component';
import { WebsiteAppComponent } from './website-app/website-app.component';
import { AdminheaderComponent } from './admin-app/adminheader/adminheader.component';
import { AdminhomeComponent } from './admin-app/adminhome/adminhome.component';
import { MatchinfoComponent } from './matchinfo/matchinfo.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HomeComponent,
    ClubsComponent,
    RulesComponent,
    LocationComponent,
    ContactusComponent,
    SliderComponent,
    MatchpageComponent,
    CommentformComponent,
    AdminAppComponent,
    WebsiteAppComponent,
    AdminheaderComponent,
    AdminhomeComponent,
    MatchinfoComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
