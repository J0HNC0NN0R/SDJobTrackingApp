import { StudentModalComponent } from './../student-modal/student-modal.component';
import { FormsModule, NgForm } from '@angular/forms';
import { StudentAddress } from './../../models/student-address';
import { AuthService } from 'src/app/services/auth.service';
import { Student } from './../../models/student';
​
import { StudentService } from './../../services/student.service';
import { Component, OnInit, ViewChild } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { User } from 'src/app/models/user';
import { FormModalComponent } from '../form-modal/form-modal.component';


@Component({
  selector: 'app-student-profile',
  templateUrl: './student-profile.component.html',
  styleUrls: ['./student-profile.component.css']
})
export class StudentProfileComponent implements OnInit {
​
  editStudent: Student = null;
  // upStudent: Student = null;
  student: Student ;

  editAddress: StudentAddress = new StudentAddress();
  // upAddress: StudentAddress = null;
  // newAddress: StudentAddress = null;
  // showAddressForm = false;
  editUser: User = null;
  // setUser: User = null;
  // updateUser: User = null;
  mainAddress: StudentAddress = null;


  constructor(private studentService: StudentService, private authService: AuthService, private userService: UserService) { }
  @ViewChild(StudentModalComponent, {static: false}) formComp;

  ngOnInit() {
    this.reload();
    this.editUser = this.editStudent.user;
    console.log(this.editStudent);

  }

//   updateStudent() {
//     console.log('edit student' + this.upStudent);
// ​
//     this.studentService.update(this.upStudent).subscribe(
//       data => {
//         this.reload();
//       },
//       err => {
//         console.error('Error updating student' + err);
// ​
//       }
//     );
//   }
​



  reload() {
    console.log('in reload');

    this.studentService.getStudentByUsername().subscribe(
      data => {
        console.log('return to reload');

        this.editStudent = data;
        this.mainAddress = this.editStudent.address[0];
        this.editUser = this.editStudent.user;
      },
      err => {
        console.error('Error in getStudent ' + err);
      }

    );
  }
  // cancelEditAddress() {
  //   this.upAddress = null;
  // }
  // setAddress(id) {
  //   // tslint:disable-next-line: prefer-for-of
  //   for (let i = 0; i < this.editStudent.address.length; i++) {
  //     if (this.editStudent.address[i].id === id) {
  //     this.upAddress = this.editStudent.address[i];
  //     }
  //   }
  // }
// updateAddress() {
//   this.studentService.updateAddress(this.upAddress, this.editStudent).subscribe(
//     data => {
//       this.reload();
//       this.cancelEditAddress();
//     },
//     err => {
//       console.error('Error updating address' + err);

//     }
//   );
// }
// addressForm() {
// this.showAddressForm = true;
// }
// cancelAddressForm() {
//   this.showAddressForm = false;
// }
// addAddress(form: NgForm ) {
//   console.log(form.value);

//   this.studentService.addAddress(form.value, this.editStudent).subscribe(
//     data => {
//       this.reload();
//     },
//     err => {
//       console.error('Error adding address' + err);

//     }
//   );
// }
// setEditUserName() {
// this.setUser = this.editStudent.user;
// }
// cancelPassForm() {
//   this.setUser = null;
// }

// updateUserPass(form: NgForm) {
//   console.log(form.value);

//   this.updateUser = form.value;

//   this.setUser.username = this.updateUser.username;
//   this.setUser.password = this.updateUser.password;
//   console.log(this.setUser.username);
//   console.log(this.setUser.id);

//   this.userService.update(this.setUser).subscribe(
//   data => {
//     this.reload();
//   },
//   err => {
//     console.error('Error updating username and password' + err);
//   }
// );

// }
openModalForm() {
  this.formComp.open();
}


}
