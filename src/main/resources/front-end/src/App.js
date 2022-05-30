import "./App.css";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import Inicio from "./componentes/Inicio";
import Productos from "./componentes/Productos";

function App() {
  return (
    <Router>
      <div>
        <Switch>
          <Route exact={true} path="/productos">
            <Productos />
          </Route>
          {/* <Route exact={true} path="/signup">
              <SignUpScreen />
            </Route> */}
          <Route exact={true} path="/">
            <Inicio />
          </Route>
          <Route path="*">
            <div>
              <h1>404</h1>
            </div>
          </Route>
        </Switch>
      </div>
    </Router>
  );
}

export default App;
