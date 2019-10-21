import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {
  role: any;
  constructor(private auth: AuthService) { }

  ngOnInit() {
    this.role = this.auth.getRole();
    console.log(this.role);
  }


}
