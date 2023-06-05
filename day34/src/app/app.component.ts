import { AfterViewInit, Component, OnDestroy, OnInit, ViewChild } from '@angular/core';
import { Observable, Subject, Subscription } from 'rxjs';
import { InputComponent } from './input/input.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit, OnDestroy, AfterViewInit{
  @ViewChild(InputComponent)
  InputComp!: InputComponent

  keyPressed$!: Observable<string>


  ngOnInit(): void{
    
  }
 
  ngOnDestroy(): void{
  
  }

  ngAfterViewInit(): void {

  }


  pressed() {
   
  }


}

