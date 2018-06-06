import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user';
import { UserService } from '../user.service';

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

    this.userService.registerUser(jsonString).subscribe(
      data => this.userService.login(data),
      error => { console.log(error),
                this.usernameTaken = true; }
    );
  }

  constructor(private userService: UserService) { }

  ngOnInit() {
    this.createdUser = new User();
  }

}
