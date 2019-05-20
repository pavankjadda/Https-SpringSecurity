import {CommonModule} from "@angular/common";
import {NgModule} from "@angular/core";
import {HelpersRoutingModule} from "./helpers-routing.module";
import {Http403ErrorComponent} from "./http403-error/http403-error.component";
import {FileExistingValuePipe} from "./pipes/file-existing-value.pipe";

@NgModule( {
             declarations: [Http403ErrorComponent, FileExistingValuePipe],
  imports: [
    CommonModule,
    HelpersRoutingModule
  ]
} )
export class HelpersModule
{
}
