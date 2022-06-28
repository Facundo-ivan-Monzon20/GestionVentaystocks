import axios from 'axios';

const PRODUCTOS_URL = "http://localhost:8080/api/productos";

class ProductosServicio {

    deleteProducto(productoId){
        return axios.delete(PRODUCTOS_URL + '/' + productoId);
    }

    httpPost = async (endpoint, data) => {
        return axios.post(PRODUCTOS_URL + endpoint, data, {
        })
    }
    
    httpPut = async (endpoint, data) => {
        return axios.put(PRODUCTOS_URL + endpoint, data, {
        })
    }

    httpGet = async (endpoint) => {
        return axios.get(PRODUCTOS_URL + endpoint, {
        })
    }

    getProductoById(productoId){
        return axios.get(PRODUCTOS_URL + '/' + productoId);
    }
}

export default new ProductosServicio()