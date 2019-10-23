import { Cohort } from './models/cohort';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AdminComponent } from './components/admin/admin.component';
import { StudentComponent } from './components/student/student.component';
import { LoginComponent } from './components/login/login.component';
import { LogoutComponent } from './components/logout/logout.component';
import { RegisterComponent } from './components/register/register.component';
import { HeaderComponent } from './components/header/header.component';
import { StudentProfileComponent } from './components/student-profile/student-profile.component';
import { AdminProfileComponent } from './components/admin-profile/admin-profile.component';
import { ApplicationComponent } from './components/application/application.component';
import { CohortProfileComponent } from './components/cohort-profile/cohort-profile.component';
import { MessagingComponent } from './components/messaging/messaging.component';
import { StatisticsComponent } from './components/statistics/statistics.component';
import { ApplicationStatusComponent } from './components/application-status/application-status.component';
import { ChartsModule } from 'ng2-charts';

import { FormModalComponent } from './components/form-modal/form-modal.component';
import { NgbModalModule } from '@ng-bootstrap/ng-bootstrap';

import { CohortComponent } from './components/cohort/cohort.component';
import { JobListingComponent } from './components/job-listing/job-listing.component';
import { StudentModalComponent } from './components/student-modal/student-modal.component';

import { AdminStatisticsComponent } from './components/admin-statistics/admin-statistics.component';

import { CohortUpdateComponent } from './components/cohort-update/cohort-update.component';


@NgModule({
  declarations: [
    AppComponent,
    AdminComponent,
    StudentComponent,
    LoginComponent,
    LogoutComponent,
    RegisterComponent,
    HeaderComponent,
    StudentProfileComponent,
    AdminProfileComponent,
    ApplicationComponent,
    CohortProfileComponent,
    MessagingComponent,
    StatisticsComponent,
    ApplicationStatusComponent,
    FormModalComponent,
    CohortComponent,
    JobListingComponent,
    StudentModalComponent,
    AdminStatisticsComponent,
    CohortUpdateComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    NgbModalModule,
    HttpClientModule,
    ChartsModule

  ],
  exports: [
    FormModalComponent
  ],
  providers: [],
  bootstrap: [AppComponent],
  entryComponents: [
    FormModalComponent
  ]
})
export class AppModule { }
