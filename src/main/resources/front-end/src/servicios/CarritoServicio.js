import axios from 'axios';

const CARRITO_URL = "http://localhost:8080/api/carrito";

class CarritoServicio {
    
    httpGet = async (endpoint) => {
        return axios.get(CARRITO_URL + endpoint, {
        })
    }

    httpDelete = async (endpoint) => {
        return axios.get(CARRITO_URL + endpoint, {
        })
    }
    
    httpPost = async (endpoint, data) => {
    return axios.post(CARRITO_URL + endpoint, data, {
        })
    }

    httpPut = async (endpoint, data) => {
    return axios.put(CARRITO_URL + endpoint, data, {
        })
    }
}

export default new CarritoServicio()