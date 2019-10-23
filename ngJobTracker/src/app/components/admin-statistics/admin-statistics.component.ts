import { Component, OnInit, Input } from '@angular/core';
import { Label } from 'ng2-charts';
import { ChartOptions, ChartType, ChartDataSets } from 'chart.js';
import { Student } from 'src/app/models/student';
import { Application } from 'src/app/models/application';
import { Progress } from 'src/app/models/progress';
import { StudentService } from 'src/app/services/student.service';
import { ApplicationService } from 'src/app/services/application.service';
import { ProgressService } from 'src/app/services/progress.service';
import { CohortComponent } from '../cohort/cohort.component';
// import { Cohort } from 'src/app/models/cohort';
@Component({
  selector: 'app-admin-statistics',
  templateUrl: './admin-statistics.component.html',
  styleUrls: ['./admin-statistics.component.css']
})
export class AdminStatisticsComponent implements OnInit {
  @Input() student: Student;
  public barChartOptions: ChartOptions = {
    responsive: true,
    // We use these empty structures as placeholders for dynamic theming.
    scales: { xAxes: [{}], yAxes: [{
      display: true,
      ticks: {
          beginAtZero: true,   // minimum value will be 0.
          // min: 0,
          // stepSize: 1
      }
    }] },
    plugins: {
      datalabels: {
        anchor: 'end',
        align: 'end',
      }
    }
  };
  // tslint:disable-next-line: max-line-length
  public barChartLabels: Label[] = ['Not Applied', 'Applied', 'Phone Interview', 'In-Person Interview', 'Recived Offer', 'Hired'];
  public barChartType: ChartType = 'bar';
  public barChartLegend = true;
  public countNotApplied = 0;
  public countApplied = 0;
  public countPhoneVideo = 0;
  public countInPerson = 0;
  public countOffer = 0;
  public countHired = 0;
  public barChartData: ChartDataSets[] = [
    // { data: [80, 50, 30, 1, 1, 0, 1], label: 'Goal stats' },
    { data: [], label: 'Applications' }
  ];
  appArray: Application[] = [];
  progressArray: Progress[] = [];
  progress: Progress = null;
  // tslint:disable-next-line: max-line-length
  constructor(private studentService: StudentService, private applicationService: ApplicationService, private progressService: ProgressService) { }
  ngOnInit() {
    this.getApplications();
  }
  // events
  public chartClicked({ event, active }: { event: MouseEvent, active: {}[] }): void {
    console.log(event, active);
  }
  public chartHovered({ event, active }: { event: MouseEvent, active: {}[] }): void {
    console.log(event, active);
  }
    public getApplications() {
      this.applicationService.index(this.student.id).subscribe (
        data => {
          this.appArray = data;
          // console.log(this.appArray);
          this.appArray.forEach(element => {
            console.log(element);
            if (element.progress !== null) {
              console.log(element.progress[0]);
              this.progressArray.push(element.progress[0]);
            }
            // this.getProgressArray(this.student.id, element.id);
          });
          this.fillCounts(this.progressArray);
          this.testFillGraph();
        },
        err => { console.log('Error in getApplications');
        }
       );
      }
    public fillCounts(progress: Progress[]) {
      progress.forEach(element => {
        if (element.state === 'Not Applied') {
          this.countNotApplied++;
          console.log(this.countNotApplied);
        }
        if (element.state === 'Applied') {
          this.countApplied++;
        }
        if (element.state === 'Phone/Video') {
          this.countPhoneVideo++;
        }
        if (element.state === 'In-Person') {
          this.countInPerson++;
        }
        if (element.state === 'Offer') {
          this.countOffer++;
        }
        if (element.state === 'Accepted') {
          this.countHired++;
        }
      });
    }
    public testFillGraph() {
      const data = [this.countNotApplied, this.countApplied, this.countPhoneVideo, this.countInPerson, this.countOffer, this.countHired];
      // const data = [1,1,1,1,11,1];
      this.barChartData[0].data = data;
    }
  }
