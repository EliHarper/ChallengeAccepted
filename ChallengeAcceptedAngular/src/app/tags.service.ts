import { catchError } from 'rxjs/operators';
import { Tag } from './models/tag';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { throwError } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class TagsService {
  url = 'http://localhost:8080/api';

  getAllTags() {
    return this.http.get<Tag[]>(`${this.url}/tags`).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(err);
      })
    );
  }

  constructor(private http: HttpClient) { }
}
