import logo from "./logo.svg";
import "./App.css";
import Home from "./components/Home";
import Contact from "./components/Contact";
import About from "./components/About";
import Detail from "./blogs/Detail";
import { BrowserRouter, Route, Switch } from "react-router-dom";

function App() {
  return (
    <div>
      <BrowserRouter>
        <Switch>
          <Route path="/contact/:id" component={Contact} exact />
          <Route path="/about" component={About} exact />
          <Route path="/details/:id" component={Detail} exact />
          <Route path="/" component={Home} />
        </Switch>
      </BrowserRouter>
    </div>
  );
}

export default App;
