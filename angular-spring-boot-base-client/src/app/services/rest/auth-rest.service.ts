import { Injectable } from '@angular/core';
import {BackendService} from '../backend.service';
import {Observable} from 'rxjs';
import {RestResponse} from '../../interfaces/rest-response';
import {AppUser} from '../../interfaces/auth/app-user';
import {LoginCreds} from '../../interfaces/auth/login-creds';

@Injectable({
  providedIn: 'root'
})
export class AuthRestService {

  constructor(private backendService: BackendService) { }

  login(cred: LoginCreds): Observable<RestResponse<AppUser>> {
    return this.backendService.apiPost('login', cred);
  }
}
