import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';


// 
@Injectable({
  providedIn: 'root'
})
export class CameraService {

  photo = "";

  http = inject(HttpClient);
  
  upload(f: File, comments: string) {
    console.warn(comments);
    const formData = new FormData();
    formData.set('file', f);
    formData.set('comments', comments)
    return this.http.post<any>('upload', formData)
  }
}
