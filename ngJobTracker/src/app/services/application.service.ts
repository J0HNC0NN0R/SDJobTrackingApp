import { Progress } from './../models/progress';
import { JobPost } from './../models/job-post';
import { Application } from './../models/application';
import { AuthService } from 'src/app/services/auth.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';
import { ApplicationForm } from '../models/application-form';
import { Observable } from 'rxjs';

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

  updateApp(id: number, app: ApplicationForm, appId: number) {
    this.credentials = this.auth.getCredentials();
    const httpOptions = {
      headers: new HttpHeaders({
        Authorization: `Basic ${this.credentials}`,
        'X-Requested-With': 'XMLHttpRequest'
      })
    };

    return this.http.put<Application>(this.url + id + '/applications/' + appId, app, httpOptions)
      .pipe(
        catchError((err: any) => {
          console.log(err);
          return throwError('Failed to update application');
        })
      );
  }


  createApp(id: number, app: ApplicationForm) {
    this.credentials = this.auth.getCredentials();
    const httpOptions = {
      headers: new HttpHeaders({
        Authorization: `Basic ${this.credentials}`,
        'X-Requested-With': 'XMLHttpRequest'
      })
    };

    return this.http.post<Application>(this.url + id + '/applications', app, httpOptions)
      .pipe(
        catchError((err: any) => {
          console.log(err);
          return throwError('Failed to update application');
        })
      );
  }

  getJobs() {
    const httpOptions = {
      headers: new HttpHeaders({
        'X-Requested-With': 'XMLHttpRequest'
      })
    };

    return this.http.get<JobPost[]>('http://localhost:8095/jobs', httpOptions)
      .pipe(
        catchError((err: any) => {
          console.log(err);
          return throwError('Failed to get list of jobs');
        })
      );
  }

  createProgress(sid: number, aid: number, progress: Progress) {
    this.credentials = this.auth.getCredentials();
    const httpOptions = {
      headers: new HttpHeaders({
        Authorization: `Basic ${this.credentials}`,
        'X-Requested-With': 'XMLHttpRequest'
      })
    };

    return this.http.post<Application>(this.url + sid + '/applications/' + aid + '/progress', progress, httpOptions)
      .pipe(
        catchError((err: any) => {
          console.log(err);
          return throwError('Failed to create progress');
        })
      );

  }
}
