import { catchError, tap } from 'rxjs/operators';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { throwError } from 'rxjs';
import { Student } from '../models/student';
import { identifierModuleUrl } from '@angular/compiler';

@Injectable({
  providedIn: 'root'
})

export class AuthService {
  private baseUrl = 'http://localhost:8095/';
  logoutSuccess: boolean;
  role: any;

  constructor(private http: HttpClient /*, private todoService: TodoService*/) { }

  login(username, password) {
    // Make credentials

    const credentials = this.generateBasicAuthCredentials(username, password);
    // Send credentials as Authorization header (this is spring security convention for basic auth)
    const httpOptions = {
      headers: new HttpHeaders({
        Authorization: `Basic ${credentials}`,
        'X-Requested-With': 'XMLHttpRequest'
      })
    };

    // create request to authenticate credentials
    return this.http
      .get(this.baseUrl + 'authenticate', httpOptions)
      .pipe(
        tap((res) => {
          this.role = res;
          localStorage.setItem('credentials' , credentials);
          localStorage.setItem('username' , username);
          localStorage.setItem('role', this.role.authorities[0].authority );
          return res;
        }),
        catchError((err: any) => {
          console.log(err);
          return throwError('AuthService.login(): Error logging in.');
        })
        );
  }

  registerAdmin(admin) {
    // create request to register a new account
    return this.http.post(this.baseUrl + 'register', admin)
    .pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('Auth service.register(): error registering admin.');
      })
    );
  }

  logout() {
    try {
      localStorage.removeItem('credentials');
      localStorage.removeItem('username');
      localStorage.removeItem('role');
      this.logoutSuccess = true;

    } catch (error) {
      console.error('logout failure');
    }
  }

  checkLogin() {
    if (localStorage.getItem('credentials')) {
      return true;
    }
    return false;
  }

  generateBasicAuthCredentials(username, password) {
    return btoa(`${username}:${password}`);
  }

  getCredentials() {
    return localStorage.getItem('credentials');
  }

  getUsername() {
    return localStorage.getItem('username');
  }
  getRole() {
    return localStorage.getItem('role');
  }

}
