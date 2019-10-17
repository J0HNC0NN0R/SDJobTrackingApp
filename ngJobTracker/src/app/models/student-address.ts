export class StudentAddress {
  id: number;
  studentId: number;
  street: string;
  city: string;
  state: string;
  zipcode: string;
  phone: string;
  addressType: string;

  constructor(
    id?: number,
    studentId?: number,
    street?: string,
    city?: string,
    state?: string,
    zipcode?: string,
    phone?: string,
    addressType?: string,
  ) {
    this.id = id;
    this.studentId = studentId;
    this.street = street;
    this.city = city;
    this.state = state;
    this.zipcode = zipcode;
    this.phone = phone;
    this.addressType = addressType;
  }
}
