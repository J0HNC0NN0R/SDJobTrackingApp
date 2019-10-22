import { User } from './user';
import { Cohort } from './cohort';
import { StudentAddress } from './student-address';
import { Application } from './application';

export class Student {
  id: number;
  cohort: Cohort;
  cohortId: number;
  user: User;
  firstName: string;
  lastName: string;
  email: string;
  githubUsername: string;
  vettec: boolean;
  gibill: boolean;
  employed: boolean;
  accepted: boolean;
  depositPaid: boolean;
  needsLoanerLaptop: boolean;
  educationLevel: string;
  openToRelocation: boolean;
  clearance: string;
  events: Event[];
  address: StudentAddress[];
  applications: Application[];
  progCheck;

  constructor(
    id?: number,
    cohort?: Cohort,
    cohortId?: number,
    user?: User,
    firstName?: string,
    lastName?: string,
    email?: string,
    githubUsername?: string,
    vettec?: boolean,
    gibill?: boolean,
    employed?: boolean,
    accepted?: boolean,
    depositPaid?: boolean,
    needsLoanerLaptop?: boolean,
    educationLevel?: string,
    openToRelocation?: boolean,
    clearance?: string,
    events?: Event[],
    address?: StudentAddress[],
    applications?: Application[]
  ) {
    this.id = id;
    this.cohort = cohort;
    this.cohortId = cohortId;
    this.user = user;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.githubUsername = githubUsername;
    this.vettec = vettec;
    this.gibill = gibill;
    this.employed = employed;
    this.accepted = accepted;
    this.depositPaid = depositPaid;
    this.needsLoanerLaptop = needsLoanerLaptop;
    this.educationLevel = educationLevel;
    this.openToRelocation = openToRelocation;
    this.clearance = clearance;
    this.events = events;
    this.address = address;
    this.applications = applications;
    this.progCheck = this.setAppProgress();
  }

  setAppProgress() {
    const today = new Date();
    // @ts-ignore
    const todayM = Date.parse(today);
    const weekM = todayM - 604800000;
    let appCount = 0;

    this.applications.forEach(app => {
    // @ts-ignore
      const appDate = Date.parse(app.progress[0].updated);
      if (appDate >= weekM) {
       appCount++;
      }
    });
    return appCount;
  }

}
