export class JobPost {
  title: number;
  company: string;
  location: string;
  description: string;
  url: string;

  constructor(
    title?: number,
    company?: string,
    location?: string,
    description?: string,
    url?: string
  ) {
    this.title = title;
    this.company = company;
    this.location = location;
    this.description = description;
    this.url = url;
  }
}
