import {CommonModule} from "@angular/common";
import {NgModule} from "@angular/core";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {RouterModule} from "@angular/router";
import {ModalModule} from "ngx-bootstrap";
import {NgxSpinnerModule} from "ngx-spinner";
import {AccountRoutingModule} from "./account-routing.module";

import {ActivateComponent} from "./activate/activate.component";
import {PasswordResetComponent} from "./password-reset/password-reset.component";
import {PasswordComponent} from "./password/password.component";
import {RegisterComponent} from "./register/register.component";
import {SettingsComponent} from "./settings/settings.component";
import {UserProfileEditComponent} from "./user-profile/user-profile-edit/user-profile-edit.component";
import {UserProfileComponent} from "./user-profile/user-profile.component";


@NgModule({
  imports: [
    RouterModule,
    FormsModule,
    ReactiveFormsModule,
    CommonModule,
    ModalModule.forRoot(),
    NgxSpinnerModule,
    AccountRoutingModule
  ],
  declarations: [
    ActivateComponent,
    RegisterComponent,
    PasswordComponent,
    SettingsComponent,
    PasswordResetComponent,
    UserProfileComponent,
    UserProfileEditComponent
  ]
})
export class AccountModule { }

