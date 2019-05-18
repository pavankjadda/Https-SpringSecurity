import {Component, OnInit} from '@angular/core';
import {AuthService} from '../auth/auth.service';
import {ActivatedRoute, Router} from '@angular/router';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {NgxSpinnerService} from 'ngx-spinner';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit
{
  message: string;
  loginForm: FormGroup;
  submitted=false;
  returnUrl: string;
  loginFailed: boolean;

  constructor(
    private formBuilder: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private authService: AuthService,
    private spinner: NgxSpinnerService
  )
  {

  }


  ngOnInit()
  {
    // redirect to home if already logged in
    if(this.authService.currentUserValue)
    {
      this.router.navigate( ['/home'] );
    }

    this.loginForm=this.formBuilder.group( {
      username: ['', Validators.required],
      password: ['', Validators.required]
    } );

    // get return url from route parameters or default to '/'
    this.returnUrl=this.route.snapshot.queryParams['returnUrl']||'/';
    //Logout user if already logged in
    this.logout();
  }

  // convenience getter for easy access to form fields
  get f()
  {
    return this.loginForm.controls;
  }


  login()
  {
    this.spinner.show();
    this.authService.login( this.f.username.value, this.f.password.value ).subscribe(
 response=>
      {
        if(response['token']&&AuthService.isUserLoggedIn())
        {
          this.router.navigate(['/home']);
        }
        else
        {
          localStorage.removeItem( 'currentUser' );
          this.router.navigate(['/login']);
        }
      },
        error =>
        {
            console.log(error);
            this.loginFailed=true;
          this.spinner.hide();
        },
      () =>
      {
        this.spinner.hide();
      } );
  }

  logout()
  {
    this.authService.logout();
    this.setMessage();
  }

  isUserLoggedIn()
  {

  }
  private setMessage()
  {
    this.message='Logged '+(AuthService.isUserLoggedIn() ? 'in' : 'out');
  }
}
