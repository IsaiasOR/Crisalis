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
import { ClientRegistrationComponent } from './components/client/client-registration/client-registration.component';
import { ClientUnsubscribeComponent } from './components/client/client-unsubscribe/client-unsubscribe.component';
import { ClientListComponent } from './components/client/client-list/client-list.component';
import { ClientModifyDataComponent } from './components/client/client-modify-data/client-modify-data.component';

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
    ClientRegistrationComponent,
    ClientUnsubscribeComponent,
    ClientListComponent,
    ClientModifyDataComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
