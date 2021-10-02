import { Component, OnInit } from '@angular/core';
import {AuthService} from '../../../services/auth.service';
import {LoginCreds} from '../../../interfaces/auth/login-creds';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.scss']
})
export class LoginPageComponent implements OnInit {



  constructor(private authService: AuthService) { }

  ngOnInit(): void {
  }

  performLogin(loginCreds: LoginCreds): void {
    this.authService.login(loginCreds);
  }
}
