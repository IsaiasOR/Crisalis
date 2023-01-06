import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ClientComponent } from './components/client/client.component';
import { ServiceComponent } from './components/service/service.component';
import { ProductComponent } from './components/product/product.component';
import { UserComponent } from './components/user/user.component';
import { OrderComponent } from './components/order/order.component';
import { BusinessComponent } from './components/business/business.component';
import { NeedComponent } from './components/need/need.component';
import { TaxComponent } from './components/tax/tax.component';
import { ClientUnsubscribeComponent } from './components/client/client-unsubscribe/client-unsubscribe.component';
import { ClientListComponent } from './components/client/client-list/client-list.component';
import { ClientModifyDataComponent } from './components/client/client-modify-data/client-modify-data.component';
import { ClientRegisterComponent } from './components/client/client-register/client-register.component';
import { BusinessAddComponent } from './components/business/business-add/business-add.component';
import { BusinessListComponent } from './components/business/business-list/business-list.component';
import { BusinessModifyDataComponent } from './components/business/business-modify-data/business-modify-data.component';
import { BusinessDeleteComponent } from './components/business/business-delete/business-delete.component';
import { UserRegisterComponent } from './components/user/user-register/user-register.component';
import { UserUnsubscribeComponent } from './components/user/user-unsubscribe/user-unsubscribe.component';
import { UserListComponent } from './components/user/user-list/user-list.component';
import { UserModifyDataComponent } from './components/user/user-modify-data/user-modify-data.component';
import { UserHomeComponent } from './components/user/user-home/user-home.component';
import { BusinessHomeComponent } from './components/business/business-home/business-home.component';
import { ClientHomeComponent } from './components/client/client-home/client-home.component';
import { ProductHomeComponent } from './components/product/product-home/product-home.component';
import { ServiceHomeComponent } from './components/service/service-home/service-home.component';
import { TaxHomeComponent } from './components/tax/tax-home/tax-home.component';
import { OrderHomeComponent } from './components/order/order-home/order-home.component';
import { HomeComponent } from './components/home/home.component';

@NgModule({
  declarations: [
    AppComponent,
    ClientComponent,
    ServiceComponent,
    ProductComponent,
    UserComponent,
    OrderComponent,
    BusinessComponent,
    NeedComponent,
    TaxComponent,
    ClientRegisterComponent,
    ClientUnsubscribeComponent,
    ClientListComponent,
    ClientModifyDataComponent,
    ClientRegisterComponent,
    BusinessAddComponent,
    BusinessListComponent,
    BusinessModifyDataComponent,
    BusinessDeleteComponent,
    UserRegisterComponent,
    UserUnsubscribeComponent,
    UserListComponent,
    UserModifyDataComponent,
    UserHomeComponent,
    BusinessHomeComponent,
    ClientHomeComponent,
    ProductHomeComponent,
    ServiceHomeComponent,
    TaxHomeComponent,
    OrderHomeComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
