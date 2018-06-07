import { Router } from '@angular/router';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable, throwError } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthService {


  login (username, password) {
    console.log('**** IN LOGIN TOP LEVEL ***');
    console.log(username);
    console.log(password);

    const token = this.generateBasicAuthToken(username, password);
    const headers = new HttpHeaders()
    .set('Authorization', `Basic ${token}`);

    return this.http.get('http://localhost:8080/authenticate', {headers}).pipe(
      tap((res) => {
        console.log(username + ':' + password + '****** IN LOGIN TAP ***');
        localStorage.setItem('token' , token);
        return res;
      }),
      catchError((err: any) => {
        console.log(err);
        return throwError('KABOOM');
      })
    );
  }

  register(user) {
    return this.http.post('http://localhost:8080/register', user).pipe(
      tap((res) => {
        console.log('******* IN AUTH REGISTER *********');
        console.log(user);
        this.login(user.username, user.password).subscribe(
          data => {
            this.router.navigateByUrl('/home');
          },
          error => {
            console.log(error);
          }
        );
      }),
      catchError((err: any) => {
        console.log('ERROR IN REGISTER ARROO');
        return throwError('KABOOM');
      })
    );
  }

  logout() {
    localStorage.removeItem('token');
  }

  checkLogin() {
    if (localStorage.getItem('token')) {
      return true;
    }
    return false;
  }

  generateBasicAuthToken(username, password) {
    return btoa(`${username}:${password}`);
  }

  getToken() {
    return localStorage.getItem('token');
  }

  getLoggedInUserName() {
    const token = this.getToken();
    const unpw = atob(token);
    console.log(unpw);
    const un = unpw.split(':')[0];
    return un;
  }
  constructor(private http: HttpClient,
              private router: Router) { }

}
