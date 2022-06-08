import React, { Component } from 'react'
import ProductosServicio from '../servicios/ProductosServicio';

class CrearProductoComponente extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
            name: '',
            price: '',
            stocks: ''
        }
        this.changenameHandler = this.changenameHandler.bind(this);
        this.changepriceHandler = this.changepriceHandler.bind(this);
        this.saveOrUpdateProducto = this.saveOrUpdateProducto.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_crear'){
            return
        }else{
            ProductosServicio.getProductoById(this.state.id).then( (res) =>{
                let Producto = res.data;
                this.setState({name: Producto.name,
                    price: Producto.price,
                    stocks : Producto.stocks
                });
            });
        }        
    }
    saveOrUpdateProducto = (e) => {
        e.preventDefault();
        let Producto = {name: this.state.name, price: this.state.price, stocks: this.state.stocks};
        console.log('Producto => ' + JSON.stringify(Producto));

        // step 5
        if(this.state.id === '_crear'){
            ProductosServicio.createProducto(Producto).then(res =>{
                this.props.history.push('/productos');
            });
        }else{
            ProductosServicio.updateProducto(Producto, this.state.id).then( res => {
                this.props.history.push('/productos');
            });
        }
    }
    
    changenameHandler= (event) => {
        this.setState({name: event.target.value});
    }

    changepriceHandler= (event) => {
        this.setState({price: event.target.value});
    }

    changeEmailHandler= (event) => {
        this.setState({stocks: event.target.value});
    }

    cancel(){
        this.props.history.push('/productos');
    }

    getTitle(){
        if(this.state.id === '_crear'){
            return <h3 className="text-center">Agregar Producto</h3>
        }else{
            return <h3 className="text-center">Actualizar Producto</h3>
        }
    }
    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                {
                                    this.getTitle()
                                }
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> Nombre: </label>
                                            <input placeholder="Nombre" name="name" className="form-control" 
                                                value={this.state.name} onChange={this.changenameHandler}/>
                                        </div>
                                        <div className = "form-group">
                                            <label> Precio: </label>
                                            <input placeholder="Precio" name="price" className="form-control" 
                                                value={this.state.price} onChange={this.changepriceHandler}/>
                                        </div>
                                        <div className = "form-group">
                                            <label> Stock: </label>
                                            <input placeholder="Stock" name="stocks" className="form-control" 
                                                value={this.state.stocks} onChange={this.changeEmailHandler}/>
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateProducto}>Guardar</button>
                                        <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Cancelar</button>
                                    </form>
                                </div>
                            </div>
                        </div>

                   </div>
            </div>
        )
    }
}

export default CrearProductoComponente
