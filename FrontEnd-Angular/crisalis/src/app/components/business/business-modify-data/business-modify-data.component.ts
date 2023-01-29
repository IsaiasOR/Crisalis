import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { BusinessService } from 'src/app/services/business/business.service';

@Component({
  selector: 'app-business-modify-data',
  templateUrl: './business-modify-data.component.html',
  styleUrls: ['./business-modify-data.component.css']
})

export class BusinessModifyDataComponent implements OnInit {
  formBusiness: FormGroup;
  id:any;

  constructor(
    private activeRote:ActivatedRoute,
    private businessService:BusinessService,
    public formBuilder:FormBuilder,
    private router:Router
  ) {
    this.id = this.activeRote.snapshot.paramMap.get('Id');
    console.log(this.id);

    this.businessService.getSingleBusiness(this.id).subscribe(
      response => {
        console.log(response);
        this.formBusiness.setValue({
          BusinessName:response[0]['BusinessName'],
          ActStartDate:response[0]['ActStartDate'],
          CUIT:response[0]['CUIT']
        });
      }
    );

    this.formBusiness = this.formBuilder.group({
      BusinessName:[''],
      ActStartDate:[''],
      CUIT:['']
    });

  }

  ngOnInit(): void {
  }

  sendData():any {
    console.log(this.id);
    console.log(this.formBusiness.value);
    this.businessService.editBusiness(this.id, this.formBusiness.value).subscribe(() => {
      this.router.navigateByUrl('/business-list');
    });
  }
}