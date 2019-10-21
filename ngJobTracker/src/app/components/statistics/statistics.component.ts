import { Component, OnInit } from '@angular/core';
import { ChartOptions, ChartType, ChartDataSets } from 'chart.js';
// import * as pluginDataLabels from 'chartjs-plugin-datalabels';
import { Label } from 'ng2-charts';
import { StudentService } from 'src/app/services/student.service';
import { Student } from 'src/app/models/student';
import { ApplicationService } from 'src/app/services/application.service';
import { Application } from 'src/app/models/application';
import { Observable } from 'rxjs';
import { Progress } from 'src/app/models/progress';
import { ProgressService } from 'src/app/services/progress.service';


@Component({
  selector: 'app-statistics',
  templateUrl: './statistics.component.html',
  styleUrls: ['./statistics.component.css']
})
export class StatisticsComponent implements OnInit {
  public barChartOptions: ChartOptions = {
    responsive: true,
    // We use these empty structures as placeholders for dynamic theming.
    scales: { xAxes: [{}], yAxes: [{
      display: true,
      ticks: {
          beginAtZero: true   // minimum value will be 0.
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
  public barChartLabels: Label[] = ['Not Applied', 'Applied', 'Recieved Response', 'Phone Interview', 'In-Person Interview', 'Recived Offer', 'Hired'];
  public barChartType: ChartType = 'bar';
  public barChartLegend = true;
  // public barChartPlugins = [pluginDataLabels];

  public barChartData: ChartDataSets[] = [
    { data: [5, 1, 1, 1, 1, 1, 0, 0], label: 'Applications' },
    { data: [10, 2, 3, 9, 4, 6, 0, 6], label: 'Series B' }
  ];
  student: Student = null;
  appArray: Application[] = [];
  progressArray: Progress[] = null;
  progress: Progress = null;

  // tslint:disable-next-line: max-line-length
  constructor(private studentService: StudentService, private applicationService: ApplicationService, private progressService: ProgressService) { }

  ngOnInit() {
    this.getStudent();
    this.getApplications();
    console.log(this.appArray);

  }

  // events
  public chartClicked({ event, active }: { event: MouseEvent, active: {}[] }): void {
    console.log(event, active);
  }

  public chartHovered({ event, active }: { event: MouseEvent, active: {}[] }): void {
    console.log(event, active);
  }

  // loadPokemon() {
  //   this.pokeService.index().subscribe(
  //     data => {this.pokemons = data; },
  //     err => {console.log('Error in loadPokemon'); }
  //   );
  // }

  public getStudent() {
    this.studentService.getStudentByUsername().subscribe(
      data => {
        this.student = data;
      },
      err => {
        console.log('Error seeding Graph Data');
      }
      );
    }

    public getApplications() {
      this.applicationService.index(this.student.id).subscribe (
        data => {
          this.appArray = data;
        },
        err => { console.log('Error in getApplications');
        }
       );
      }

    public getProgressArray(studentId: number, appId: number){
      return this.progressService.getApplicationProgresses(studentId, appId);
    }
    public testFillGraph() {
      const data = [1, 1, 1, 1, 1, 1, 1, 1, 1];
      //  const data = [];

      this.barChartData[0].data = data;
    }

  }
