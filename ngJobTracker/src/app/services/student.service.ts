import { Student } from 'src/app/models/student';
import { Cohort } from './../models/cohort';
import { AuthService } from 'src/app/services/auth.service';
import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class StudentService {
  private url = 'http://localhost:8095/api/';
  private credentials = this.auth.getCredentials();
  private student: Student = null;

  constructor(private auth: AuthService, private http: HttpClient) { }

  registerStudent(student, cid) {
    console.log(student);

    const httpOptions = {
      headers: new HttpHeaders({
        Authorization: `Basic ${this.credentials}`,
        'X-Requested-With': 'XMLHttpRequest'
      })
    };

    return this.http.post(this.url + 'cohorts/' + cid + '/students', student, httpOptions)
    .pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('Student service.registerStudent(); error registering student ');
      })
    );
  }

  cohortsIndex() {
    // console.log('its Reaching cohortsIndex()!');
    const httpOptions = {
      headers: new HttpHeaders({
        Authorization: `Basic ${this.credentials}`,
        'X-Requested-With': 'XMLHttpRequest'
      })
    };

    return this.http.get<Cohort[]>(this.url + 'cohorts/', httpOptions).pipe(
      catchError((err: any) => {
        console.log(err);

        return throwError('todo.service.ts index error');
      })
    );
  }
  getStudentByUsername() {
    const username = this.auth.getUsername();

    const httpOptions = {
      headers: new HttpHeaders({
        Authorization: `Basic ${this.credentials}`,
        'X-Requested-With': 'XMLHttpRequest'
      })
    };

    return this.http.get<Student>(this.url + 'students/' + username, httpOptions)
      .pipe(
        catchError((err: any) => {
          console.error(err);
          return throwError('Student get by username failed');
        })
      );
  }

  getStudentsByCohort(cohort: Cohort) {

    const httpOptions = {
      headers: new HttpHeaders({
        Authorization: `Basic ${this.credentials}`,
        'X-Requested-With': 'XMLHttpRequest'
      })
    };

    return this.http.get<Student[]>(this.url + 'cohorts/' + cohort.id + '/students', httpOptions).pipe(
      catchError((err: any) => {
        console.log(err);

        return throwError('students.service.ts getStudentsByCohort error');
      })
    );

  }
}
