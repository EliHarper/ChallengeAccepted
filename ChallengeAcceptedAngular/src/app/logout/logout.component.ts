import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  logout() {
    this.authServe.logout();

    if (!this.authServe.checkLogin()) {
      this.router.navigateByUrl('/home');
    }
  }
  constructor(private authServe: AuthService,
              private router: Router) { }

  ngOnInit() {
    this.logout();
  }

}
