import { AuthService } from './auth.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError } from 'rxjs/operators';
import { Injectable } from '@angular/core';
import { UserSkill } from './models/user-skill';
import { throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserSkillService {

  url = 'http://localhost:8080/api';

  findUserSkillById(usid) {
    // Get token
    const token = this.authService.getToken();
    // Send token as Authorization header (this is spring security convention for basic auth)
    const headers = new HttpHeaders().set('Authorization', `Basic ${token}`);

    if (this.authService.checkLogin()) {
      return this.http.get<UserSkill[]>(`${this.url}/users/${usid}`, {headers}).pipe(
        catchError((err: any) => {
          console.log(err);
          return throwError(err);
        })
      );
    }
  }

  getUserSkills(uid) {
    // Get token
    const token = this.authService.getToken();
    // Send token as Authorization header (this is spring security convention for basic auth)
    const headers = new HttpHeaders().set('Authorization', `Basic ${token}`);

    if (this.authService.checkLogin()) {
      return this.http.get<UserSkill[]>(`${this.url}/userskills/${uid}`, {headers}).pipe(
        catchError((err: any) => {
          console.log(err);
          return throwError(err);
        })
      );
    }
  }

  getLevelOfSkill(userSkill: UserSkill) {
    return userSkill.points / 10;
  }

  getUserProgressToNextLevel(userSkill: UserSkill) {
    return userSkill.points % 10;
  }

  findUserSkillBySAndUId(skillId, userId) {
        // Get token
        const token = this.authService.getToken();
        // Send token as Authorization header (this is spring security convention for basic auth)
        const headers = new HttpHeaders().set('Authorization', `Basic ${token}`);

    return this.http.get<UserSkill>(`${this.url}/userskill/one/${skillId}/${userId}`, {headers}).pipe(
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
