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
    private router:Router
  ) {
    this.id = this.activeRote.snapshot.paramMap.get('Id');
    console.log(this.id);

    this.serviceService.getSingleService(this.id).subscribe(
      response => {
        console.log(response);
        this.formService.setValue({
          Name:response[0]['Name'],
          BaseAmount:response[0]['BaseAmount']
        });
      }
    );

    this.formService = this.formBuilder.group({
      Name:[''],
      BaseAmount:['']
    });

  }

  ngOnInit(): void {
  }

  sendData():any {
    console.log(this.id);
    console.log(this.formService.value);
    this.serviceService.editService(this.id, this.formService.value).subscribe(() => {
      this.router.navigateByUrl('/service-list');
    });
  }
}