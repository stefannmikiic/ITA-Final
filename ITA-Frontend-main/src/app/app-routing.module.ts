import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { HomeComponent } from './home/home.component';
import { ClubsComponent } from './clubs/clubs.component';
import { RulesComponent } from './rules/rules.component';
import { LocationComponent } from './location/location.component';
import { ContactusComponent } from './contactus/contactus.component';
import { MatchpageComponent } from './matchpage/matchpage.component';
import { AdminAppComponent } from './admin-app/admin-app.component';
import { WebsiteAppComponent } from './website-app/website-app.component';
import { AdminhomeComponent } from './admin-app/adminhome/adminhome.component';

const routes: Routes = [
  {path: 'admin', component: AdminAppComponent},
  {path: 'admin/home', component: AdminhomeComponent},
  {
    path: '',
    component: WebsiteAppComponent,
    children: [
      {path: '', component: HomeComponent},
      {path: 'clubs', component: ClubsComponent},
      {path: 'rules', component: RulesComponent},
      {path: 'location', component: LocationComponent},
      {path: 'contact-us', component: ContactusComponent},
      {path: 'match/:matchName', component: MatchpageComponent},
    ]
  },
  {path: '**', redirectTo: '', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {scrollPositionRestoration: 'enabled'})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
