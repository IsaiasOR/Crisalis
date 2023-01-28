import { Component, OnInit } from '@angular/core';
import { TaxService } from 'src/app/services/tax/tax.service';

@Component({
  selector: 'app-tax-list',
  templateUrl: './tax-list.component.html',
  styleUrls: ['./tax-list.component.css']
})

export class TaxListComponent implements OnInit{
  Taxes:any;

  constructor(
    private taxService:TaxService
  ) {}

  ngOnInit(): void {
    this.taxService.getTax().subscribe(response => {
      console.log(response);
      this.Taxes=response;
    });
  }

  deleteRegister(id:any, iControl:any) {
    console.log(id);
    console.log(iControl);
    if(window.confirm("¿Desea borrar el registro?")) {
      this.taxService.deleteTax(id).subscribe((response) => {
        this.Taxes.splice(iControl,1);
      });
      location.reload();
    }
  }
}