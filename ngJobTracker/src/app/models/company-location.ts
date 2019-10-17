export class CompanyLocation {
  id: number;
  companyId: number;
  city: string;
  state: string;

  constructor(id?: number, companyId?: number, city?: string, state?: string) {
    this.id = id;
    this.companyId = companyId;
    this.city = city;
    this.state = state;
  }
}
