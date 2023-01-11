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
import { ClientListComponent } from './components/client/client-list/client-list.component';
import { ClientModifyDataComponent } from './components/client/client-modify-data/client-modify-data.component';
import { ClientRegisterComponent } from './components/client/client-register/client-register.component';
import { BusinessAddComponent } from './components/business/business-add/business-add.component';
import { BusinessListComponent } from './components/business/business-list/business-list.component';
import { BusinessModifyDataComponent } from './components/business/business-modify-data/business-modify-data.component';
import { UserRegisterComponent } from './components/user/user-register/user-register.component';
import { UserListComponent } from './components/user/user-list/user-list.component';
import { UserModifyDataComponent } from './components/user/user-modify-data/user-modify-data.component';
import { LoginComponent } from './components/login/login.component';

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
    ClientRegisterComponent,
    ClientListComponent,
    ClientModifyDataComponent,
    ClientRegisterComponent,
    BusinessAddComponent,
    BusinessListComponent,
    BusinessModifyDataComponent,
    UserRegisterComponent,
    UserListComponent,
    UserModifyDataComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
