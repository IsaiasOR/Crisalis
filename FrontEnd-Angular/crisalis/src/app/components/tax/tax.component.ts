import { Component, OnInit } from '@angular/core';
import { TaxService } from 'src/app/services/tax/tax.service';

@Component({
  selector: 'app-tax',
  templateUrl: './tax.component.html',
  styleUrls: ['./tax.component.css']
})
export class TaxComponent implements OnInit{
  Taxes:any;

  constructor(
    private crudService:TaxService
  ) {}

  ngOnInit(): void {
    this.crudService.getTax().subscribe(response => {
      console.log(response);
      this.Taxes=response;
    });
  }
}

