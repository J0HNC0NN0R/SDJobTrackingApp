import { catchError } from 'rxjs/operators';
import { AuthService } from './auth.service';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Student } from '../models/student';
import { throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StudentService {
  private baseUrl = 'http://localhost:8095/';

  constructor(private http: HttpClient, private authService: AuthService) { }


  getStudent(){
    const credentials = this.authService.getCredentials();
    const username = this.authService.getUsername();
    const httpOptions = {
      headers: new HttpHeaders({

       'Authorization': `Basic ${credentials}`,
        'X-Requested-With': 'XMLHttpRequest'
      })
    };
    return this.http.get<Student>(this.baseUrl + 'api/students/' + username, httpOptions)
    .pipe(
      catchError((err: any) => {
        console.error(err);
        return throwError('Student get by id failed');
      })
    );


  }

} // end Service
