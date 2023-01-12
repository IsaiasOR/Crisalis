import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, EmailValidator } from '@angular/forms';
import { CrudService } from 'src/app/service/service/crud.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-service-add',
  templateUrl: './service-add.component.html',
  styleUrls: ['./service-add.component.css']
})
export class ServiceAddComponent {
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
    
    this.crudService.addService(this.formGroup.value).subscribe();
  
    this.router.navigateByUrl('/service');
  }
}
