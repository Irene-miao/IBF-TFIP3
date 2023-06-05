import { Component, ElementRef, OnInit, ViewChild, inject } from '@angular/core';
import { ImageService } from '../image.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.css']
})
export class DetailComponent implements OnInit {

  @ViewChild('imageKey')
  imageKey!: ElementRef

  imageSvc = inject(ImageService)
 
  picture: string | ArrayBuffer | null | undefined
 
  activatedRoute = inject(ActivatedRoute)
 
  
ngOnInit(): void {
    const imagePath = this.activatedRoute.snapshot.params['imagePath']
    console.warn(imagePath)

    // 
    this.imageSvc.getPicture(imagePath).subscribe(
      data => {
        this.createImage(data);
      }
    )

}


  getImage() {
    const key = this.imageKey.nativeElement.value

    // Observable
    this.imageSvc.getImage(key).subscribe(
      value => {
        this.createImage(value);
      }
      
    )
  }

  

  private createImage(image: Blob) {
    if (image && image.size > 0) {
      let reader = new FileReader();
      reader.onload = (e) => this.picture = e.target?.result;
      reader.readAsDataURL(image);
    }
  }
}
