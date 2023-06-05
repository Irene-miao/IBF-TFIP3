import { Component, Input, Output } from '@angular/core';
import { Subject } from 'rxjs';

@Component({
  selector: 'app-nums',
  templateUrl: './nums.component.html',
  styleUrls: ['./nums.component.css']
})
export class NumsComponent {
 
  // Attribute
  @Input({ required: true}) value: number = 0;
 
 // Event emitted
  @Output() onSelect = new Subject<number>();



  pressed(e: any) {
    console.info(this.value);
    this.onSelect.next(this.value);
  }



  incValue(v = 1) {
    this.value += v;
  }
}
