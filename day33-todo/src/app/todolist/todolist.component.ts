import { Component, Input, Output, inject } from '@angular/core';
import { Todo } from '../models';
import { FormBuilder } from '@angular/forms';
import { Subject } from 'rxjs';

@Component({
  selector: 'app-todolist',
  templateUrl: './todolist.component.html',
  styleUrls: ['./todolist.component.css']
})
export class TodolistComponent {
@Input() todos: Todo[] = []
@Output() onSelectedTodo = new Subject<Todo>();

fb: FormBuilder = inject(FormBuilder)


selected(i: number){
  this.onSelectedTodo.next(this.todos[i])
}


}
