import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { DatePipe } from '@angular/common';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ChallengeListComponent } from './challenge-list/challenge-list.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { AboutComponent } from './about/about.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { RegisterComponent } from './register/register.component';
import { NavbarComponent } from './navbar/navbar.component';
import { FallbackComponent } from './fallback/fallback.component';
import { ChallengeViewComponent } from './challenge-view/challenge-view.component';
import { HomeComponent } from './home/home.component';
import { CompletedStatusPipe } from './pipes/completed-status.pipe';
import { TopSkillsPipe } from './pipes/top-skills.pipe';
import { TestingComponent } from './testing/testing.component';
<<<<<<< HEAD
import { ChallengesCreatedPipe } from './challenges-created.pipe';
import { ChallengesAcceptedPipe } from './pipes/challenges-accepted.pipe';
=======
import { ChallengesCreatedPipe } from './pipes/challenges-created.pipe';
>>>>>>> 5194993fa9b17df1fec6084976cc2513d60e1c2f

@NgModule({
  declarations: [
    AppComponent,
    ChallengeListComponent,
    UserProfileComponent,
    AboutComponent,
    LoginComponent,
    LogoutComponent,
    RegisterComponent,
    NavbarComponent,
    FallbackComponent,
    ChallengeViewComponent,
    HomeComponent,
    CompletedStatusPipe,
    TopSkillsPipe,
    TestingComponent,
    ChallengesCreatedPipe,
    ChallengesAcceptedPipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [CompletedStatusPipe,
    TopSkillsPipe,
    ChallengesCreatedPipe ],
  bootstrap: [AppComponent]
})
export class AppModule { }
