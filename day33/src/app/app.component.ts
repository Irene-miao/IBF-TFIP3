import { Component, OnInit, ViewChild, inject } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ThoughtsComponent } from './thoughts/thoughts.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  @ViewChild(ThoughtsComponent)
  thoughtCompo!: ThoughtsComponent

  canShare = false

  form!: FormGroup
  //fb: FormBuilder = inject(FormBuilder)


ngOnInit(): void {
    /*this.form = this.fb.group({
      name: this.fb.control('', [Validators.required]),
      email: this.fb.control('', [Validators.required]),
    })*/

    this.canShare = !!navigator.share
}

share(text: string) {
  const data: any = {
    title: 'Share a thought',
    text,
    url: 'http://google.com'
  }
  navigator.share(data)
  .then(result => {
    alert('Shared')
    this.thoughtCompo.clearForm() })
    .catch(err => alert('JSON: ' + JSON.stringify(err)))
}

}
