import { AuthService } from 'src/app/services/auth.service';
import { StudentService } from './../../services/student.service';
import { ApplicationForm } from './../../models/application-form';
import { NgForm } from '@angular/forms';
import { ApplicationService } from './../../services/application.service';
import { Component, OnInit, AfterViewInit, ViewChild, Input, EventEmitter, Output } from '@angular/core';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';
import { Student } from 'src/app/models/student';
import { Application } from 'src/app/models/application';
import { User } from 'src/app/models/user';
import { StudentAddress } from 'src/app/models/student-address';
import { UserService } from 'src/app/services/user.service';



@Component({
  selector: 'app-student-modal',
  templateUrl: './student-modal.component.html',
  styleUrls: ['./student-modal.component.css']
})
export class StudentModalComponent implements OnInit,  AfterViewInit {
  @Output() childEvent = new EventEmitter();
  @ViewChild('content', {static: false}) form;
  private content;
  isUpdate = true;
  isPassword = false;
  isAddress = false;

  update: ApplicationForm = null;
  @Input() editStudent: Student;
  @Input() editUser: User;
  @Input() editAddress: StudentAddress;
  private appId: number;

  constructor(private modalService: NgbModal, private studentService: StudentService, private userService: UserService,
              private authService: AuthService) {}

  ngAfterViewInit(): void {
    this.content = this.form;
  }

  ngOnInit() {
  }

  refresh() {
      this.childEvent.emit();
  }

  toggleAddress() {
this.isAddress = true;
this.isUpdate = false;
this.isPassword = false;
}
updateAddress() {

}
togglePass() {
  this.isPassword = true;
  this.isUpdate = false;
  this.isAddress = false;

  }
  updateStudent() {
    this.studentService.update(this.editStudent).subscribe(
      data => {
        this.refresh();

      },
      err => {
        console.error('Error updating student' + err);
​
      }
    );
  }


  open() {

    this.isPassword = false;
    this.isUpdate = true;
    this.isAddress = false;
    this.modalService.open(this.content);

  }
  createAddress() {
    console.log(this.editAddress);
    console.log(this.editStudent);
    this.studentService.addAddress(this.editAddress, this.editStudent).subscribe(
      data => {
        this.refresh();
      },
      err => {
        console.error('Error adding address' + err);

      }
    );
  }

  updatePass() {

    this.userService.update(this.editUser).subscribe(
    data => {
      console.log('password updated');
      console.log(data);
      this.refresh();
      this.authService.logout();
    },
    err => {
      console.error('Error updating username and password' + err);
    }
  );

  }
}
