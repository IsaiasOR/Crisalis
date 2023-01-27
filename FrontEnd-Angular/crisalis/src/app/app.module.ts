import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BusinessAddComponent } from './components/business/business-add/business-add.component';
import { BusinessModifyDataComponent } from './components/business/business-modify-data/business-modify-data.component';
import { UserModifyDataComponent } from './components/user/user-modify-data/user-modify-data.component';
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
import { TaxAddComponent } from './components/tax/tax-add/tax-add.component';
import { TaxEdityComponent } from './components/tax/tax-edity/tax-edity.component';
import { OrderAddComponent } from './components/order/order-add/order-add.component';
import { OrderEdityComponent } from './components/order/order-edity/order-edity.component';
import { RegisterComponent } from './components/user/register/register.component';
import { OrderListComponent } from './components/order/order-list/order-list.component';
import { PersonListComponent } from './components/person/person-list/person-list.component';
import { ProductListComponent } from './components/product/product-list/product-list.component';
import { ServiceListComponent } from './components/service/service-list/service-list.component';
import { TaxListComponent } from './components/tax/tax-list/tax-list.component';
import { UserListComponent } from './components/user/user-list/user-list.component';

@NgModule({
  declarations: [
    AppComponent,
    BusinessAddComponent,
    BusinessModifyDataComponent,
    UserModifyDataComponent,
    PersonAddComponent,
    PersonEdityComponent,
    ProductAddComponent,
    ProductEdityComponent,
    ServiceAddComponent,
    ServiceEdityComponent,
    HomeComponent,
    TaxAddComponent,
    TaxEdityComponent,
    LoginComponent,
    OrderAddComponent,
    OrderEdityComponent,
    RegisterComponent,
    OrderListComponent,
    PersonListComponent,
    ProductListComponent,
    ServiceListComponent,
    TaxListComponent,
    UserListComponent
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
