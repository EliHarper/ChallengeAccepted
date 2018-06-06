import {
  AuthService
} from './auth.service';
import {
  catchError
} from 'rxjs/operators';
import {
  Injectable
} from '@angular/core';
import {
  HttpClient,
  HttpHeaders
} from '@angular/common/http';
import {
  Challenge
} from './models/challenge';
import {
  throwError
} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ChallengeService {
  url = 'http://localhost:8080/api';

  showOneChallenge(id) {
    // Getting el token
    const token = this.authService.getToken();

    const headers = new HttpHeaders().set('Authorization', `Basic ${token}`);

    if (this.authService.checkLogin) {
      return this.http.get < Challenge > (`${this.url}/challenges/${id}`).pipe(
        catchError((err: any) => {
          console.log(err);
          return throwError(err);
        })
      );
    }
  }

  showChallengesByStatusId(id) {
    // Getting el token
    const token = this.authService.getToken();

    const headers = new HttpHeaders().set('Authorization', `Basic ${token}`);

    if (this.authService.checkLogin) {
      return this.http.get < Challenge[] > (`${this.url}/challenges/status/${id}`).pipe(
        catchError((err: any) => {
          console.log(err);
          return throwError(err);
        })
      );
    }
  }

  setChallengeToActive(id) {
    // Getting el token
    const token = this.authService.getToken();

    const headers = new HttpHeaders().set('Authorization', `Basic ${token}`);

    if (this.authService.checkLogin) {
      return this.http.patch < Challenge > (`${this.url}/challenges/${id}/status/2`, {}).pipe(
        catchError((err: any) => {
          console.log(err);
          return throwError(err);
        })
      );
    }
  }

  setChallengeToExpired(id) {
    // Getting el token
    const token = this.authService.getToken();

    const headers = new HttpHeaders().set('Authorization', `Basic ${token}`);

    if (this.authService.checkLogin) {
      return this.http.patch < Challenge > (`${this.url}/challenges/${id}/status/4`, {}).pipe(
        catchError((err: any) => {
          console.log(err);
          return throwError(err);
        })
      );
    }
  }
  setChallengeToCompleted(id) {
    // Getting el token
    const token = this.authService.getToken();

    const headers = new HttpHeaders().set('Authorization', `Basic ${token}`);

    if (this.authService.checkLogin) {
      return this.http.patch < Challenge > (`${this.url}/challenges/${id}/status/3`, {}).pipe(
        catchError((err: any) => {
          console.log(err);
          return throwError(err);
        })
      );
    }
  }

  constructor(private http: HttpClient,
    private authService: AuthService) {}
}
