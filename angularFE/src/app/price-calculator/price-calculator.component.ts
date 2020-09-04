import {Component, OnInit} from '@angular/core';
import {PriceIndexService} from '../price-index/price-index.service';
import {FormControl, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-price-calculator',
  templateUrl: './price-calculator.component.html',
  styleUrls: ['./price-calculator.component.css']
})
export class PriceCalculatorComponent implements OnInit {

  suggestions: Product [] = []; // Used for storing data
  send: SendForm; // Used to build the bdy of the POST request

  /* 2 separate forms for 2 products */
  product1Form = new FormGroup({
    noOfCartons: new FormControl(''),
    noOfUnits: new FormControl(''),
    suggestedCartons: new FormControl(''),
    suggestedUnits: new FormControl(''),
    totalPrice: new FormControl(''),
  });

  product2Form = new FormGroup({
    noOfCartons: new FormControl(''),
    noOfUnits: new FormControl(''),
    suggestedCartons: new FormControl(''),
    suggestedUnits: new FormControl(''),
    totalPrice: new FormControl(''),
  });

  /* Price Index Service is injected */
  constructor(private priceIndexService: PriceIndexService) {
  }

  ngOnInit(): void {

    // Get all products at first
    this.priceIndexService.getAllProducts().subscribe(
      res => {

        this.suggestions = [];
        res.forEach((element) => {
          this.suggestions.push(new Product(element.productId, element.productName, element.cartonPrice, element.cartonSize,
            0, 0, 0));
        });

        // Set form control values initially
        this.product1Form.controls.noOfCartons.patchValue(this.suggestions[0].noOfCartons);
        this.product1Form.controls.noOfUnits.patchValue(this.suggestions[0].noOfUnits);

        this.product2Form.controls.noOfCartons.patchValue(this.suggestions[1].noOfCartons);
        this.product2Form.controls.noOfUnits.patchValue(this.suggestions[1].noOfUnits);
      }
    );

  }

  /* Used for making POST requests to the backend after pressing submit button */
  onSubmit(form): any {


    if (form === this.product1Form) {
      const prdId = this.suggestions[0].productId;
      const cartonSize = this.suggestions[0].cartonSize;
      const noOfCartons = this.product1Form.get('noOfCartons').value;
      const noOfUnits = this.product1Form.get('noOfUnits').value;
      this.send = new SendForm(prdId, noOfCartons, noOfUnits);

      // The form controls are updated with the new suggestions
      this.priceIndexService.sendDetails(this.send).subscribe(res => {
        this.product1Form.controls.suggestedCartons.patchValue(res.noOfCartons);
        this.product1Form.controls.suggestedUnits.patchValue(res.noOfUnits);
        this.product1Form.controls.totalPrice.patchValue(res.totalPrice);
      });
    }
    if (form === this.product2Form) {
      const prdId = this.suggestions[1].productId;
      const cartonSize = this.suggestions[1].cartonSize;
      const noOfCartons = this.product2Form.get('noOfCartons').value;
      const noOfUnits = this.product2Form.get('noOfUnits').value;
      this.send = new SendForm(prdId, noOfCartons, noOfUnits);

      this.priceIndexService.sendDetails(this.send).subscribe(res => {

        this.product2Form.controls.suggestedCartons.patchValue(res.noOfCartons);
        this.product2Form.controls.suggestedUnits.patchValue(res.noOfUnits);
        this.product2Form.controls.totalPrice.patchValue(res.totalPrice);
      });
    }

  }
}


// Class to store incoming product details
export class Product {
  public productId: number;
  public productName: string;
  public cartonPrice: number;
  public cartonSize: number;
  public noOfCartons: number;
  public noOfUnits: number;
  public totalPrice: number;

  constructor(ProductId: number, ProductName: string, CartonPrice: number, CartonSize: number, NoOfCartons: number,
              NoOfUnits: number, TotalPrice: number) {
    this.productId = ProductId;
    this.productName = ProductName;
    this.cartonPrice = CartonPrice;
    this.cartonSize = CartonSize;
    this.noOfCartons = NoOfCartons;
    this.noOfUnits = NoOfUnits;
    this.totalPrice = TotalPrice;
  }
}

// Class for sending data
export class SendForm {
  productId: number;
  noOfCartons: number;
  noOfUnits: number;

  constructor(productId: number, noOfCartons: number, noOfUnits: number) {
    this.productId = productId;
    this.noOfCartons = noOfCartons;
    this.noOfUnits = noOfUnits;
  }
}
