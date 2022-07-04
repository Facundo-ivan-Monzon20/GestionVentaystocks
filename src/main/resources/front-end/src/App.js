import React from 'react';
import './App.css';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom'
import HeaderComponente from './componentes/HeaderComponente';
import FooterComponente from './componentes/FooterComponente';
import CrearProducto from './componentes/CrearProducto';
import ListarProductos from './componentes/ListarProductos';
import ActualizarProducto from './componentes/ActualizarProducto';
import VerProducto from './componentes/VerProducto';

function App() {
  return (
    <div>
        <Router>
              <HeaderComponente />
                <div className="container">
                    <Switch> 
                        <Route path = "/" exact component = {ListarProductos}></Route>
                        <Route path = "/productos" component = {ListarProductos}></Route>
                        <Route path = "/crear-producto/:id" component = {CrearProducto}></Route>
                        <Route path = "/ver-producto/:id" component = {VerProducto}></Route>
                        <Route path = "/actualizar-producto/:id" component = {ActualizarProducto}></Route>
                    </Switch>
                </div>
              <FooterComponente />
        </Router>
    </div>
  );
}

export default App;