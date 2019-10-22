import { Progress } from './progress';
import { Company } from './company';
export class Application {
  id: number;
  userId: number;
  companyId: number;
  position: string;
  descriptionURL: string;
  interestLevel: number;
  progress: Progress[];
  company: Company;
  progressArray: string[];

  constructor(
    id?: number,
    userId?: number,
    companyId?: number,
    position?: string,
    descriptionURL?: string,
    interestLevel?: number,
    progress?: Progress[],
    company?: Company,
  ) {
    this.id = id;
    this.userId = userId;
    this.companyId = companyId;
    this.position = position;
    this.descriptionURL = descriptionURL;
    this.interestLevel = interestLevel;
    this.progress = progress;
    this.company = company;
    this.progressArray = this.setProgressArray();
  }


  setProgressArray() {
    const progArr = ['Applied', 'Phone/Video', 'In-Person', 'Offer', 'Accepted'];
    const newProg = ['', '', '', '', ''];
    let progress: Progress;

    if (this.progress.length > 0) {
      progress = this.progress[0];

      for (let i = progArr.length - 1; i >= 0; i--) {
        if (progArr[i] === progress.state) {
          newProg[i] = progArr[i];
          break;
        } else {
          newProg[i] = 'x';
        }
      }
    }

    return newProg;
  }
}
