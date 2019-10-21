import { Cohort } from './cohort';
import { StudentAddress } from './student-address';
import { Application } from './application';

export class Student {
  id: number;
  cohort: Cohort;
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

  constructor(
    id?: number,
    cohort?: Cohort,
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
    address?: StudentAddress[]
  ) {
    this.id = id;
    this.cohort = cohort;
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
  }
}
