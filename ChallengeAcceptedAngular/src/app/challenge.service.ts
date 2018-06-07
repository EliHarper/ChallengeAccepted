import { AuthService } from './auth.service';
import { catchError } from 'rxjs/operators';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Challenge } from './models/challenge';
import { throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ChallengeService {
  url = 'http://localhost:8080/api';

  create = function (challenge, myId) {
    // Get token
    const token = this.authService.getToken();
    console.log(challenge.skill);

    // Send token as Authorization header (this is spring security convention for basic auth)
    const headers = new HttpHeaders().set('Authorization', `Basic ${token}`);
    const challDTO = {skillId: challenge.skill.id,
      creatorId: myId,
      location: challenge.location,
      name: challenge.name,
      description: challenge.description,
      minNumberOfChallengers: challenge.minNumberOfChallengers,
      maxNumberOfChallengers: challenge.maxNumberOfChallengers,
      tags: challenge.tags,
      wager: 0
    };

    if (this.authService.checkLogin()) {
      return this.http.post(`${this.url}/challenges`, challDTO, { headers })
        .pipe(
          catchError((err: any) => {
            console.log(err);
            return throwError(err);
          })
        );
    }
  };

  showOneChallenge(id) {
    // Get token
    const token = this.authService.getToken();
    // Send token as Authorization header (this is spring security convention for basic auth)
    const headers = new HttpHeaders().set('Authorization', `Basic ${token}`);

    if (this.authService.checkLogin()) {
      return this.http.get<Challenge>(`${this.url}/challenges/${id}`, { headers }).pipe(
        catchError((err: any) => {
          console.log(err);
          return throwError(err);
        })
      );
    }
  }

  showChallengesByStatusId(id) {

      return this.http.get < Challenge[] > (`${this.url}/challenges/status/${id}`).pipe(
        catchError((err: any) => {
          console.log(err);
          return throwError(err);
        })
      );
  }

  setChallengeToActive(id) {
    // Get token
    const token = this.authService.getToken();
    // Send token as Authorization header (this is spring security convention for basic auth)
    const headers = new HttpHeaders().set('Authorization', `Basic ${token}`);

    if (this.authService.checkLogin()) {
      return this.http.patch < Challenge > (`${this.url}/challenges/${id}/status/2`, {headers}).pipe(
        catchError((err: any) => {
          console.log(err);
          return throwError(err);
        })
      );
    }
  }

  setChallengeToExpired(id) {
    // Get token
    const token = this.authService.getToken();
    // Send token as Authorization header (this is spring security convention for basic auth)
    const headers = new HttpHeaders().set('Authorization', `Basic ${token}`);

    if (this.authService.checkLogin()) {
      return this.http.patch < Challenge > (`${this.url}/challenges/${id}/status/4`, {headers}).pipe(
        catchError((err: any) => {
          console.log(err);
          return throwError(err);
        })
      );
    }
  }
  setChallengeToCompleted(id) {
    // Get token
    const token = this.authService.getToken();
    // Send token as Authorization header (this is spring security convention for basic auth)
    const headers = new HttpHeaders().set('Authorization', `Basic ${token}`);

    if (this.authService.checkLogin()) {
      return this.http.patch < Challenge > (`${this.url}/challenges/${id}/status/3`, {headers}).pipe(
        catchError((err: any) => {
          console.log(err);
          return throwError(err);
        })
      );
    }
  }

  getChallengesOfUserAndStatus(uid, sid) {
    // Get token
    const token = this.authService.getToken();
    // Send token as Authorization header (this is spring security convention for basic auth)
    const headers = new HttpHeaders().set('Authorization', `Basic ${token}`);

    if (this.authService.checkLogin()) { }
      return this.http.get<Challenge[]>(`${this.url}/challenges/user/${uid}/status/${sid}`, {headers}).pipe(
        catchError((err: any) => {
          console.log(err);
          return throwError(err);
        })
      );
    }

constructor(
  private http: HttpClient,
  private authService: AuthService
  ) { }

}
