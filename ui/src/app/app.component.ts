import { Component } from '@angular/core';
import {AppService} from "./app.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'ui';
  inputString: string;
  stringLength: number;
  error: any;

  constructor(private appService: AppService) {

  }

  getStringLength(str) {
    this.appService.getStringLength(str)
      .subscribe((response) => {
        this.stringLength = response.length;
      }, (err) => {
        this.error = err;
    })
  }




}
