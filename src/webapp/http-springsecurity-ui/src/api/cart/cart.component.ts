import {Component, OnInit} from '@angular/core';
import {CartService} from './service/cart.service';
import {CART_API_URL, INVENTORY_API_URL, SERVER_URL} from '../../app.constants';
import {Cart} from './model/cart';
import {AuthService} from '../../core/auth/auth.service';
import {NgxSpinnerService} from 'ngx-spinner';
import {CartProduct} from './model/cart-product';
import {Router} from '@angular/router';
import {ProductInventory} from '../product/model/product-inventory';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit
{
  cart: Cart;
  cartProducts: Array<CartProduct>;
  productInventory:Array<ProductInventory>;
  totalCost:number;
  constructor(private cartService:CartService,
              private ngxSpinnerService:NgxSpinnerService,
              private authService:AuthService,
              private router:Router)
  {

  }

  ngOnInit()
  {
    this.totalCost=0;
    this.getMyCart();

  }

  //Takes care update and delete if quantity is zero
  updateCartProductQuantity(cartProduct: CartProduct)
  {
      this.ngxSpinnerService.show();
      const cartUrl=SERVER_URL+CART_API_URL+'product/update';
      this.cartService.updateCartProduct( cartUrl, cartProduct ).subscribe(
        data=>
        {
          this.getMyCart();
          this.ngxSpinnerService.hide();
        },
        error1 =>
        {
          this.ngxSpinnerService.hide();
        }
      );
  }

  deleteProductFromCart(cartProduct: CartProduct)
  {
    if(confirm('Are you sure you want to delete '+cartProduct.product.name+' from Cart?'))
    {
      this.ngxSpinnerService.show();
      const cartUrl=SERVER_URL+CART_API_URL+'product/delete/'+cartProduct.id;
      this.cartService.deleteCartProduct( cartUrl ).subscribe(
        data=>
        {
          this.getMyCart();
          this.ngxSpinnerService.hide();
        },
        error1 =>
        {
          this.ngxSpinnerService.hide();
        }
      );
    }

  }

  cartDataAvailable()
  {
    return this.cart!==undefined && this.cart !== null && this.cartProducts.length>=0;
  }

  deleteCart()
  {
    if(confirm('Are you sure you wanna delete the cart?'))
    {
      this.ngxSpinnerService.show();
      const cartUrl=SERVER_URL+CART_API_URL+'delete/'+this.cartService.getCurrentCart.id;
      this.cartService.deleteMyCart(cartUrl).subscribe(
        data=>
        {
          this.getMyCart();
          this.ngxSpinnerService.hide();
        },
        error1 =>
        {
          this.ngxSpinnerService.hide();
        }
      );
    }
  }

  private getMyCart()
  {
    this.ngxSpinnerService.show();
    const cartUrl=SERVER_URL+CART_API_URL+'find/user/'+this.authService.currentUserValue.id;
    this.cartService.getMyCart( cartUrl ).subscribe(
      data =>
      {
        localStorage.setItem( 'currentCart', JSON.stringify( data ) );
        this.cartService.currentCartSubject.next( data );
        this.cart=data;
        if(data.cartProducts!==null)
        {
          this.cartProducts=data.cartProducts;
        }
        this.getProductInventory();
        this.ngxSpinnerService.hide();
      }
    );
  }



  private getProductInventory()
  {
    let productIdList=[];
    this.cart.cartProducts.forEach( function(cartProduct)
       {
          productIdList.push(cartProduct.product.id);
       });
    const inventoryUrl = SERVER_URL + INVENTORY_API_URL+'product/ids';
    this.cartService.getProductInventory( inventoryUrl, productIdList ).pipe()
        .subscribe(
          data =>
          {
            this.productInventory = data;
          },
          error =>
          {
            console.log(error);
          });
  }

  getInventory(cartProduct: CartProduct):number
  {
    if(this.productInventory!==undefined)
    {
      for(let i=0;i<this.productInventory.length;i++)
      {
        if(cartProduct.product.id === this.productInventory[i].product.id && cartProduct.quantity <= this.productInventory[i].quantity)
        {
          return this.productInventory[i].quantity;
        }
      }
    }
     return 1;
  }

  goToProducts()
  {
    this.router.navigate(['/product/list']);
  }

  checkout()
  {
    this.router.navigate(['/checkout']);
  }
}