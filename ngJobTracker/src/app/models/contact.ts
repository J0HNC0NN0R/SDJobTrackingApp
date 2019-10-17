export class Contact {
  id: number;
  applicationId: number;
  name: string;
  email: string;
  phone: number;
  position: string;

  constructor(
    id?: number,
    applicationId?: number,
    name?: string,
    email?: string,
    phone?: number,
    position?: string
  ) {
    this.id = id;
    this.applicationId = applicationId;
    this.name = name;
    this.email = email;
    this.phone = phone;
    this.position = position;
  }
}
