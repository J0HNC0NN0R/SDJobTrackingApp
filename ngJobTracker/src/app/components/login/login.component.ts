import { AuthService } from './../../services/auth.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private auth: AuthService) { }

  ngOnInit() {
  }

  login(loginForm) {
    // console.log(loginForm.value);
    this.auth
      .login(loginForm.value.username, loginForm.value.password)
      .subscribe(
        data => {
          window.location.reload();
          // console.log('loginComponenent.login(): user logged in.');
        },
        error => {
          console.error('loginComponent.login(): error logging in.');
        }
      );
  }

}
