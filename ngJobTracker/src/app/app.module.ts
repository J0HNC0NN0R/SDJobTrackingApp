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
import { HardmodeCountdownComponent } from './components/hardmode-countdown/hardmode-countdown.component';
import { CohortCreateComponent } from './components/cohort-create/cohort-create.component';
import { CohortProfileComponent } from './components/cohort-profile/cohort-profile.component';
import { MessagingComponent } from './components/messaging/messaging.component';
import { StatisticsComponent } from './components/statistics/statistics.component';
import { ApplicationStatusComponent } from './components/application-status/application-status.component';
import { StatisticsService } from './services/statistics.service';

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
    HardmodeCountdownComponent,
    CohortCreateComponent,
    CohortProfileComponent,
    MessagingComponent,
    StatisticsComponent,
    ApplicationStatusComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [StatisticsService],
  bootstrap: [AppComponent]
})
export class AppModule { }
