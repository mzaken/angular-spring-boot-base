import { Injectable } from '@angular/core';
import {AppUser} from '../interfaces/auth/app-user';
import { LoginCreds } from '../interfaces/auth/login-creds';
import {AuthRestService} from './rest/auth-rest.service';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  currentUser: AppUser;

  constructor(private authRestService: AuthRestService) { }

  login(cred: LoginCreds): void {
    this.authRestService.login({username: cred.username, password: cred.password}).subscribe(res => {
      if (res.success) {
       this.currentUser = res.payload;
      }
    });
  }

  getCurrentUser(): AppUser {
    return this.currentUser;
  }

  isUserLogin(): boolean {
    return this.currentUser ? true : false;
  }
}
