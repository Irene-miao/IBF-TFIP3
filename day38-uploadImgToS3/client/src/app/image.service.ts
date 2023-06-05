import { Injectable, inject } from "@angular/core";
import { HttpClient} from '@angular/common/http';
import { Observable } from "rxjs";


@Injectable()
export class ImageService {
    http = inject(HttpClient)

    upload(title: string, file: File): Observable<any>{
        const formData = new FormData()
        // @RequestPart String title
        formData.set('title', title)
        // @RequestPart MultipartFile myFile
        formData.set('myFile', file)

        return this.http.post<any>('http://localhost:8080/upload', formData)
    }

   getImage(imageKey: string) {
    
    return this.http.get(`http://localhost:8080/images/${imageKey}`, {responseType: 'blob'})
   }

   getPicture(imagePath: string){
    return this.http.get(`http://localhost:8080/${imagePath}`, {responseType: 'blob'})
   }

   getImages() {
    return this.http.get('http://localhost:8080/images')
   }
}