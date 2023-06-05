import { Component, Input, OnInit, Output, inject } from '@angular/core';
import { FormArray, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Task, Todo } from '../models';
import { Subject } from 'rxjs';

@Component({
  selector: 'app-createtodo',
  templateUrl: './createtodo.component.html',
  styleUrls: ['./createtodo.component.css']
})
export class CreatetodoComponent implements OnInit{
todoForm!: FormGroup
tasksArr!:  FormArray
@Output() onNewTask = new Subject<Todo>()
@Input() todo: Todo | null = null


fb: FormBuilder = inject(FormBuilder)


invalidField(ctrlName: string): boolean {
  return !!(this.todoForm.get(ctrlName)?.invalid && this.todoForm.get(ctrlName)?.dirty)
}


addTask() {
  this.tasksArr.push(this.createTask(null))
}

removeTask(i: number) {
  this.tasksArr.removeAt(i)
}

processTask() {
  const todo = this.todoForm.value as Todo
  this.onNewTask.next(todo)
  this.todoForm = this.createTodo(null)
}

private createTodo(todo: Todo | null): FormGroup{
  this.tasksArr  = this.createTasks(!!todo? todo.tasks: [])
  return this.fb.group({
    title: this.fb.control<string>((!!todo)? todo.title:''),
    name: this.fb.control<string>((!!todo)? todo.name:''),
    tasks: this.tasksArr
  })
}

private createTasks(tasks: Task[]): FormArray {
  return this.fb.array(
    tasks.map( t => this.createTask(t))
  )
}

private createTask(t: Task | null): FormGroup {
  return this.fb.group({
    task: this.fb.control<string>(!!t? t.task: ''),
    priority: this.fb.control<string>(!!t? t.priority: ''),
    dueDate: this.fb.control<string>(!!t? t.dueDate: '')
  })
}


ngOnInit(): void {
this.todoForm = this.createTodo(this.todo)
}



}
