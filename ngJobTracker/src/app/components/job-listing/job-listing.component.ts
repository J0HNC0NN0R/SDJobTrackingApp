import { ApplicationService } from './../../services/application.service';
import { JobPost } from './../../models/job-post';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-job-listing',
  templateUrl: './job-listing.component.html',
  styleUrls: ['./job-listing.component.css']
})
export class JobListingComponent implements OnInit {
  jobList: JobPost[] = [];

  constructor(private appService: ApplicationService) { }

  ngOnInit() {
    this.getJobPosts();
  }

  getJobPosts() {
    this.appService.getJobs().subscribe(
      data => {
        this.jobList = data;
      },

      err => console.error('Get list of jobs err: ' + err)
    );
  }
}
