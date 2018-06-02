import { UserChallenge } from './models/user-challenge';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { throwError } from 'rxjs';
import {catchError} from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class UserChallengeService {

  url = 'http://localhost:8080';


  acceptingAMarketChallenge(acceptedChallenge) {
    this.http.post<UserChallenge>(this.url, acceptedChallenge).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(err);
      })
    );
  }

  constructor(private http: HttpClient) { }
}
