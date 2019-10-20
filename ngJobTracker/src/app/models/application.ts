import { Progress } from './progress';
import { Company } from './company';
export class Application {
  id: number;
  userId: number;
  companyId: number;
  position: string;
  descriptionURL: string;
  interestLevel: number;
  progress: Progress;
  company: Company;

  constructor(
    id?: number,
    userId?: number,
    companyId?: number,
    position?: string,
    descriptionURL?: string,
    interestLevel?: number,
    progress?: Progress,
    company?: Company
  ) {
    this.id = id;
    this.userId = userId;
    this.companyId = companyId;
    this.position = position;
    this.descriptionURL = descriptionURL;
    this.interestLevel = interestLevel;
    this.progress = progress;
    this.company = company;
  }
}
