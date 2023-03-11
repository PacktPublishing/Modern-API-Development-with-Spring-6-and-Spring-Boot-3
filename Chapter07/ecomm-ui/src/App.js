import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import Header from "./components/Header";
import Footer from "./components/Footer";
import ProductList from "./components/ProductList";
import Login from "./components/Login";
import useToken from "./hooks/useToken";
import Cart from "./components/Cart";
import ProductDetail from "./components/ProductDetail";
import NotFound from "./components/NotFound";
import Auth from "./api/Auth";
import { CartContextProvider } from "./hooks/CartContext";
import Orders from "./components/Orders";

function App() {
  const { token, setToken } = useToken();
  const auth = new Auth(token, setToken);
  const LoginComponent = (props) => (
    <Login {...props} uri="/login" auth={auth} />
  );

  const ProductListComponent = (props) => <ProductList auth={auth} />;
  return (
    <div className="flex flex-col min-h-screen h-full ">
      <Router>
        <Header userInfo={token} auth={auth} />
        <div className="flex-grow flex-shrink-0 p-4">
          <CartContextProvider>
            <Routes>
              <Route path="/" exact element={<ProductListComponent />} />
              <Route
                path="/login"
                element={token ? <ProductListComponent /> : <LoginComponent />}
              />
              <Route
                path="/cart"
                element={token ? <Cart auth={auth} /> : <LoginComponent />}
              />
              <Route
                path="/orders"
                element={token ? <Orders auth={auth} /> : <LoginComponent />}
              />
              <Route
                path="/products/:id"
                element={<ProductDetail auth={auth} />}
              />
              <Route path="*" exact element={<NotFound />} />
            </Routes>
          </CartContextProvider>
        </div>
        <Footer />
      </Router>
    </div>
  );
}

export default App;
