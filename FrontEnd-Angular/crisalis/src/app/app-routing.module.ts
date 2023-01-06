import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { ClientRegistrationComponent } from './components/client/client-registration/client-registration.component';
import { ClientUnsubscribeComponent } from './components/client/client-unsubscribe/client-unsubscribe.component';
import { ClientListComponent } from './components/client/client-list/client-list.component';
import { ClientModifyDataComponent} from './components/client/client-modify-data/client-modify-data.component';

const routes: Routes = [

  {path:'', pathMatch:'full', redirectTo:'client-registration'},
  {path:'client-registration', component:ClientRegistrationComponent},
  {path:'client-list', component:ClientListComponent},
  {path:'client-unsubscribe', component:ClientUnsubscribeComponent},
  {path:'client-modify-data/:id', component:ClientModifyDataComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
