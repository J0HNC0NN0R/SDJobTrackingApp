import { Progress } from './../../models/progress';
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
  progress: string[];

  constructor(private appService: ApplicationService, private stuService: StudentService) { }
    @ViewChild(FormModalComponent, {static: false}) formComp;

    ngOnInit() {
      this.progress = ['Applied', 'Phone/Video', 'In-Person', 'Offer', 'Accepted'];
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

  openModalForm(app?: Application) {
    if (app) {
      const formData = new ApplicationForm();
      formData.city = app.company.companyLocations[app.company.companyLocations.length - 1].city;
      formData.state = app.company.companyLocations[app.company.companyLocations.length - 1].state;
      formData.companyName = app.company.name;
      formData.descriptionURL = app.descriptionURL;
      formData.interestLevel = app.interestLevel;
      formData.position = app.position;
      formData.siteUrl = app.company.siteURL;

      this.formComp.open(app.id, formData);
    } else {
      this.formComp.open();
    }
  }


  setProgress(prog: string, app: Application) {
    const newProg: Progress = new Progress();
    const state: string = app.progress[0].state;


    // tslint:disable-next-line: no-var-keyword
    for (var k = 0; k < this.progress.length; k++) {
      if (this.progress[k] === state) {
        break;
      }
    }

    if (typeof(this.progress[k]) === 'undefined') {
      newProg.state = this.progress[0];
    } else if (prog !== 'x' && prog !== this.progress[k]) {
      newProg.state = this.progress[k - 1];
    } else if (prog === 'x' ) {
      newProg.state = this.progress[k + 1];
    } else {
      newProg.state = this.progress[k];
    }

    this.appService.createProgress(this.student.id, app.id, newProg).subscribe(
      data => {
        this.refreshApps();
      },

      err => console.error('Fetch application err: ' + err)
      );
  }
}
