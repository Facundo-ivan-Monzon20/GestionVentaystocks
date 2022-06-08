import axios from 'axios';

const PRODUCTOS_URL = "http://localhost:8080/api/productos";

class ProductosServicio {

    getProductos(){
        return axios.get(PRODUCTOS_URL);
    }

    createProducto(producto){
        return axios.post(PRODUCTOS_URL, producto);
    }

    getProductoById(productoId){
        return axios.get(PRODUCTOS_URL + '/' + productoId);
    }

    updateProducto(producto, productoId){
        return axios.put(PRODUCTOS_URL + '/' + productoId, producto);
    }

    deleteProducto(productoId){
        return axios.delete(PRODUCTOS_URL + '/' + productoId);
    }
}

export default new ProductosServicio()