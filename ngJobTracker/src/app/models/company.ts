import { CompanyLocation } from './company-location';
export class Company {
  id: number;
  name: string;
  siteURL: string;
  companyLocations: CompanyLocation[];

  constructor(
    id?: number,
    name?: string,
    siteURL?: string,
    companyLocations?: CompanyLocation[]
    ) {
    this.id = id;
    this.name = name;
    this.siteURL = siteURL;
    this.companyLocations = companyLocations;
  }
}
