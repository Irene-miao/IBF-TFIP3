import { Component, ElementRef, OnInit, ViewChild, inject } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ImageService } from '../image.service';
import { firstValueFrom } from 'rxjs';
import { Router } from '@angular/router';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {
  @ViewChild('uploadFile')
  uploadFile!: ElementRef

  form!: FormGroup
  fb = inject(FormBuilder)
  imageSvc = inject(ImageService)
  router = inject(Router)

  ngOnInit(): void {
      this.form = this.fb.group({
        title: this.fb.control<string>('', [Validators.required]),
        file: this.fb.control<File | null>(null, [Validators.required])
      })
  }

  upload() {
    const f: File = this.uploadFile.nativeElement.files[0]
    const data = this.form.value
    console.info('data: ', data)
    console.info('file: ', f)

    // Promise
    firstValueFrom(this.imageSvc.upload(data['title'], f))
    .then(result => {
      alert('uploaded')
      this.form.reset()
    })
    .catch(err => {
      alert(JSON.stringify(err))
    })

    this.router.navigate(['/list'])
  }



}
