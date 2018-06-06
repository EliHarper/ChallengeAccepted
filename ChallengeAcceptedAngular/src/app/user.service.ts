import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from './models/user';
import { throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  url = 'http://localhost:8080/api';
  findUserById(id) {
    return this.http.get<User>(`${this.url}/users/${id}`).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(err);
      })
    );
  }

  findCreatorByChallengeId(id) {
    return this.http.get<User>(`${this.url}/users/challenge/${id}`).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(err);
      })
    );
  }

  registerUser(user) {
    return this.http.post<User>(`http://localhost:8080/register`, user).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(err);
      })
    );
  }

  login(user) {
    return this.http.post<User>(`http://localhost:8080/login`, user).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(err);
      })
    );
  }
  constructor(private http: HttpClient) { }


}
