import { ApplicationForm } from './../../models/application-form';
import { NgForm } from '@angular/forms';
import { ApplicationService } from './../../services/application.service';
import { Component, OnInit, AfterViewInit, ViewChild, Input, EventEmitter, Output } from '@angular/core';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';
import { Student } from 'src/app/models/student';
import { Application } from 'src/app/models/application';
import { Cohort } from 'src/app/models/cohort';
import { StudentService } from 'src/app/services/student.service';
import { CohortComponent } from '../cohort/cohort.component';

@Component({
  selector: 'app-cohort-update',
  templateUrl: './cohort-update.component.html',
  styleUrls: ['./cohort-update.component.css']
})

export class CohortUpdateComponent implements OnInit, AfterViewInit {
  @Output() childEvent = new EventEmitter();
  @ViewChild('content', {static: false}) form;
  private content;
  update: ApplicationForm = null;
  @Input() cohort: Cohort;
  private appId: number;

  constructor(private modalService: NgbModal, private studentService: StudentService) {}

  ngAfterViewInit(): void {
    this.content = this.form;
  }

  ngOnInit() {
  }

  refresh() {
      this.childEvent.emit();
  }

  updateCohort() {
    console.log(this.cohort);
    this.studentService.updateCohort(this.cohort).subscribe(
      data => {
        this.refresh();

        console.log('Cohort Component updateCohort() cohort updated ');
      },
      err => {
        console.error(
          'Cohort Component updateCohort() cohort update failed'
        );
        console.error(err);
      }
    );
  }

  open() {
      this.modalService.open(this.content);
  }

}

