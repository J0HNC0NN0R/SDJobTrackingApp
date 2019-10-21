import { Student } from 'src/app/models/student';
import { Cohort } from './../../models/cohort';
import { Component, OnInit } from '@angular/core';
import { StudentService } from 'src/app/services/student.service';

@Component({
  selector: 'app-cohort',
  templateUrl: './cohort.component.html',
  styleUrls: ['./cohort.component.css']
})
export class CohortComponent implements OnInit {
  cohorts: Cohort[] = [];
  students: Student[] = [];
  date: Date;
  remainingDays: number;

  constructor(private studentService: StudentService) { }

  ngOnInit() {
    this.reload();
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
      lifeIsGood => {
        console.log('Cohorts Loaded');
        this.students = lifeIsGood;

      },
      whenThingsGoBad => {
        console.error('Countdown Component Reload() Error');

      }

    );

  }


}
