import { Component, Input, OnInit, inject } from '@angular/core';
import { CartService } from '../cart.service';
import { ActivatedRoute } from '@angular/router';
import { Cart } from '../models';

@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.css']
})
export class DetailComponent implements OnInit {
  // List cart details
  cartSvc = inject(CartService)
  activateRoute = inject(ActivatedRoute)

  cart$!: Promise<Cart|null>

  @Input()
  cartId!: string

  ngOnInit(): void {
      this.cart$ = this.cartSvc.getCartById(this.cartId)
  }
  
}
