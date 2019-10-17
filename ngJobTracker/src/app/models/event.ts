export class Event {
  id: number;
  studentId: number;
  title: string;
  description: string;
  location: string;
  date: Date;

  constructor(
    id?: number,
    studentId?: number,
    title?: string,
    description?: string,
    location?: string,
    date?: Date
  ) {
    this.id = id;
    this.studentId = studentId;
    this.title = title;
    this.description = description;
    this.location = location;
    this.date = date;
  }
}
