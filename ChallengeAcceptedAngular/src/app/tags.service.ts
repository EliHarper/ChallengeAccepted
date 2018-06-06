import { AuthService } from './auth.service';
import { catchError } from 'rxjs/operators';
import { Tag } from './models/tag';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { throwError } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class TagsService {
  url = 'http://localhost:8080/api';

  getAllTags() {
    // Get token
    const token = this.authService.getToken();
    // Send token as Authorization header (this is spring security convention for basic auth)
    const headers = new HttpHeaders().set('Authorization', `Basic ${token}`);

    if (this.authService.checkLogin()) {
      return this.http.get<Tag[]>(`${this.url}/tags`, {headers}).pipe(
        catchError((err: any) => {
          console.log(err);
          return throwError(err);
        })
      );
    }
  }

  constructor(
    private http: HttpClient,
    private authService: AuthService
  ) { }
}
