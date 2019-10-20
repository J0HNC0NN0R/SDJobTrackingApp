import { StudentService } from './../../services/student.service';
import { Component, OnInit } from '@angular/core';
import { Student } from 'src/app/models/student';
import { ThrowStmt } from '@angular/compiler';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit {
  student: Student = null;

  constructor(private studentService: StudentService) { }

  ngOnInit() {
    this.refreshApps();
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
