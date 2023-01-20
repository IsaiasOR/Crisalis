import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { BusinessComponent} from './components/business/business.component';
import { PersonComponent } from './components/person/person.component';
import { PersonAddComponent } from './components/person/person-add/person-add.component';
import { PersonEdityComponent } from './components/person/person-edity/person-edity.component';
import { BusinessAddComponent } from './components/business/business-add/business-add.component';
import { ProductComponent } from './components/product/product.component';
import { ServiceComponent } from './components/service/service.component';
import { ServiceAddComponent } from './components/service/service-add/service-add.component';
import { ServiceEdityComponent } from './components/service/service-edity/service-edity.component';
import { ProductAddComponent } from './components/product/product-add/product-add.component';
import { ProductEdityComponent } from './components/product/product-edity/product-edity.component';
import { BusinessModifyDataComponent } from './components/business/business-modify-data/business-modify-data.component';
import { UserComponent } from './components/user/user.component';
import { UserRegisterComponent } from './components/user/user-register/user-register.component';
import { UserModifyDataComponent } from './components/user/user-modify-data/user-modify-data.component';
import { TaxComponent } from './components/tax/tax.component';
import { TaxAddComponent } from './components/tax/tax-add/tax-add.component';
import { TaxEdityComponent } from './components/tax/tax-edity/tax-edity.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { OrderComponent } from './components/order/order.component';
import { OrderAddComponent } from './components/order/order-add/order-add.component';
import { OrderEdityComponent } from './components/order/order-edity/order-edity.component';
import { Order } from './models/order';

const routes: Routes = [

  {path: '', pathMatch:'full', redirectTo:'home'},
  {path: 'home', component:HomeComponent},
  {path: 'user', component:UserComponent},
  {path: 'user-register', component:UserRegisterComponent},
  {path: 'user-edity', component:UserModifyDataComponent},
  {path: 'person', component:PersonComponent},
  {path: 'person-add', component:PersonAddComponent},
  {path: 'person-edity', component:PersonEdityComponent},
  {path: 'business', component:BusinessComponent},
  {path: 'business-add', component:BusinessAddComponent},
  {path: 'business-edity', component:BusinessModifyDataComponent},
  {path: 'product', component:ProductComponent},
  {path: 'product-add', component:ProductAddComponent},
  {path: 'product-edity', component:ProductEdityComponent},
  {path: 'service', component:ServiceComponent},
  {path: 'service-add', component:ServiceAddComponent},
  {path: 'service-edity', component:ServiceEdityComponent},
  {path: 'tax', component:TaxComponent},
  {path: 'tax-add', component:TaxAddComponent},
  {path: 'tax-edity', component:TaxEdityComponent},
  {path: 'login', component:LoginComponent},
  {path: 'order', component:OrderComponent},
  {path: 'order-add', component:OrderAddComponent},
  {path: 'order-edity', component:OrderEdityComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
