import { Injectable, inject } from "@angular/core";
import { HttpClient } from '@angular/common/http';
import { Observable, lastValueFrom } from "rxjs";
import { ApiResponse } from "./models";



@Injectable()
export class JokeService {
    
    http = inject(HttpClient)
   

    getJokeAsObservable(): Observable<ApiResponse> {
        return this.http.get<ApiResponse>('https://official-joke-api.appspot.com/random_joke')
    }

   
}