export class CompanyNote {
  id: number;
  studentId: number;
  companyId: number;
  title: string;
  body: string;

  constructor(
    id?: number,
    studentId?: number,
    companyId?: number,
    title?: string,
    body?: string
  ) {
    this.id = id;
    this.studentId = studentId;
    this.companyId = companyId;
    this.title = title;
    this.body = body;
  }
}
