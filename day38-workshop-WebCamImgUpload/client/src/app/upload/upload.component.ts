import { Component, ElementRef, OnInit, ViewChild, inject } from '@angular/core';
import { CameraService } from '../camera.service';
import { Router } from '@angular/router';
import { dataURLtoFile } from '../utils';
import { firstValueFrom } from 'rxjs';



@Component({
  selector: 'app-upload',
  templateUrl: './upload.component.html',
  styleUrls: ['./upload.component.css']
})
export class UploadComponent implements OnInit {


  @ViewChild('comment')
comments!: ElementRef;


  photo = ""

  cameraSvc = inject(CameraService)
  router = inject(Router)

  
  ngOnInit() {
    if (!this.cameraSvc.photo) {
      this.router.navigate(['/'])
      return
    }

    this.photo = this.cameraSvc.photo
  }

  upload() {
    
    const f = dataURLtoFile(this.photo)
    firstValueFrom(this.cameraSvc.upload(f, this.comments.nativeElement.value))
    .then(() => alert('uploaded'))
    .catch(error => alert(JSON.stringify(error)))
  }
  
}
