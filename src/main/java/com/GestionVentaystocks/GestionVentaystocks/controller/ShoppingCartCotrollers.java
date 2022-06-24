package com.GestionVentaystocks.GestionVentaystocks.controller;
import com.GestionVentaystocks.GestionVentaystocks.models.Product;
import com.GestionVentaystocks.GestionVentaystocks.models.ProductForSale;
import com.GestionVentaystocks.GestionVentaystocks.models.shoppingCart;
import com.GestionVentaystocks.GestionVentaystocks.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;


@RestController
//ruta principal o raìz de donde se consumen los distintos pedidos. get,post,etc
@RequestMapping("/api")
//la ruta de donde se consume la api, o el front-end le hace pedidos al back-end
@CrossOrigin(origins = "*")
public class ShoppingCartCotrollers {


    private ShoppingCartService shoppingCartService;

    @Autowired
    public ShoppingCartCotrollers(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @GetMapping("/carrito")
    public List<shoppingCart> getListShopping(){
        return shoppingCartService.ListShoppingCart();
    }

    @GetMapping("/carrito/{id}")
    public  Map<Long, List<ProductForSale>> getShoppingCart(@PathVariable(value = "id") Long id){
        return shoppingCartService.getShoppingCart(id);
    }

    @PostMapping("/carrito")
    public shoppingCart saveShoppingCart(@RequestBody shoppingCart shoppingCart){
        return shoppingCartService.saveShoppingCart(shoppingCart);
    }

    @PutMapping("/carrito/{id}")
    public shoppingCart updateShoppingCart(@PathVariable(value = "id") Long id,@RequestBody shoppingCart shoppingCart){
        return shoppingCartService.updateShoppingCart(id,shoppingCart);
    }

    @DeleteMapping("/carrito/{id}")
    public void deleteShoppingCart(@PathVariable(value = "id") Long id){
        shoppingCartService.deleteShoppingCart(id);
    }

    @PutMapping("/carrito/quitar/{Id}")
    public void quitarProducto(@PathVariable(value = "Id")Long id, @RequestBody Product Idproduct){
        shoppingCartService.quitarProducto(id, Idproduct.getId());
    }

    @PutMapping("/carrito/agregar/{Id}")
    public void agregarProducto(@PathVariable(value = "Id")Long id, @RequestBody Product product){
        shoppingCartService.agregarProducto(id, product);
    }

    @GetMapping("/carrito/total/{id}")
    public float total(@PathVariable(value = "id")Long id){
        return shoppingCartService.total(id);
    }

    @GetMapping("/carrito/mapped")
    public Map<Long, List<ProductForSale>> mapeoCarrito(){
        return shoppingCartService.mapeoCarrito();
    }
}
