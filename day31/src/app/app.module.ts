import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { PicFrameComponent } from './components/pic-frame.component';
import { PictCarouselComponent } from './pict-carousel/pict-carousel.component';
import { NumsComponent } from './components/nums.component';

@NgModule({
  declarations: [
    AppComponent,
    PicFrameComponent,
    PictCarouselComponent,
    NumsComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
