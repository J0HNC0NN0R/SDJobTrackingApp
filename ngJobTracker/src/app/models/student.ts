export class Student {
  id: number;
  studentId: number;
  cohortId: number;
  firstName: string;
  lastName: string;
  email: string;
  githubUsername: string;
  isVettec: boolean;
  isGIBill: boolean;
  isEmployed: boolean;
  isAccepted: boolean;
  depositPaid: boolean;
  needsLoanerLaptop: boolean;
  educationLevel: string;
  openToRelocation: boolean;
  clearance: string;

  constructor(
    id?: number,
    studentId?: number,
    cohortId?: number,
    firstName?: string,
    lastName?: string,
    email?: string,
    githubUsername?: string,
    isVettec?: boolean,
    isGIBill?: boolean,
    isEmployed?: boolean,
    isAccepted?: boolean,
    depositPaid?: boolean,
    needsLoanerLaptop?: boolean,
    educationLevel?: string,
    openToRelocation?: boolean,
    clearance?: string
  ) {
    this.id = id;
    this.studentId = studentId;
    this.cohortId = cohortId;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.githubUsername = githubUsername;
    this.isVettec = isVettec;
    this.isGIBill = isGIBill;
    this.isEmployed = isEmployed;
    this.isAccepted = isAccepted;
    this.depositPaid = depositPaid;
    this.needsLoanerLaptop = needsLoanerLaptop;
    this.educationLevel = educationLevel;
    this.openToRelocation = openToRelocation;
    this.clearance = clearance;
  }
}
