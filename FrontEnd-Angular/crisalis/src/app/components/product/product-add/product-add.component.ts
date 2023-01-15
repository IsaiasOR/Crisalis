import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, EmailValidator } from '@angular/forms';
import { CrudService } from 'src/app/services/product/crud.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-product-add',
  templateUrl: './product-add.component.html',
  styleUrls: ['./product-add.component.css']
})
export class ProductAddComponent {
  formGroup: FormGroup;

  constructor(
    public form:FormBuilder,
    private crudService:CrudService,
    private router:Router
    ) {

    this.formGroup=this.form.group({
      name:[''],
      price:['']
    });
  }

  sendData():any {
    console.log("Me presionaste");
    console.log(this.formGroup.value);
    
    this.crudService.addProduct(this.formGroup.value).subscribe();
  
    this.router.navigateByUrl('/product');
  }
}
