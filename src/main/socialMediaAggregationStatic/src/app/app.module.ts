import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BoardsService } from './service/boards-service.service';
import { HttpClientModule } from '@angular/common/http';
import {MatCardModule} from '@angular/material/card';




const appRoutes: Routes = [
  {path: '', component: LoginPageComponent },
  {path: 'listBoards', component: BoardsPageComponent },
  {path: '**', component: PageNotFoundComponentComponent }
];

import { AppComponent } from './app.component';
import { PageNotFoundComponentComponent } from './page-not-found-component/page-not-found-component.component';
import { BoardsPageComponent } from './boards-page/boards-page.component';
import { LoginPageComponent } from './login-page/login-page.component';

@NgModule({
  declarations: [
    AppComponent,
    PageNotFoundComponentComponent,
    BoardsPageComponent,
    LoginPageComponent
  ],
  imports: [
    BrowserModule, RouterModule.forRoot(appRoutes), HttpClientModule, MatCardModule
  ],
  providers: [BoardsService],
  bootstrap: [AppComponent]
})
export class AppModule { }
