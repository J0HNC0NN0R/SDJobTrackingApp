export class JobPost {
  id: number;
  companyId: number;
  position: string;
  description: string;
  postURL: string;

  constructor(
    id?: number,
    companyId?: number,
    position?: string,
    description?: string,
    postURL?: string
  ) {
    this.id = id;
    this.companyId = companyId;
    this.position = position;
    this.description = description;
    this.postURL = postURL;
  }
}
