import { Challenge } from './models/challenge';
import { UserChallenge } from './models/user-challenge';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { throwError } from 'rxjs';
import {catchError} from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class UserChallengeService {

  url = 'http://localhost:8080/api';

  acceptingAMarketChallenge(acceptedChallenge) {
    // const headers = new HttpHeaders({'Content-Type': 'application/json'});
    console.log('Challenge ID: ' + acceptedChallenge.challenge.id);
    console.log('User ID: ' + acceptedChallenge.user.id);

    return this.http.post<UserChallenge>(`${this.url}/challenges/${acceptedChallenge.challenge.id}/accept`, acceptedChallenge).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(err);
      })
    );
  }

  acceptingAPersonalChallenge(acceptedChallenge) {
    this.http.patch<UserChallenge>(`${this.url}/challenges/${acceptedChallenge.id}/accept`, acceptedChallenge).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(err);
      })
    );
  }

  constructor(private http: HttpClient) { }
}
