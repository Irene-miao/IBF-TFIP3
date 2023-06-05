import { Component, OnInit, inject } from '@angular/core';
import { Router } from '@angular/router';
import { Subject } from 'rxjs';
import { CameraService } from '../camera.service';
import {WebcamImage} from 'ngx-webcam';


// USE THE NGX WEBCAM TO SNAP SELFIE AND HTTP POST 
@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit{


  router = inject(Router);
  
  viewWidth = 0
  viewHeight = 0

  trigger$ = new Subject<void>()
  cameraSvc = inject(CameraService)

  ngOnInit(): void {
    this.viewWidth = window.innerWidth * .5
    this.viewHeight = window.innerHeight *.5
  }

  image(image: WebcamImage) {
    console.info('>>> image: ', image)
    this.cameraSvc.photo = image.imageAsDataUrl
    this.router.navigate([ '/upload' ])
  }


  snap() {
    this.trigger$.next()
  }
}
