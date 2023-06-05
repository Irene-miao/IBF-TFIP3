import { Component, inject } from '@angular/core';
import { JokeService } from './joke.service';
import { ApiResponse } from './models';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
 
  jokeSvc = inject(JokeService)

  resp$!: Observable<ApiResponse>

 
  pressed() {
    this.resp$ = this.jokeSvc.getJokeAsObservable()
  }
  
  
}
