import { Cohort } from './../../models/cohort';
import { Component, OnInit } from '@angular/core';
import { StudentService } from 'src/app/services/student.service';

@Component({
  selector: 'app-hardmode-countdown',
  templateUrl: './hardmode-countdown.component.html',
  styleUrls: ['./hardmode-countdown.component.css']

})
export class HardmodeCountdownComponent implements OnInit {
  cohorts: Cohort[] = [];
  date: Date;
  remainingDays: number;
  constructor(private studentService: StudentService) { }

  ngOnInit() {
    this.reload();

  }

  deadline(cohort: Cohort) {
    this.date = new Date(cohort.endDate);
    this.date.setDate(this.date.getDate() + 180);
    console.log(cohort.id + ' : ' + this.date);
    return this.daysLeft;
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
  // var d = Date.parse("March 21, 2012");


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

}
