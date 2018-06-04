import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from './models/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  url = 'http://localhost:8080/api';

  findUserById() {
    return this.http.get<User>(this.url);
  }

  constructor(private http: HttpClient) { }


}
