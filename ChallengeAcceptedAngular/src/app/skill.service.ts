import { AuthService } from './auth.service';
import { catchError } from 'rxjs/operators';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Skill } from './models/skill';
import { throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SkillService {
  url = 'http://localhost:8080/api';

  getSkillById(id) {
    // Get token
    const token = this.authService.getToken();
    // Send token as Authorization header (this is spring security convention for basic auth)
    const headers = new HttpHeaders().set('Authorization', `Basic ${token}`);

    if (this.authService.checkLogin()) {
      return this.http.get<Skill>(this.url + `/skills/${id}`, {headers}).pipe(
        catchError((err: any) => {
          console.log(err);
          return throwError(err);
        })
      );
    }
  }

  getAllSkills() {
    // Get token
    const token = this.authService.getToken();
    // Send token as Authorization header (this is spring security convention for basic auth)
    const headers = new HttpHeaders().set('Authorization', `Basic ${token}`);

    // if (this.authService.checkLogin()) {
      return this.http.get<Skill[]>(`${this.url}/skills`, {headers}).pipe(
        catchError((err: any) => {
          console.log(err);
          return throwError(err);
        })
      );
    // }
  }

  constructor(
    private http: HttpClient,
    private authService: AuthService
  ) { }
}
