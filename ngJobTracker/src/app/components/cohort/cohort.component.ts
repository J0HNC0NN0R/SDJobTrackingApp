import { ApplicationService } from './../../services/application.service';

import { Student } from 'src/app/models/student';
import { Cohort } from './../../models/cohort';
import { Component, OnInit, ViewChild } from '@angular/core';
import { StudentService } from 'src/app/services/student.service';
import { Application } from 'src/app/models/application';
import { NgForm } from '@angular/forms';
import { CohortUpdateComponent } from '../cohort-update/cohort-update.component';

@Component({
  selector: 'app-cohort',
  templateUrl: './cohort.component.html',
  styleUrls: ['./cohort.component.css']
})
export class CohortComponent implements OnInit {
  showCohorts: boolean;
  cohorts: Cohort[] = [];
  students: Student[] = [];
  date: Date;
  remainingDays: number;
  showStudent: Student = null;
  student: Student = null;
  upStudent: Student = null;
  apps: Application[] = [];
  setCohort: Cohort = null;
  progress: string[];
  showAddForm: boolean;
  cohort: Cohort;
  selectedCohort: Cohort;
  listStudentsBool: boolean;


  constructor(private studentService: StudentService, private appService: ApplicationService) { }
  @ViewChild(CohortUpdateComponent, {static: false}) formComp;

  ngOnInit() {
    this.progress = ['Applied', 'Phone/Video', 'In-Person', 'Offer', 'Accepted'];
    this.reload();
  }

  createCohort(form: NgForm) {
    console.log(form.value);
    this.studentService.addCohort(form.value).subscribe(
      data => {
        this.reload();
        console.log('Cohort Create Component createCohort() cohort created ');
      },
      err => {
        console.error(
          'Cohort Create Component createCohort() cohort create failed'
        );
        console.error(err);
      }
    );
  }

  reload() {
    this.studentService.cohortsIndex().subscribe(
      lifeIsGood => {
        // console.log('Cohorts Loaded');
        this.cohorts = lifeIsGood;

      },
      whenThingsGoBad => {
        console.error('Countdown Component Reload() Error');

      }

    );
  }

  deadline(cohort: Cohort) {
    this.date = new Date(cohort.endDate);
    this.date.setDate(this.date.getDate() + 180);
    // console.log(cohort.id + ' : ' + this.date);
    this.daysLeft();
    return this.date;
  }

  daysLeft() {
    // @ts-ignore
    const today = new Date();
    // @ts-ignore
    const todayM = Date.parse(today);
    // @ts-ignore
    const deadlineDateM = Date.parse(this.date);
    // @ts-ignore
    const remainingDaysM = (deadlineDateM - todayM);
    // console.log(('todayM: ' + todayM + ' | ' + ' Deadline Date: ' + deadlineDateM));
    // console.log('Remaining Days: ' + remainingDaysM / 86400000);
    return remainingDaysM / 86400000;
  }

  listStudents(cohort) {
    // var listOfStudents[] = [];
    this.studentService.getStudentsByCohort(cohort).subscribe(
      data => {
        console.log('Cohorts Loaded');

        // this.students = lifeIsGood;
        this.setCohort = cohort;
        this.listStudentsBool = true;
        this.students = [];
        data.forEach(app => {
          const stu = new Student(app.id, app.cohort, app.cohortId, app.user, app.firstName, app.lastName,
            app.email, app.githubUsername, app.vettec, app.gibill, app.employed, app.accepted,
            app.depositPaid, app.needsLoanerLaptop, app.educationLevel, app.openToRelocation, app.clearance,
            app.events, app.address, app.applications);
          this.students.push(stu);
        });
        this.clearProfile();

      },
      whenThingsGoBad => {
        console.error('Countdown Component Reload() Error');

      }

    );

  }

  clearProfile() {
this.showStudent = null;
  }
  showProfile(id: number) {
    console.log(id);
    console.log(this.students.length);

    // tslint:disable-next-line: prefer-for-of
    for (let i = 0; i < this.students.length; i++) {
      // tslint:disable-next-line: no-conditional-assignment
      if (this.students[i].id === id) {
        this.showStudent = this.students[i];
        this.refreshApps(this.showStudent);
        console.log(this.showStudent.firstName);

      }
    }

  }
  refreshApps(student) {
    this.appService.index(student.id).subscribe(
    data => {
      this.apps = [];
      data.forEach(app => {
        const newApp: Application = new Application(app.id, app.userId, app.companyId, app.position,
          app.descriptionURL, app.interestLevel, app.progress, app.company);
        this.apps.push(newApp);
      });
    },

    err => console.error('Fetch application err: ' + err)
    );
}
setEditStudent() {
  this.upStudent = Object.assign({}, this.showStudent);
  }
  cancelEditStudent() {
    this.upStudent = null;
  }
  updateStudent() {
    console.log('edit student' + this.upStudent);

    this.studentService.update(this.upStudent).subscribe(
      data => {
        console.log(this.upStudent);
        this.reload();
        this.listStudents(this.setCohort);
        this.cancelEditStudent();


      },
      err => {
        console.error('Error updating student' + err);

      }
    );
  }

  openModalForm(cohort?: Cohort) {
    this.cohort = cohort;
    this.formComp.open();
  }

}
