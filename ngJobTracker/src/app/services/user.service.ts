import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { AuthService } from './auth.service';
import { User } from '../models/user';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient, private auth: AuthService) { }

  private url = 'http://localhost:8095/api/users/';

  // private url = environment.baseUrl + 'api/todos/';
  private credentials = this.auth.getCredentials();
  delete(user: any) {
    throw new Error('Method not implemented.');
  }

  index() {
    const httpOptions = {
      headers: new HttpHeaders({
        Authorization: `Basic ${this.credentials}`,
        'X-Requested-With': 'XMLHttpRequest'
      })
    };


    return this.http.get<User[]>(this.url, httpOptions).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('todo.service.ts index error');
      })
    );
  }

  update(user: User) {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        Authorization: `Basic ${this.credentials}`,
        'X-Requested-With': 'XMLHttpRequest'
      })
    };
    console.log('We\'re in the update user.service');
    return this.http.put<User>(this.url + user.id, user, httpOptions).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('user.service.ts update error');
      })
      );

    }
    destroy(id) {
      const httpOptions = {
        headers: new HttpHeaders({
         Authorization: `Basic ${this.credentials}`,
          'X-Requested-With': 'XMLHttpRequest'
        })
      };

      return this.http.delete(this.url + id, httpOptions).pipe(
        catchError((err: any) => {
          console.log(err);
          return throwError('user.service.ts delete error');
        })
      );
    }
}
