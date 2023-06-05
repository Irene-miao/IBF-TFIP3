import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-pict-carousel',
  templateUrl: './pict-carousel.component.html',
  styleUrls: ['./pict-carousel.component.css']
})
export class PictCarouselComponent {

  @Input()
  title = 'My Gallery'

  @Input()
  pictures: string[] = []
}
