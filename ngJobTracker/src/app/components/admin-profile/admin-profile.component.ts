import { AuthService } from './../../services/auth.service';
import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { User } from 'src/app/models/user';

@Component({
  selector: 'app-admin-profile',
  templateUrl: './admin-profile.component.html',
  styleUrls: ['./admin-profile.component.css']
})
export class AdminProfileComponent implements OnInit {
  users: User [] = [];
  constructor(private auth: AuthService, private user: UserService) { }

  ngOnInit() {
    this.reload();
  }
  reload() {
    // console.log(this.users);
    this.user.index().subscribe(
      lifeIsGood => {
        // console.log(this.users);

        this.users = lifeIsGood;
      },
      whenThingsGoBad => {
        // console.log(this.users);
        console.error('error in admin-list.component.ts');
      }
    );
  }


  displayAdminInfo() {
   return this.user.index();
  }

  toggleEnable(user) {
    // console.log(user.enabled);
    // user.enabled = !user.enabled;
    // console.log(user.enabled);
    this.user.delete(user.id);
    // console.log(blah);
    // this.reload();
  }
}
