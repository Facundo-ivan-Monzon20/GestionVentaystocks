import React, { Component } from 'react'

class HeaderComponente extends Component {
    constructor(props) {
        super(props)

        this.state = {
                 
        }
    }

    render() {
        return (
            <div>
                <header>
                    <nav className="navbar navbar-expand-md navbar-dark bg-dark">
                    <div><a href="https://javaguides.net" className="navbar-brand">Gestion de Venta y Stock</a></div>
                    </nav>
                </header>
            </div>
        )
    }
}

export default HeaderComponente