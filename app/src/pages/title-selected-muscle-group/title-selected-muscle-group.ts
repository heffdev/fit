import { Component } from '@angular/core';
import { NavController } from 'ionic-angular';

@Component({
  selector: 'page-title-selected-muscle-group',
  templateUrl: 'title-selected-muscle-group.html'
})
export class TitleSelectedMuscleGroupPage {
  // this tells the tabs component which Pages
  // should be each tab's root Page
  constructor(public navCtrl: NavController) {
  }
  
}
