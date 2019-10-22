import { CohortComponent } from './../cohort/cohort.component';
import { StudentService } from './../../services/student.service';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Cohort } from 'src/app/models/cohort';

@Component({
  selector: 'app-cohort-create',
  templateUrl: './cohort-create.component.html',
  styleUrls: ['./cohort-create.component.css']
})
export class CohortCreateComponent implements OnInit {
  showAddForm: boolean;
  showEditForm: boolean;
  cohorts: Cohort[] = [];
  cohort: Cohort;
  constructor(private service: StudentService) {}

  ngOnInit() {
    this.populateCohorts();
  }

  createCohort(form: NgForm) {
    console.log(form.value);
    this.service.addCohort(form.value).subscribe(
      data => {
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

  populateCohorts() {
    this.service.cohortsIndex().subscribe(
      lifeIsGood => {
        // console.log('Cohorts Loaded');
        this.cohorts = lifeIsGood;
        console.log(typeof(this.cohorts));
        console.log(this.cohorts);
      },
      whenThingsGoBad => {
        console.error('cohort create populateCohorts() Error');
      }
    );
  }
}
