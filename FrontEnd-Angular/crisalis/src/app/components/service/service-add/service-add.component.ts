import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, EmailValidator } from '@angular/forms';
import { ServiceService } from 'src/app/services/service/service.service';
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
    private crudService:ServiceService,
    private router:Router
    ) {

    this.formGroup=this.form.group({
      Name:[''],
      BaseAmount:['']
    });
  }

  sendData():any {
    console.log(this.formGroup.value);
    
    this.crudService.addService(this.formGroup.value).subscribe(response => {
      this.router.navigateByUrl('/service-list');
    });
  }
}
