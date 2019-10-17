export class StudentDesiredLocation {
  id: number;
  studentId: number;
  city: string;
  state: string;

  constructor(id?: number, studentId?: number, city?: string, state?: string) {
    this.id = id;
    this.studentId = studentId;
    this.city = city;
    this.state = state;
  }
}
