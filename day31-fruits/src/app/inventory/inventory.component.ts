import { Component, ElementRef, OnInit, Output } from '@angular/core';
import { Subject } from 'rxjs';
import { CartAction } from '../cart.model';

@Component({
  selector: 'app-inventory',
  templateUrl: './inventory.component.html',
  styleUrls: ['./inventory.component.css']
})
export class InventoryComponent implements OnInit {
  @Output() onItemSelection = new Subject<CartAction>();

  quantity: number = 0;

  fruits: string[] = [
    'acorn_squash', 'apple', 'bell_pepper', 'blueberries', 'broccoli',
    'carrot', 'celery', 'chili_pepper', 'corn', 'eggplant', 'harold',
    'lettuce', 'mushroom', 'onion', 'potato', 'pumpkin', 'radish', 'squash',
    'strawberry', 'sugar_snap', 'tomato', 'zucchini' ]
  
   inc( i: number) {
    const action: CartAction  = {
item : this.fruits[i],
quantity: this.quantity +1
     }
    
     this.onAdd(action);
   }
  
   dec(i : number){
const action: CartAction  = {
  item: this.fruits[i],
  quantity: this.quantity -1
}
this.onAdd(action);

   }


   onAdd(action: CartAction){

    this.onItemSelection.next(action);
   }
    constructor() {
     
    }

    ngOnInit() {
        
    }
  
}
