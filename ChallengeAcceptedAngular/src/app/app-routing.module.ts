import { ChallengeViewComponent } from './challenge-view/challenge-view.component';
import { Challenge } from './models/challenge';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { UserProfileComponent } from './user-profile/user-profile.component';

const routes: Routes = [
  {path: 'challview/:id', component: ChallengeViewComponent},
  {path: 'userprofile/:id', component: UserProfileComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
