import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { ServiceService } from 'src/app/services/service/service.service';

@Component({
  selector: 'app-service-edity',
  templateUrl: './service-edity.component.html',
  styleUrls: ['./service-edity.component.css']
})
export class ServiceEdityComponent implements OnInit {
  formService: FormGroup;
  id:any;

  constructor(
    private activeRote:ActivatedRoute,
    private serviceService:ServiceService,
    public formBuilder:FormBuilder,
    private router:Router,
  ) {
    this.id = this.activeRote.snapshot.paramMap.get('Id');
    console.log(this.id);

    this.serviceService.getSingleService(this.id).subscribe(
      response => {
        console.log(response);
        this.formService.setValue({
          Name:response['name'],
          BaseAmount:response['baseAmount'],
          TypeService:response['typeService'],
          SupportChange:response['supportChange']
        });
      }
    );

    this.formService = this.formBuilder.group({
      Name:[''],
      BaseAmount:[''],
      TypeService:[''],
      SupportChange:['']
    });

  }

  ngOnInit(): void { }

  sendData():any {
    console.log(this.id);
    console.log(this.formService.value);
    this.serviceService.editService(this.id, this.formService.value).subscribe(() => {
      this.router.navigateByUrl('/service-list');
    });
  }
}