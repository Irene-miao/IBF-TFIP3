import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {WebcamModule} from 'ngx-webcam';
import { AppComponent } from './app.component';
import { MainComponent } from './main/main.component';
import { UploadComponent } from './upload/upload.component';
import { ReactiveFormsModule } from '@angular/forms';
import {RouterModule, Routes} from '@angular/router';
import { CameraService } from './camera.service';
import { HttpClientModule } from '@angular/common/http';


const appRoute: Routes = [
  { path: '', component: MainComponent, title: 'Main' },
  { path: 'upload', component: UploadComponent, title: 'Upload' },
  { path: '**', redirectTo: '/', pathMatch: 'full' }
]



@NgModule({
  declarations: [
    AppComponent,
    MainComponent,
    UploadComponent
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    RouterModule.forRoot(appRoute),
    WebcamModule,
    HttpClientModule
  ],
  providers: [CameraService],
  bootstrap: [AppComponent]
})
export class AppModule { }
