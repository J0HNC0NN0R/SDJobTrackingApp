import { ApplicationForm } from 'src/app/models/application-form';
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
  appId: number;

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

  openModalForm(app: Application) {
    const formData = new ApplicationForm();
    formData.city = app.company.companyLocations[0].city;
    formData.state = app.company.companyLocations[0].state;
    formData.companyName = app.company.name;
    formData.descriptionURL = app.descriptionURL;
    formData.interestLevel = app.interestLevel;
    formData.position = app.position;
    formData.siteUrl = app.company.siteURL;

    this.formComp.open(app.id, formData);
  }
}
