import { Component, OnInit } from '@angular/core';

import { AuthService } from 'src/app/services/auth.service';
import { HttpHeaders, HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-application-status',
  templateUrl: './application-status.component.html',
  styleUrls: ['./application-status.component.css']
})
export class ApplicationStatusComponent implements OnInit {
  // private credentials: string;
  // private url = 'http://localhost:8095/api/students/';

  constructor(private http: HttpClient, private auth: AuthService) { }

  ngOnInit() {
  }

  // index(id: number) {
  //   this.credentials = this.auth.getCredentials();
  //   const httpOptions = {
  //     headers: new HttpHeaders({
  //       Authorization: `Basic ${this.credentials}`,
  //       'X-Requested-With': 'XMLHttpRequest'
  //     })
  //   };

  //   return this.http.get<Application[]>(this.url + id + '/applications', httpOptions)
  //     .pipe(
  //       catchError((err: any) => {
  //         console.log(err);
  //         return throwError('Failed to get list of applications');
  //       })
  //     );
  // }

}
