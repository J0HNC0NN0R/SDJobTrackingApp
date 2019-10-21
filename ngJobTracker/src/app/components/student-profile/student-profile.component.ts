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
  student: Student = null;

  constructor(private studentService: StudentService, private authService: AuthService) { }

  ngOnInit() {
    this.reload();
    this.editStudent = this.studentProfile;
  }

  updateStudent(editStudent) {
    console.log('edit student' + editStudent);

    this.studentService.update(editStudent).subscribe(
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

}
