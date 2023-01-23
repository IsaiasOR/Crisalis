import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ServiceComponent } from './components/service/service.component';
import { ProductComponent } from './components/product/product.component';
import { UserComponent } from './components/user/user.component';
import { OrderComponent } from './components/order/order.component';
import { BusinessComponent } from './components/business/business.component';
import { BusinessAddComponent } from './components/business/business-add/business-add.component';
import { BusinessModifyDataComponent } from './components/business/business-modify-data/business-modify-data.component';
import { UserModifyDataComponent } from './components/user/user-modify-data/user-modify-data.component';
import { PersonComponent } from './components/person/person.component';
import { PersonAddComponent } from './components/person/person-add/person-add.component';
import { PersonEdityComponent } from './components/person/person-edity/person-edity.component';
import { LoginComponent } from './components/login/login.component';


import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { ProductAddComponent } from './components/product/product-add/product-add.component';
import { ProductEdityComponent } from './components/product/product-edity/product-edity.component';
import { ServiceAddComponent } from './components/service/service-add/service-add.component';
import { ServiceEdityComponent } from './components/service/service-edity/service-edity.component';
import { HomeComponent } from './components/home/home.component';
import { TaxComponent } from './components/tax/tax.component';
import { TaxAddComponent } from './components/tax/tax-add/tax-add.component';
import { TaxEdityComponent } from './components/tax/tax-edity/tax-edity.component';
import { OrderAddComponent } from './components/order/order-add/order-add.component';
import { OrderEdityComponent } from './components/order/order-edity/order-edity.component';
import { RegisterComponent } from './components/user/register/register.component';

@NgModule({
  declarations: [
    AppComponent,
    ServiceComponent,
    ProductComponent,
    UserComponent,
    OrderComponent,
    BusinessComponent,
    BusinessAddComponent,
    BusinessModifyDataComponent,
    UserModifyDataComponent,
    PersonComponent,
    PersonAddComponent,
    PersonEdityComponent,
    ProductAddComponent,
    ProductEdityComponent,
    ServiceAddComponent,
    ServiceEdityComponent,
    HomeComponent,
    TaxComponent,
    TaxAddComponent,
    TaxEdityComponent,
    LoginComponent,
    OrderAddComponent,
    OrderEdityComponent,
    RegisterComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
