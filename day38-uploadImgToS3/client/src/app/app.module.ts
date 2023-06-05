import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { ImageService } from './image.service';
import { ReactiveFormsModule} from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { MainComponent } from './components/main.component';
import { ListComponent } from './components/list.component';
import { DetailComponent } from './components/detail.component';

const appRoutes: Routes = [
  { path:'', component: MainComponent, title: 'Main'},
  { path: 'list', component: ListComponent, title: 'List'},
  { path: 'detail/:imagePath', component: DetailComponent, title: 'Detail'},
  { path: '**', redirectTo: '/', pathMatch: 'full'}
]


@NgModule({
  declarations: [
    AppComponent,
    ListComponent,
    DetailComponent,
    MainComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    ReactiveFormsModule,
    RouterModule.forRoot(appRoutes, { useHash: true})
  ],
  providers: [ImageService],
  bootstrap: [AppComponent]
})
export class AppModule { }
