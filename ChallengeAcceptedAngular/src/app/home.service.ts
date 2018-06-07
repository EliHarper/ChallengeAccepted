import { AuthService } from './auth.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UserSkill } from './models/user-skill';
import { catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HomeService {

  url = 'http://localhost:8080/api';

  getAllUserSkills() {
    // Get token
    // const token = this.authService.getToken();
    // Send token as Authorization header (this is spring security convention for basic auth)
    // const headers = new HttpHeaders().set('Authorization', `Basic ${token}`);

    // if (this.authService.checkLogin()) {
      return this.http.get<UserSkill[]>(`${this.url}/userskills/indexByPoints`).pipe(
        catchError((err: any) => {
          console.log('******************');
          console.log(err);
          return throwError(err);
        })
      );
    // }
  }

  constructor(private http: HttpClient,
              private authService: AuthService) { }
}
