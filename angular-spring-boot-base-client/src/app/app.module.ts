import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginPageComponent } from './components/pages/login-page/login-page.component';
import { AppNavComponent } from './components/app-nav/app-nav.component';
import {LoginComponent} from './components/login/login.component';
import {HttpClientModule, HTTP_INTERCEPTORS} from '@angular/common/http';
import {FormsModule} from '@angular/forms';
import { JwtInterceptorComponent } from './interceptors/jwt-interceptor/jwt-interceptor.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginPageComponent,
    AppNavComponent,
    LoginComponent,
    JwtInterceptorComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [
    {provide: HTTP_INTERCEPTORS, useClass:JwtInterceptorComponent, multi: true}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
