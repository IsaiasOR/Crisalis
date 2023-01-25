import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import { FormGroup, FormBuilder } from '@angular/forms';
import { BusinessService } from 'src/app/services/business/business.service';

@Component({
  selector: 'app-business-modify-data',
  templateUrl: './business-modify-data.component.html',
  styleUrls: ['./business-modify-data.component.css']
})

export class BusinessModifyDataComponent implements OnInit {
  id:any;

  constructor(
    private activeRote:ActivatedRoute
  ) {
    this.id = this.activeRote.snapshot.paramMap.get('Id');
    console.log(this.id);
  }

  ngOnInit(): void {
      
  }

}
