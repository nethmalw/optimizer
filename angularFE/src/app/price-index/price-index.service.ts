import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class PriceIndexService {

  submitURL = 'http://localhost:8080';

  constructor(private http: HttpClient) {
  }

  public getAllProducts(): any {
    return this.http.get(this.submitURL + '/products');
    console.log('GET Submitted');
  }

  public sendDetails(sendBody: any): any {
    return this.http.post(this.submitURL + '/priceCalculate', sendBody);
  }
}

