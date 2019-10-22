import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AuthService } from './auth.service';
import { Progress } from '../models/progress';
import { catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProgressService {
  private credentials: string;
  private url = 'http://localhost:8095/api/students/';

  constructor(private http: HttpClient, private auth: AuthService) { }

        // get application progress
  // @GetMapping("students/{sid}/applications/{aid}/progress")

    public getApplicationProgresses(id: number, appId: number) {
      this.credentials = this.auth.getCredentials();
      const httpOptions = {
        headers: new HttpHeaders({
          Authorization: `Basic ${this.credentials}`,
          'X-Requested-With': 'XMLHttpRequest'
        })
      };
      return this.http.get<Progress[]>(this.url + id + '/applications/' + appId + '/progress')
        .pipe(
          catchError((err: any) => {
            console.log(err);
            return throwError('Failed to get progress');

          })
        );
        }
}
