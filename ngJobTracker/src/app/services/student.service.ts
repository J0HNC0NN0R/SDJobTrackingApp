import { Cohort } from './../models/cohort';
import { AuthService } from 'src/app/services/auth.service';
import { environment } from './../../environments/environment.prod';
import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class StudentService {
  private url = 'http://localhost:8095/api/';
  private cohorts = 'cohorts/';
  private credentials = this.auth.getCredentials();

  constructor(private auth: AuthService, private http: HttpClient) { }

  cohortsIndex() {
    // console.log('its Reaching cohortsIndex()!');
    const httpOptions = {
      headers: new HttpHeaders({
        Authorization: `Basic ${this.credentials}`,
        'X-Requested-With': 'XMLHttpRequest'
      })
    };

    return this.http.get<Cohort[]>(this.url + this.cohorts, httpOptions).pipe(
      catchError((err: any) => {
        console.log(err);

        return throwError('todo.service.ts index error');
      })
    );
  }
}
