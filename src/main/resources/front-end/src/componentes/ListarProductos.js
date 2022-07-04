import {useState, useEffect} from 'react';
import ProductosServicios from '../servicios/ProductosServicio';
import React from 'react'

function ListarProductosComponente (props) {
    
    const [productos, setProductos] = useState([])
  
    const fetchProductos = () => {
        ProductosServicios.httpGet('')
            .then((res) => setProductos(res.data))
    }
  
    useEffect(fetchProductos, [])

    const deleteProducto = (id) => {
        ProductosServicios.deleteProducto(id)
        .then(fetchProductos);
        props.history.push('/productos');
    }
    const viewProducto = (id) =>{
        props.history.push(`/ver-producto/${id}`);
    }
    const editProducto = (id) =>{
        props.history.push(`/actualizar-producto/${id}`);
    }

    const createProducto = () =>{
        props.history.push('/crear-producto/_crear');
    }

    return (
        <div>
            <h2 className="text-center">Lista de Productos</h2>
            <div className = "row">
            <button className="btn btn-primary" onClick={createProducto}> Agregar Producto</button>
            </div>
            <br></br>
            <div className = "row">
                <table className = "table table-striped table-bordered">
                    <thead>
                        <tr>
                            <th> Nombre</th>
                            <th> Precio</th>
                            <th> Stock</th>
                            <th> Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            productos.map(
                                productos => 
                                
                                <tr key={productos.id}>
                                        <td> {productos.name} </td>   
                                        <td> {productos.price}</td>
                                        <td> {productos.stocks}</td>
                                        <td>
                                            <button onClick={ () => editProducto(productos.id)} className="btn btn-info">Actualizar </button>
                                            <button style={{marginLeft: "10px"}} onClick={ () => deleteProducto(productos.id)} className="btn btn-danger">Borrar </button>
                                            <button style={{marginLeft: "10px"}} onClick={ () => viewProducto(productos.id)} className="btn btn-info">Ver </button>
                                        </td>
                                </tr>              
                            )
                        }
                    </tbody>
                </table>
            </div>
        </div>
    )
}

export default ListarProductosComponente
