export class ApplicationNote {
  id: number;
  applicationId: number;
  title: string;
  body: string;

  constructor(
    id?: number,
    applicationId?: number,
    title?: string,
    body?: string
  ) {
    this.id = id;
    this.applicationId = applicationId;
    this.title = title;
    this.body = body;
  }
}
