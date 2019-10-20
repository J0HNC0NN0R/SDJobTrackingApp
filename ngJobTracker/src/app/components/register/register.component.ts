import { AuthService } from './../../services/auth.service';
import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor(private auth: AuthService) { }

  ngOnInit() {
  }

  register(form: NgForm) {
    console.log(form);
    console.log(form.value.role);

    const newUser: User = form.value;
    this.auth.register(newUser).subscribe(
        data => {
          console.log('RegisterComponent.register(): user registered.');

        },
        err => {
          console.error('RegisterComponent.register(): error registering.');
          console.error(err);
        }
      );
}
// this.auth.login(newUser.username, newUser.password).subscribe(
//   next => {
//     console.log('RegisterComponent.register()');
//   },
//   error => {
//     console.error('RegisterComponent.register(): error logging in.');
//   }
// );
}
