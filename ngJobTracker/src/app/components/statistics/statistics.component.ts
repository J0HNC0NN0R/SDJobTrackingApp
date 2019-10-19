import { Component, OnInit } from '@angular/core';
import { StatisticsService } from 'src/app/services/statistics.service';
import { Chart } from 'chart.js';

@Component({
  selector: 'app-statistics',
  templateUrl: './statistics.component.html',
  styleUrls: ['./statistics.component.css']
})
export class StatisticsComponent implements OnInit {

  constructor(private stats: StatisticsService) { }

  ngOnInit() {


    this.stats.showApps().subscribe(
      // tslint:disable-next-line: no-unused-expression
      lifeIsGood => { result => console.log('working?');
    },
      listIsBad => {
        console.log('everything is on fire');
      }
      );
  }
}
