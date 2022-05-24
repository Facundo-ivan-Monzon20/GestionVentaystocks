import { useState, useEffect } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
// import './Productos.css'

function Productos() {
	const url = 'http://localhost:8080/api/products/listproducts'
	const [producto, setProducto] = useState()
	const fetchApi = async () => {
		const response = await fetch(url)
		const responseJSON = await response.json()
		setProducto(responseJSON)
	}
	useEffect(() => {
		fetchApi()
	}, [])
	
	return (
		<div className='container-xl'>			      
            <h1>Productos</h1>
            <div className="row justify-content-center">
                <div className="col">
                    <h2>Nombre</h2>
                </div>
                <div className="col">
                    <h2>Precio</h2>
                </div>
                <div className="col">
                    <h2>Stock</h2>
                </div>
            </div>
            {/* LISTA PRODUCTOS */} 				
                { !producto ? 'Cargando...' :
                producto.map( (producto, index)=>{
                    return	<div className="row justify-content-center">
                        <div className="col">
                            {producto.name} 
                        </div>
                        <div className="col">
                            {producto.price}
                        </div>
                        <div className="col">
                            {producto.stock}
                        </div>
                      </div>
                })
                }				        		
		</div>
            	
	);
}

export default Productos