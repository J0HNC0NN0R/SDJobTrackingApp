import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class StatisticsService {

  constructor(private http: HttpClient) { }

  showApps() {
    // tslint:disable-next-line: max-line-length
    return this.http.get('http://localhost:8095/api/users').pipe(map(result => result));
  }
}
