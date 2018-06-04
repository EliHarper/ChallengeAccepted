import { catchError } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Skill } from './models/skill';
import { throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SkillService {
  url = 'http://localhost:8080/api';

  getSkillById(id) {
    return this.http.get<Skill>(this.url + `/skills/${id}`).pipe(
    catchError((err: any) => {
      console.log(err);
      return throwError(err);
      })
    );
  }

  constructor(private http: HttpClient) { }
}
