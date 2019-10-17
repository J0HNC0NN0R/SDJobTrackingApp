export class Progress {
  id: number;
  applicationId: number;
  state: string;
  updated: Date;

  constructor(
    id?: number,
    applicationId?: number,
    state?: string,
    updated?: Date
  ) {
    this.id = id,
    this.applicationId = applicationId;
    this.state = state;
    this.updated = updated;
  }
}
