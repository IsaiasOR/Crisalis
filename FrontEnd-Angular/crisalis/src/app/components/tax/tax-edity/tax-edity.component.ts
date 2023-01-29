import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { TaxService } from 'src/app/services/tax/tax.service';

@Component({
  selector: 'app-tax-edity',
  templateUrl: './tax-edity.component.html',
  styleUrls: ['./tax-edity.component.css']
})
export class TaxEdityComponent implements OnInit {
  formTax: FormGroup;
  id:any;

  constructor(
    private activeRote:ActivatedRoute,
    private taxService:TaxService,
    public formBuilder:FormBuilder,
    private router:Router
  ) {
    this.id = this.activeRote.snapshot.paramMap.get('Id');
    console.log(this.id);

    this.taxService.getSingleTax(this.id).subscribe(
      response => {
        console.log(response);
        this.formTax.setValue({
          NameTax:response[0]['NameTax'],
          Percentage:response[0]['Percentage']
        });
      }
    );

    this.formTax = this.formBuilder.group({
      NameTax:[''],
      Percentage:['']
    });

  }

  ngOnInit(): void {
  }

  sendData():any {
    console.log(this.id);
    console.log(this.formTax.value);
    this.taxService.editTax(this.id, this.formTax.value).subscribe(() => {
      this.router.navigateByUrl('/tax-list');
    });
  }
}