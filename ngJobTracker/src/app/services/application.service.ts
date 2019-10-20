import { Application } from './../models/application';
import { AuthService } from 'src/app/services/auth.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ApplicationService {
  private credentials: string;
  private url = 'http://localhost:8095/api/students/';

  constructor(private http: HttpClient, private auth: AuthService) { }

  index(id: number) {
    this.credentials = this.auth.getCredentials();
    const httpOptions = {
      headers: new HttpHeaders({
        Authorization: `Basic ${this.credentials}`,
        'X-Requested-With': 'XMLHttpRequest'
      })
    };

    return this.http.get<Application[]>(this.url + id + '/applications', httpOptions)
      .pipe(
        catchError((err: any) => {
          console.log(err);
          return throwError('Failed to get list of applications');
        })
      );
  }
}
