import { AuthService } from 'src/app/services/auth.service';
import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';
import { Application } from '../models/application';
import { Student } from '../models/student';

@Injectable({
  providedIn: 'root'
})
export class StudentService {
  private credentials: string;
  private student: Student = null;
  private url = 'http://localhost:8095/api/students/';

  constructor(private http: HttpClient, private auth: AuthService) { }

  getStudentByUsername() {
    this.credentials = this.auth.getCredentials();
    const username = this.auth.getUsername();

    const httpOptions = {
      headers: new HttpHeaders({
        Authorization: `Basic ${this.credentials}`,
        'X-Requested-With': 'XMLHttpRequest'
      })
    };

    return this.http.get<Student>(this.url + username, httpOptions)
    .pipe(
      catchError((err: any) => {
        console.error(err);
        return throwError('Student get by username failed');
      })
    );
  }
}
