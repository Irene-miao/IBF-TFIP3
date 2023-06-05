import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { MainComponent } from './main/main.component';
import { WeatherComponent } from './weather/weather.component';
import { WeatherService } from './weather.service';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';


const appRoutes: Routes = [
  { path: '', component: MainComponent, title: 'YAWA' },
  { path: 'weather/:city', component: WeatherComponent },
  { path: '**', redirectTo: '/', pathMatch: 'full' }
]                                                         


@NgModule({
  declarations: [
    AppComponent,
    MainComponent,
    WeatherComponent
    
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [WeatherService],
  bootstrap: [AppComponent]
})
export class AppModule { }
