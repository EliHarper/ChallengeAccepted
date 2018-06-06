import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Message } from './models/message';
import { catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class InboxService {

  url = 'http://localhost:8080/api/';


  allMessageHeads(id) {
    return this.http.get<Message[]>(`${this.url}messages/heads/${id}`).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(err);
      })
    );
  }

  threadMessages(id) {
    return this.http.get<Message[]>(`${this.url}messages/threads/${id}`).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(err);
      })
    );
  }

  submitReply(reply) {
    return this.http.post<Message[]>(`${this.url}messages`, reply).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(err);
      })
    );
  }

  deleteMessage(id) {
    return this.http.delete<Boolean>(`${this.url}messages/${id}`).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(err);
      })
    );
  }

  constructor(private http: HttpClient) { }
}
