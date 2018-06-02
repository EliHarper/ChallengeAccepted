import { UserChallenge } from './models/user-challenge';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserChallengeService {

  acceptingAMarketChallenge(acceptedChallenge) {
    this.http.post<UserChallenge>()
  }

  constructor(private http: HttpClient) { }
}
