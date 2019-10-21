import { StudentService } from './../../services/student.service';
import { Component, OnInit } from '@angular/core';
import { Student } from 'src/app/models/student';
import { ThrowStmt } from '@angular/compiler';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit {
  student: Student = null;
  role: any;

  constructor(private studentService: StudentService, private auth: AuthService) { }

  ngOnInit() {
    this.role = this.auth.getRole();
    if (this.role) {
    this.refreshApps();
    }
  }

  refreshApps() {
    this.studentService.getStudentByUsername().subscribe(
      data => {
        this.student = data;
      },

      err => console.error('Fetch student err: ' + err)
    );
  }
}
