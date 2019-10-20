import { ApplicationForm } from './../../models/application-form';
import { NgForm } from '@angular/forms';
import { ApplicationService } from './../../services/application.service';
import { Component, OnInit, AfterViewInit, ViewChild, Input, EventEmitter, Output } from '@angular/core';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';
import { Student } from 'src/app/models/student';
import { Application } from 'src/app/models/application';


@Component({
  selector: 'app-form-modal',
  templateUrl: './form-modal.component.html',
  styleUrls: ['./form-modal.component.css']
})
export class FormModalComponent implements OnInit, AfterViewInit {
  @Output() childEvent = new EventEmitter();
  @ViewChild('content', {static: false}) form;
  private content;
  update: ApplicationForm = new ApplicationForm();
  @Input() private student: Student;
  private appId: number;

  constructor(private modalService: NgbModal, private appService: ApplicationService) {}

  ngAfterViewInit(): void {
    this.content = this.form;
  }

  ngOnInit() {
  }

  refresh() {
      this.childEvent.emit();
  }

  updateApp(form: NgForm) {
    console.log(this.update);
    this.appService.updateApp(this.student.id, this.update, this.appId).subscribe(
      data => {
        this.refresh();
        this.update = new ApplicationForm();
      },

      err => console.error('Fetch application err: ' + err)
    );
  }

  open(appId: number, formData: ApplicationForm) {
    this.update = formData;
    this.appId = appId;
    this.modalService.open(this.content);
  }

}
