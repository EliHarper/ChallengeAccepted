import { AuthService } from './../auth.service';
import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user';
import { UserService } from '../user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  createdUser: User;
  usernameTaken = false;

  register() {
    const jsonString = JSON.stringify(this.createdUser);

    this.authService.register(this.createdUser).subscribe(
      data => {
        console.log(data);
        console.log(this.createdUser.username);
        console.log(this.createdUser.password);

        // this.authService.login(this.createdUser.username, this.createdUser.password);
        this.router.navigateByUrl('/home');
      },
      error => { console.log(error),
                this.usernameTaken = true; }
    );
  }

  constructor(private userService: UserService,
              private authService: AuthService,
              private router: Router) { }

  ngOnInit() {
    this.createdUser = new User();
  }

}
