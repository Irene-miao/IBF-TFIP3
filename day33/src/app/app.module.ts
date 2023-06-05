import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import { MaterialModule } from './material.module';
import { ReactiveFormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ThoughtsComponent } from './thoughts/thoughts.component';


@NgModule({
  declarations: [
    AppComponent,
    ThoughtsComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
   MaterialModule, 
   ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
