import { Component, OnInit, Inject, HostListener } from '@angular/core';
import { AuthService } from 'src/app/services/auth.service';
import { headersToString } from 'selenium-webdriver/http';
import { DOCUMENT } from '@angular/common';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css'],

})

export class HeaderComponent implements OnInit {

  windowScrolled: boolean;

  constructor(private auth: AuthService, @Inject(DOCUMENT) private document: Document) { }

  ngOnInit() {

  }

  checkLogin() {
    // console.log('Header Component- checkLogin()');
    // console.log(this.auth.checkLogin());
    return this.auth.checkLogin();
  }

  @HostListener('window:scroll', [])
  onWindowScroll() {
    if (window.pageYOffset || this.document.documentElement.scrollTop > 100) {
      this.windowScrolled = true;
    } else if (this.windowScrolled && window.pageYOffset || document.documentElement.scrollTop || document.body.scrollTop < 10) {
      this.windowScrolled = false;
    }
  }

  scrollToTop() {
    (function smoothscroll() {
      const currentScroll = document.documentElement.scrollTop || document.body.scrollTop;
      if (currentScroll > 0) {
        window.requestAnimationFrame(smoothscroll);
        window.scrollTo(0, currentScroll - (currentScroll / 8));
      }
    })();

  }

}
