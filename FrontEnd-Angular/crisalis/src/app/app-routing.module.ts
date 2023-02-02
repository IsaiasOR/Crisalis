import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { AuthGuard } from './helpers/auth.guard';

import { BusinessListComponent } from './components/business/business-list/business-list.component';
import { BusinessAddComponent } from './components/business/business-add/business-add.component';
import { BusinessModifyDataComponent } from './components/business/business-modify-data/business-modify-data.component';

import { PersonListComponent } from './components/person/person-list/person-list.component';
import { PersonAddComponent } from './components/person/person-add/person-add.component';
import { PersonEdityComponent } from './components/person/person-edity/person-edity.component';

import { ServiceListComponent } from './components/service/service-list/service-list.component';
import { ServiceAddComponent } from './components/service/service-add/service-add.component';
import { ServiceEdityComponent } from './components/service/service-edity/service-edity.component';

import { ProductListComponent } from './components/product/product-list/product-list.component';
import { ProductAddComponent } from './components/product/product-add/product-add.component';
import { ProductEdityComponent } from './components/product/product-edity/product-edity.component';
import { PersonDetailsComponent } from './components/person/person-details/person-details.component';

import { UserListComponent } from './components/user/user-list/user-list.component';
import { UserModifyDataComponent } from './components/user/user-modify-data/user-modify-data.component';
import { RegisterComponent } from './components/user/register/register.component';

import { TaxListComponent } from './components/tax/tax-list/tax-list.component';
import { TaxAddComponent } from './components/tax/tax-add/tax-add.component';
import { TaxEdityComponent } from './components/tax/tax-edity/tax-edity.component';

import { LoginComponent } from './components/user/login/login.component';

import { OrderListComponent } from './components/order/order-list/order-list.component';
import { OrderAddComponent } from './components/order/order-add/order-add.component';
import { OrderEdityComponent } from './components/order/order-edity/order-edity.component';
import { OrderDetailsComponent } from './components/order/order-details/order-details.component';

import { SecretComponent } from './components/secret/secret.component';

const routes: Routes = [

  {path: '', component: SecretComponent, canActivate: [AuthGuard]},

  {path: 'user-list', component:UserListComponent},
  {path: 'user-edity/:Id', component:UserModifyDataComponent},
  {path: 'user-register', component:RegisterComponent},

  {path: 'person-list', component:PersonListComponent},
  {path: 'person-add', component:PersonAddComponent},
  {path: 'person-edity/:Id', component:PersonEdityComponent},
  {path: 'person-details/:Id', component:PersonDetailsComponent},

  {path: 'business-list', component:BusinessListComponent},
  {path: 'business-add', component:BusinessAddComponent},
  {path: 'business-edity/:Id', component:BusinessModifyDataComponent},

  {path: 'product-list', component:ProductListComponent},
  {path: 'product-add', component:ProductAddComponent},
  {path: 'product-edity/:Id', component:ProductEdityComponent},

  {path: 'service-list', component:ServiceListComponent},
  {path: 'service-add', component:ServiceAddComponent},
  {path: 'service-edity/:Id', component:ServiceEdityComponent},

  {path: 'tax-list', component:TaxListComponent},
  {path: 'tax-add', component:TaxAddComponent},
  {path: 'tax-edity/:Id', component:TaxEdityComponent},

  {path: 'login', component:LoginComponent},

  {path: 'order-list', component:OrderListComponent},
  {path: 'order-add', component:OrderAddComponent},
  {path: 'order-edity/:Id', component:OrderEdityComponent},
  {path: 'order-details/:Id', component:OrderDetailsComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
