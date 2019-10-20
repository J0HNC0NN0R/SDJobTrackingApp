import { Component, OnInit, AfterViewInit, ViewChild } from '@angular/core';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';


@Component({
  selector: 'app-form-modal',
  templateUrl: './form-modal.component.html',
  styleUrls: ['./form-modal.component.css']
})
export class FormModalComponent implements OnInit, AfterViewInit {
  @ViewChild('content', {static: false}) form;
  private content;

  constructor(private modalService: NgbModal) {}

  ngAfterViewInit(): void {
    this.content = this.form;
  }

  ngOnInit() {
  }

  open() {
    this.modalService.open(this.content);
  }

}
