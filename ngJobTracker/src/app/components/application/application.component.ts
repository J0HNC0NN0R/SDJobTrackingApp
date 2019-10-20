import { FormModalComponent } from './../form-modal/form-modal.component';
import { StudentService } from './../../services/student.service';
import { ApplicationService } from './../../services/application.service';
import { Component, OnInit, ViewChild, ElementRef, AfterViewInit } from '@angular/core';
import { Application } from 'src/app/models/application';
import { Student } from 'src/app/models/student';

@Component({
  selector: 'app-application',
  templateUrl: './application.component.html',
  styleUrls: ['./application.component.css']
})
export class ApplicationComponent implements OnInit, AfterViewInit {
  apps: Application[] = [];
  url: string;
  student: Student;

  constructor(private appService: ApplicationService, private stuService: StudentService) { }
    @ViewChild(FormModalComponent, {static: false}) formComp;

    ngOnInit() {
      this.stuService.getStudentByUsername().subscribe(
        data => {
        this.student = data;
        this.refreshApps();
      },

      err => console.error('Fetch student for app err: ' + err)
      );
    }

    ngAfterViewInit(): void {
    }

    refreshApps() {
      this.appService.index(this.student.id).subscribe(
      data => {
        this.apps = data;
      },

      err => console.error('Fetch application err: ' + err)
      );
  }

  updateApp(app: Application) {
    this.appService.updateApp(this.student.id, app).subscribe(
      data => {
        this.refreshApps();
      },

      err => console.error('Fetch application err: ' + err)
    );
  }

  openModalForm() {
    this.formComp.open();

  }
}
