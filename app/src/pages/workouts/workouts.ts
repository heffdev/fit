import { Component } from '@angular/core';
import { NavController } from 'ionic-angular';
import { WorkoutsDetailsPage } from '../workouts-details/workouts-details';

@Component({
  selector: 'page-workouts',
  templateUrl: 'workouts.html'
})
export class WorkoutsPage {
  // this tells the tabs component which Pages
  // should be each tab's root Page
  constructor(public navCtrl: NavController) {
  }
  goToWorkoutsDetails(params){
    if (!params) params = {};
    this.navCtrl.push(WorkoutsDetailsPage);
  }
}
