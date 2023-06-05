import { Component, OnInit, inject } from '@angular/core';
import { Observable } from 'rxjs';
import { ImageService } from '../image.service';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit{

  images$!: Observable<any>
  imageSvc = inject(ImageService)
  

  ngOnInit(): void {
      this.images$ = this.imageSvc.getImages()
      
     
      /*this.uploadSvc.getPicture().subscribe(
        value => {
          this.createImage(value);
        }
      )*/
      
      }

  
 /* private createImage(image: Blob) {
    if (image && image.size > 0) {
      let reader = new FileReader();
      reader.onload = (e) => this.picture = e.target?.result;
      reader.readAsDataURL(image);
    }
  }*/

}
