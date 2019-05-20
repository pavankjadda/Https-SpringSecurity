import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
import {UserAuthGuard} from "./guards/user-auth.guard";
import {HomeComponent} from "./layouts/home/home.component";

const routes: Routes=[
  {
    path: '',
    component: HomeComponent,
    canActivate: [UserAuthGuard]
  },
  {
    path: 'home',
    component: HomeComponent,
    canActivate: [UserAuthGuard]
  },
  {
    path: 'account',
    loadChildren: './account/account.module#AccountModule'
  }
];

@NgModule( {
  imports: [RouterModule.forRoot(routes)],

  exports: [RouterModule]
} )
export class AppRoutingModule
{
}