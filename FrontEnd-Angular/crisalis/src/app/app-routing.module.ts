import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { HomeComponent } from './components/home/home.component';
import { ClientHomeComponent } from './components/client/client-home/client-home.component';
import { BusinessHomeComponent } from './components/business/business-home/business-home.component';
import { UserHomeComponent } from './components/user/user-home/user-home.component';
import { ProductHomeComponent } from './components/product/product-home/product-home.component';
import { ServiceHomeComponent } from './components/service/service-home/service-home.component';
import { TaxHomeComponent } from './components/tax/tax-home/tax-home.component';
import { OrderHomeComponent } from './components/order/order-home/order-home.component';

const routes: Routes = [

  {path: '', pathMatch:'full', redirectTo:'home'},
  {path: 'home', component:HomeComponent},
  {path: 'user-home', component:UserHomeComponent},
  {path: 'client-home', component:ClientHomeComponent},
  {path: 'business-home', component:BusinessHomeComponent},
  {path: 'order-home', component:OrderHomeComponent},
  {path: 'product-home', component:ProductHomeComponent},
  {path: 'service-home', component:ServiceHomeComponent},
  {path: 'tax-home', component:TaxHomeComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
