import {useState, useEffect} from 'react';
import ProductosServicios from '../servicios/ProductosServicio';

function CrearProductoComponente (props) {
    
    const [productos, setProductos] = useState([])
    const [name, setName] = useState([])
    const [price, setPrice] = useState([])
    const [stocks, setStocks] = useState([])
  
    const fetchProductos = () => {
        ProductosServicios.httpGet('')
            .then((res) => setProductos(res.data))
    }        
    
    const createProductos = (e) => {
        e.preventDefault()
        ProductosServicios.httpPost('/', {name: name, price: price, stocks: stocks})
            .then(fetchProductos)
            props.history.push('/productos');
            window.location.reload()
    } 

    const cancel = () => {
        props.history.push('/productos');
    }

    useEffect(fetchProductos, [])

    return (
        <div>
            <br></br>
                <div className = "container">
                    <div className = "row">
                        <div className = "card col-md-6 offset-md-3 offset-md-3">
                            <h2>
                            <div className='d-flex justify-content-center'>
                            Crear producto
                            </div>   
                            </h2>
                            <div className = "card-body">
                                <form>
                                    <div className = "form-group">
                                        <label> Nombre: </label>
                                        <input placeholder="Nombre" name="name" className="form-control" 
                                            value={name}  onChange={(e) => setName(e.target.value) }/>
                                    </div>
                                    <div className = "form-group">
                                        <label> Precio: </label>
                                        <input placeholder="Precio" name="price" className="form-control" 
                                            value={price}  onChange={(e) => setPrice(e.target.value) }/>
                                    </div>
                                    <div className = "form-group">
                                        <label> Stock: </label>
                                        <input placeholder="Stock" name="stocks" className="form-control" 
                                            value={stocks}  onChange={(e) => setStocks(e.target.value) }/>
                                    </div>

                                    <button className="btn btn-success" onClick={createProductos}>Guardar</button>
                                    <button className="btn btn-danger" onClick={cancel} style={{marginLeft: "10px"}}>Cancelar</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
        </div>
    )
}

export default CrearProductoComponente
