import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { MainComponent } from './main/main.component';
import { CartComponent } from './cart/cart.component';
import { CartService } from './cart.service';
import { HttpClientModule} from '@angular/common/http';
import { ReactiveFormsModule} from '@angular/forms';

import { ListComponent } from './list/list.component';
import { RouterModule, Routes } from '@angular/router';
import { leaveComp, loginGuard} from './utils';

import { DetailComponent } from './detail/detail.component';
import { CartRepository } from './cart.repository';


const appRoute: Routes = [
  {path:'', component: MainComponent , title: 'Main'},
  {path:'list', component: ListComponent, title: 'Title', canActivate: [ loginGuard]},
  {path:'cart/:cartId', component: DetailComponent, canActivate: [ loginGuard ]},
  {path:'cart', component: CartComponent, title: 'Cart', canActivate: [ loginGuard], canDeactivate: [ leaveComp]},
  {path:'**', redirectTo: '/', pathMatch: 'full'  }
]



@NgModule({
  declarations: [
    AppComponent,
    MainComponent,
    CartComponent,
    ListComponent,
    DetailComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    ReactiveFormsModule,
    // bindTOComponentInputs - V16
    RouterModule.forRoot(appRoute, {useHash: true, bindToComponentInputs: true})
  ],
  providers: [CartService, CartRepository],
  bootstrap: [AppComponent]
})
export class AppModule { }
