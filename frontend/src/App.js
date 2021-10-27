import { BrowserRouter, Route, Switch } from "react-router-dom";
import "./App.css";
import Detail from "./blogs/Detail";
import About from "./components/About";
import Contact from "./components/Contact";
import Home from "./components/Home";

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
