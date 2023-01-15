import { Component, OnInit } from '@angular/core';
import { CrudService } from 'src/app/services/tax/crud.service';

@Component({
  selector: 'app-tax',
  templateUrl: './tax.component.html',
  styleUrls: ['./tax.component.css']
})
export class TaxComponent implements OnInit{
  Taxes:any;

  constructor(
    private crudService:CrudService
  ) {}

  ngOnInit(): void {
    this.crudService.getTax().subscribe(response => {
      console.log(response);
    });
  }
}

