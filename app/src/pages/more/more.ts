import { Component } from '@angular/core';
import { NavController } from 'ionic-angular';
import { BodyStatsPage } from '../body-stats/body-stats';
import { SettingsPage } from '../settings/settings';

@Component({
  selector: 'page-more',
  templateUrl: 'more.html'
})
export class MorePage {
  // this tells the tabs component which Pages
  // should be each tab's root Page
  constructor(public navCtrl: NavController) {
  }
  goToBodyStats(params){
    if (!params) params = {};
    this.navCtrl.push(BodyStatsPage);
  }goToSettings(params){
    if (!params) params = {};
    this.navCtrl.push(SettingsPage);
  }
}
