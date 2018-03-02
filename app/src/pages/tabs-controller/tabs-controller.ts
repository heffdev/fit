import { Component } from '@angular/core';
import { NavController } from 'ionic-angular';
import { BodyStatsPage } from '../body-stats/body-stats';
import { SettingsPage } from '../settings/settings';
import { ExercisesPage } from '../exercises/exercises';
import { WorkoutsPage } from '../workouts/workouts';
import { LogsPage } from '../logs/logs';
import { WorkoutPlansPage } from '../workout-plans/workout-plans';
import { MorePage } from '../more/more';

@Component({
  selector: 'page-tabs-controller',
  templateUrl: 'tabs-controller.html'
})
export class TabsControllerPage {
  // this tells the tabs component which Pages
  // should be each tab's root Page
  tab1Root: any = ExercisesPage;
  tab2Root: any = WorkoutsPage;
  tab3Root: any = LogsPage;
  tab4Root: any = WorkoutPlansPage;
  tab5Root: any = MorePage;
  constructor(public navCtrl: NavController) {
  }
  goToWorkoutPlans(params){
    if (!params) params = {};
    this.navCtrl.push(WorkoutPlansPage);
  }goToMore(params){
    if (!params) params = {};
    this.navCtrl.push(MorePage);
  }goToBodyStats(params){
    if (!params) params = {};
    this.navCtrl.push(BodyStatsPage);
  }goToSettings(params){
    if (!params) params = {};
    this.navCtrl.push(SettingsPage);
  }
}
