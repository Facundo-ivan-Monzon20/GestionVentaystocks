import React from 'react';
import logo from './logo.svg';
import './App.css';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom'
import HeaderComponente from './componentes/HeaderComponente';
import FooterComponente from './componentes/FooterComponente';
import CrearProductoComponente from './componentes/CrearProductoComponente';
import ListarProductosComponente from './componentes/ListarProductosComponente';
import ActualizarProductoComponente from './componentes/ActualizarProductoComponente';
import VerProductoComponente from './componentes/VerProductoComponente';

function App() {
  return (
    <div>
        <Router>
              <HeaderComponente />
                <div className="container">
                    <Switch> 
                          <Route path = "/" exact component = {ListarProductosComponente}></Route>
                          <Route path = "/productos" component = {ListarProductosComponente}></Route>
                          <Route path = "/crear-producto/:id" component = {CrearProductoComponente}></Route>
                          <Route path = "/ver-producto/:id" component = {VerProductoComponente}></Route>
                          <Route path = "/actualizar-producto/:id" component = {ActualizarProductoComponente}></Route>
                    </Switch>
                </div>
              <FooterComponente />
        </Router>
    </div>
    
  );
}

export default App;