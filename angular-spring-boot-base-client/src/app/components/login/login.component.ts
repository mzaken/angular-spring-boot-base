import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {LoginCreds} from '../../interfaces/auth/login-creds';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  loginCreds = {} as LoginCreds;

  @Output() login = new EventEmitter<LoginCreds>();

  constructor() { }

  ngOnInit(): void {
  }

  performLogin(): void {
    this.login.emit(this.loginCreds);
  }
}
