import { Component, OnInit } from '@angular/core';
import { ChartOptions, ChartType, ChartDataSets } from 'chart.js';
// import * as pluginDataLabels from 'chartjs-plugin-datalabels';
import { Label } from 'ng2-charts';

@Component({
  selector: 'app-statistics',
  templateUrl: './statistics.component.html',
  styleUrls: ['./statistics.component.css']
})
export class StatisticsComponent implements OnInit {
  public barChartOptions: ChartOptions = {
    responsive: true,
    // We use these empty structures as placeholders for dynamic theming.
    scales: { xAxes: [{}], yAxes: [{}] },
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
    // { data: [28, 48, 40, 19, 86, 27, 90], label: 'Series B' }
  ];

  constructor() { }

  ngOnInit() {
    this.fillGraph();
  }

  // events
  public chartClicked({ event, active }: { event: MouseEvent, active: {}[] }): void {
    console.log(event, active);
  }

  public chartHovered({ event, active }: { event: MouseEvent, active: {}[] }): void {
    console.log(event, active);
  }

  public seedGraph() {
    const data = [15];
  }

  public fillGraph() {
    const data = [10, 10, 10, 10, 1];

    this.barChartData[0].data = data;
  }

  public randomize(): void {
    // Only Change 3 values
    const data = [
      Math.round(Math.random() * 100),
      59,
      80,
      (Math.random() * 100),
      56,
      (Math.random() * 100),
      40];
    this.barChartData[0].data = data;
  }
}
