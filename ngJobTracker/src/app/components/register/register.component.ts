import { AuthService } from './../../services/auth.service';
import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user';
import { NgForm } from '@angular/forms';
import { StudentService } from 'src/app/services/student.service';
import { Student } from 'src/app/models/student';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  constructor(private authA: AuthService, private authS: StudentService ) {}

  ngOnInit() {}

  registerAdmin(form: NgForm) {
    // console.log(form);
    // console.log(form.value.role);

    const newUser: User = form.value;
    this.authA.registerAdmin(newUser).subscribe(
      data => {
        console.log('RegisterComponent.registerAdmin(): admin registered.');
      },
      err => {
        console.error('RegisterComponent.registerAdmin(): error registering.');
        console.error(err);
      }
    );
  }
  registerStudent(form: NgForm) {
    if (form !== null) {
      if (!form.value.depositPaid) {
          form.value.depositPaid = false;
      }
      if (!form.value.accepted) {
        form.value.accepted = false;
      }
      if (!form.value.gibill) {
        form.value.gibill = false;
      }
      if (!form.value.vettec) {
        form.value.vettec = false;
      }
      if (!form.value.needsLoanerLaptop)  {
        form.value.needsLoanerLaptop = false;
      }
      if (!form.value.openToRelocation) {
        form.value.openToRelocation = false;
      }
      if (!form.value.employed) {
        form.value.employed = false;
      }
    }

    const newStudent: Student = form.value;
    console.log(newStudent);

    this.authS.registerStudent(newStudent, form.value.cohortId).subscribe(
      data => {
        console.log('RegisterComponent.registerStudent(): student registered.');
      },
      err => {
        console.error('RegisterComponent.registerStudent(): error registering.');
      }
    );
  }
}
