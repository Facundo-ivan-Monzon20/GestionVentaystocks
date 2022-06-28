import React, { Component } from 'react'

class FooterComponente extends Component {
    constructor(props) {
        super(props)

        this.state = {
                 
        }
    }

    render() {
        return (
            <div>
                <footer className = "footer">
                    <span className="text-muted">Bruno Aramburu, Facundo Monzon, Daniela Togachensko</span>
                </footer>
            </div>
        )
    }
}

export default FooterComponente
