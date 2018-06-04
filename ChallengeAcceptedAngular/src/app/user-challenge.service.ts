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
    const headers = new HttpHeaders({'Content-Type': 'application/json'});
    console.log(acceptedChallenge.challenge.id);
    console.log(acceptedChallenge.user.id);

    return this.http.post<UserChallenge>(`${this.url}/challenge/${acceptedChallenge.challenge.id}/accept`, acceptedChallenge,
     {headers}).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(err);
      })
    );
  }

  acceptingAPersonalChallenge(acceptedChallenge) {
    this.http.patch<UserChallenge>(`${this.url}/challenge/${acceptedChallenge.id}/accept`, acceptedChallenge).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(err);
      })
    );
  }

  constructor(private http: HttpClient) { }
}
