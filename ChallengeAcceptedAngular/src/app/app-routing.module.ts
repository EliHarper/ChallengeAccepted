import { ChallengeViewComponent } from './challenge-view/challenge-view.component';
import { Challenge } from './models/challenge';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  {path: 'challenge/:id', component: ChallengeViewComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
