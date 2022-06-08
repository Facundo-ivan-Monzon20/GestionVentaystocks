import React, { Component } from 'react'
import ProductosServicios from '../servicios/ProductosServicio'

class ListarProductosComponente extends Component {
    constructor(props) {
        super(props)

        this.state = {
                productos: []
        }
        this.crearProducto = this.crearProducto.bind(this);
        this.editProducto = this.editProducto.bind(this);
        this.deleteProducto = this.deleteProducto.bind(this);
    }

    deleteProducto(id){
        ProductosServicios.deleteProducto(id).then( res => {
            this.setState({productos: this.state.productos.filter(Producto => Producto.id !== id)});
        });
    }
    viewProducto(id){
        this.props.history.push(`/ver-producto/${id}`);
    }
    editProducto(id){
        this.props.history.push(`/actualizar-producto/${id}`);
    }

    componentDidMount(){
        ProductosServicios.getProductos().then((res) => {
            this.setState({ productos: res.data});
        });
    }

    crearProducto(){
        this.props.history.push('/crear-producto/_crear');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">Lista de Productos</h2>
                 <div className = "row">
                    <button className="btn btn-primary" onClick={this.crearProducto}> Agregar Producto</button>
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
                                    this.state.productos.map(
                                        Producto => 
                                        <tr key = {Producto.id}>
                                             <td> {Producto.name} </td>   
                                             <td> {Producto.price}</td>
                                             <td> {Producto.stocks}</td>
                                             <td>
                                                 <button onClick={ () => this.editProducto(Producto.id)} className="btn btn-info">Actualizar </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteProducto(Producto.id)} className="btn btn-danger">Borrar </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewProducto(Producto.id)} className="btn btn-info">Ver </button>
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
}

export default ListarProductosComponente
