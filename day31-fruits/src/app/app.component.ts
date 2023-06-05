import { Component } from '@angular/core';
import { CartAction, CartItem } from './cart.model';



@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  cart: CartItem[] = [];

  itemSelected(action: CartAction){
    
    let i = this.cart.find(item => item.item == action.item)

    //Add
    if (action.quantity > 0){
      if (!i){
        this.cart.push({...action} as CartItem)
      } else {
        i.quantity += action.quantity
      }
    }
console.info('cart: ' + this.cart)
  }


}
