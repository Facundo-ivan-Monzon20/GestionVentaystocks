import React, { Component } from 'react'
import ProductosServicio from '../servicios/ProductosServicio'

class VerProductoComponente extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            producto: {}
        }
    }

    componentDidMount(){
        ProductosServicio.getProductoById(this.state.id).then( res => {
            this.setState({producto: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> Ver detalles del Producto</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> Nombre: </label>
                            <div> { this.state.producto.name }</div>
                        </div>
                        <div className = "row">
                            <label> Precio: </label>
                            <div> { this.state.producto.price }</div>
                        </div>
                        <div className = "row">
                            <label> Stock: </label>
                            <div> { this.state.producto.stocks }</div>
                        </div>
                    </div>

                </div>
            </div>
        )
    }
}

export default VerProductoComponente