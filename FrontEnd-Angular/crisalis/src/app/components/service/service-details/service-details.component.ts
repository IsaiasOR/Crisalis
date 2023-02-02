import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ServiceService } from 'src/app/services/service/service.service';

@Component({
  selector: 'app-service-details',
  templateUrl: './service-details.component.html',
  styleUrls: ['./service-details.component.css']
})
export class ServiceDetailsComponent implements OnInit {
  id:any;
  serviceDetails:any;

  constructor(
    private activeRote:ActivatedRoute,
    private serviceService:ServiceService,
  ) {
    this.id = this.activeRote.snapshot.paramMap.get('Id');
    console.log(this.id);
  }

  ngOnInit(): void {
    this.serviceService.getSingleService(this.id).subscribe(response => {
      console.log(response);
      this.serviceDetails=response;
    });
  }
}