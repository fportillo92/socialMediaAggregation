import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BoardsService } from './service/boards-service.service';
import { HttpClientModule } from '@angular/common/http';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { FormsModule } from '@angular/forms';
import { MatListModule } from '@angular/material/list';
import { MatGridListModule } from '@angular/material/grid-list';




const appRoutes: Routes = [
  {path: '', component: LoginPageComponent },
  {path: 'listBoards', component: BoardsPageComponent },
  {path: '**', component: PageNotFoundComponentComponent }
];

import { AppComponent } from './app.component';
import { PageNotFoundComponentComponent } from './page-not-found-component/page-not-found-component.component';
import { BoardsPageComponent } from './boards-page/boards-page.component';
import { LoginPageComponent } from './login-page/login-page.component';
import { TweetsPageComponent } from './tweets-page/tweets-page.component';

@NgModule({
  declarations: [
    AppComponent,
    PageNotFoundComponentComponent,
    BoardsPageComponent,
    LoginPageComponent,
    TweetsPageComponent
  ],
  imports: [BrowserModule, RouterModule.forRoot(appRoutes), HttpClientModule, MatCardModule, MatFormFieldModule, FormsModule, MatListModule, MatGridListModule
  ],
  providers: [BoardsService],
  bootstrap: [AppComponent]
})
export class AppModule { }
