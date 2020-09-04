import {Component, OnInit} from '@angular/core';
import {PriceIndexService} from './price-index.service';

@Component({
  selector: 'app-price-index',
  templateUrl: './price-index.component.html',
  styleUrls: ['./price-index.component.css']
})
export class PriceIndexComponent implements OnInit {

  products = [];
  displayedColumns: string[] = ['product id', 'name', 'carton price', 'unit price', 'carton size'];


  constructor(private productService: PriceIndexService) {
  }

  ngOnInit(): void {
    this.productService.getAllProducts().subscribe(
      res => {
        this.products = res;
      }
    );

  }

}


