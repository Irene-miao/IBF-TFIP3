import { Component, OnInit, inject } from '@angular/core';
import { FormArray, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Friend } from 'src/app/models';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit{
  friendsForm!: FormGroup;
  factsArray!: FormArray;
  friend!: Friend;

  fb: FormBuilder = inject(FormBuilder);


  constructor() {}


  ngOnInit(): void {
      this.friendsForm = this.createFormWithFormBuilder()
  }


  invalidField(ctrlName: string): boolean{
    return !!(this.friendsForm.get(ctrlName)?.invalid && this.friendsForm.get(ctrlName)?.dirty)
  }

  invalidForm(){
    return this.friendsForm.invalid || this.factsArray.length<= 0
  }

  addFact(){
    this.factsArray.push(this.createFriendsFact())
  }

  private createFriendsFact(): FormGroup {
    return this.fb.group({
      fact: new FormControl<string>('', [Validators.minLength(3), Validators.maxLength(16)]),
      value: this.fb.control('', [ Validators.minLength(5)])
    })
  }

  removeAt(i: number){
    this.factsArray.removeAt(i)
  }

  private createFormWithFormBuilder(){
    this.factsArray = this.fb.array([], [Validators.minLength(1)])
    return this.fb.group({
      name: this.fb.control<string>('', [Validators.required, Validators.minLength(3)]),
      email: this.fb.control<string>('', [ Validators.required, Validators.email]),
      age: this.fb.control<number>(10, [ Validators.min(10)]),
      gender: this.fb.control<string>(''),
      facts: this.factsArray
    })
  }
}
