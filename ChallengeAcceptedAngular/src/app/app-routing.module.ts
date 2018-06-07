import { InboxComponent } from './inbox/inbox.component';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { ChallengeViewComponent } from './challenge-view/challenge-view.component';
import { Challenge } from './models/challenge';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { ChallengeListComponent } from './challenge-list/challenge-list.component';
import { LogoutComponent } from './logout/logout.component';

const routes: Routes = [
  {path: '', pathMatch: 'full', redirectTo: 'home'},
  {path: 'challview/:id', component: ChallengeViewComponent},
  {path: 'userprofile/:id', component: UserProfileComponent},
  {path: 'allchallenges', component: ChallengeListComponent},
  {path: 'home', component: HomeComponent},
  {path: 'login', component: LoginComponent},
  {path: 'logout', component: LogoutComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'messages/:id', component: InboxComponent},
  {path: '**', component: HomeComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
