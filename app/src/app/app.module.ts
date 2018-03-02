import { NgModule, ErrorHandler } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { IonicApp, IonicModule, IonicErrorHandler } from 'ionic-angular';
import { MyApp } from './app.component';
import { ExercisesPage } from '../pages/exercises/exercises';
import { TitleSelectedMuscleGroupPage } from '../pages/title-selected-muscle-group/title-selected-muscle-group';
import { WorkoutsPage } from '../pages/workouts/workouts';
import { WorkoutsDetailsPage } from '../pages/workouts-details/workouts-details';
import { LogsPage } from '../pages/logs/logs';
import { WorkoutPlansPage } from '../pages/workout-plans/workout-plans';
import { MorePage } from '../pages/more/more';
import { BodyStatsPage } from '../pages/body-stats/body-stats';
import { SettingsPage } from '../pages/settings/settings';
import { TabsControllerPage } from '../pages/tabs-controller/tabs-controller';


import { StatusBar } from '@ionic-native/status-bar';
import { SplashScreen } from '@ionic-native/splash-screen';

@NgModule({
  declarations: [
    MyApp,
    ExercisesPage,
    TitleSelectedMuscleGroupPage,
    WorkoutsPage,
    WorkoutsDetailsPage,
    LogsPage,
    WorkoutPlansPage,
    MorePage,
    BodyStatsPage,
    SettingsPage,
    TabsControllerPage
  ],
  imports: [
    BrowserModule,
    IonicModule.forRoot(MyApp)
  ],
  bootstrap: [IonicApp],
  entryComponents: [
    MyApp,
    ExercisesPage,
    TitleSelectedMuscleGroupPage,
    WorkoutsPage,
    WorkoutsDetailsPage,
    LogsPage,
    WorkoutPlansPage,
    MorePage,
    BodyStatsPage,
    SettingsPage,
    TabsControllerPage
  ],
  providers: [
    StatusBar,
    SplashScreen,
    {provide: ErrorHandler, useClass: IonicErrorHandler}
  ]
})
export class AppModule {}