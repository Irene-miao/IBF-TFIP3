import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
 pics: string[] = [
  "https://entreedestinations.com/wp-content/uploads/2019/09/Polar-bear_photo-by-Ian-Johnson.jpg",
  "https://static.stacker.com/s3fs-public/2018-09/shutterstock_1184605060_0.jpg"
 ]

 values: number[] = [];

selectedNums: number[] = []

 constructor() {

 this.generateNums()
 }

valueSelected(n :number) {
console.log("app component:  value selected: " + n);
this.selectedNums.push(n);
}

generateNums(){
  this.values = []
  for (let i = 0; i < 5; i++){
    const n = Math.floor(Math.random() * 30) + 1
    this.values.push(n)
  }

  console.log('generated values: ', this.values)
}


}
