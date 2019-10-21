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
  isUpdate = false;
  update: ApplicationForm = null;
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
    this.appService.updateApp(this.student.id, this.update, this.appId).subscribe(
      data => {
        this.refresh();
        this.update = null;
      },

      err => console.error('Fetch application err: ' + err)
    );
  }

  createApp() {
    this.appService.createApp(this.student.id, this.update).subscribe(
      data => {
        this.refresh();
      },

      err => console.error('Create application err: ' + err)
    );
  }

  open(appId?: number, formData?: ApplicationForm) {
    if (appId) {
      this.isUpdate = true;
      this.update = formData;
      this.appId = appId;
      this.modalService.open(this.content);
    } else {
      this.update = new ApplicationForm();
      this.isUpdate = false;
      this.modalService.open(this.content);
    }
  }

}
