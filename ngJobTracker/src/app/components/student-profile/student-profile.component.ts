import { FormsModule, NgForm } from '@angular/forms';
import { StudentAddress } from './../../models/student-address';
import { AuthService } from 'src/app/services/auth.service';
import { Student } from './../../models/student';

import { StudentService } from './../../services/student.service';
import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-student-profile',
  templateUrl: './student-profile.component.html',
  styleUrls: ['./student-profile.component.css']
})
export class StudentProfileComponent implements OnInit {

  studentProfile: Student = null;
  editStudent: Student = null;
  upStudent: Student = null;
  upAddress: StudentAddress = null;
  newAddress: StudentAddress = null;
  showAddressForm = false;



  constructor(private studentService: StudentService, private authService: AuthService) { }

  ngOnInit() {
    this.reload();
    this.editStudent = this.studentProfile;
  }



  updateStudent() {
    console.log('edit student' + this.upStudent);

    this.studentService.update(this.upStudent).subscribe(
      data => {
        this.showProfile();
      },
      err => {
        console.error('Error updating student' + err);

      }
    );
  }

  reload() {
    this.showProfile();
  }
setEditStudent(){
this.upStudent = Object.assign({}, this .editStudent);
}
cancelEditStudent(){
  this.upStudent = null;
}
  showProfile() {
    this.studentService.getStudentByUsername().subscribe(
      data => {
        this.editStudent = data;
      },
      err => {
        console.error('Error in getStudent ' + err);
      }
    );
  }
  cancelEditAddress(){
    this.upAddress = null;
  }
  setAddress(id){
    for (let i = 0; i < this.editStudent.address.length; i++) {
      if (this.editStudent.address[i].id = id) {
      this.upAddress = this.editStudent.address[i];
      }
    }
  }
updateAddress(){
  this.studentService.updateAddress(this.upAddress, this.editStudent).subscribe(
    data => {
      this.showProfile();
      this.cancelEditAddress();
    },
    err => {
      console.error('Error updating address' + err);

    }
  );
}
addressForm(){
this.showAddressForm = true;
}
cancelAddressForm(){
  this.showAddressForm = false;
}
addAddress(form: NgForm ) {
  console.log(form.value);

  this.studentService.addAddress(form.value, this.editStudent).subscribe(
    data => {
      this.showProfile();
    },
    err => {
      console.error('Error adding address' + err);

    }
  );
}

}
