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
    this.checkRole();
    if (this.role) {
    this.refreshApps();
    }
  }

  refreshApps() {
    this.studentService.getStudentByUsername().subscribe(
      data => {
        this.student = new Student(data.id, data.cohort, data.cohortId, data.user, data.firstName, data.lastName,
          data.email, data.githubUsername, data.vettec, data.gibill, data.employed, data.accepted,
          data.depositPaid, data.needsLoanerLaptop, data.educationLevel, data.openToRelocation, data.clearance,
          data.events, data.address, data.applications);
      },

      err => console.error('Fetch student err: ' + err)
    );
  }
  checkRole() {
    return this.role = this.auth.getRole();
  }
}
