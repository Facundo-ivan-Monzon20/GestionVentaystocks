import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Products } from './products';

@Injectable({
  providedIn: 'root'
})
export class ProductsService {

  private baseURL = "http://localhost:8080/api/Products/ListProducts";


  constructor(private httpClient: HttpClient) {

   }

   // este metodo obtiene los productos. Ver patron observable  y Dao
   getProductList():Observable<Products[]>{
     return this.httpClient.get<Products[]>(`${this.baseURL}`);
   }

  

  
}
