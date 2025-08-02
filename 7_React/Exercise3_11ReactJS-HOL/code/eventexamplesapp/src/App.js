import React, { useState } from "react";
import CurrencyConvertor from "./CurrencyConvertor";

function App() {
  const [count, setCount] = useState(1);

  // method to increment
  const incrementCounter = () => {
    setCount(count + 1);
  };

  // method to display hello message
  const sayHello = () => {
    alert("Hello from the increment button!");
  };

  // combined method for increment + hello
  const handleIncrement = () => {
    incrementCounter();
    sayHello();
  };

  // decrement method
  const decrementCounter = () => {
    setCount(count - 1);
  };

  // welcome method
  const sayWelcome = (msg) => {
    alert(msg);
  };

  // synthetic event method
  const handleClick = () => {
    alert("I was clicked");
  };

  return (
    <div style={{ margin: "20px" }}>
      <h2>{count}</h2>
      <button onClick={handleIncrement}>Increment</button>
      <button onClick={decrementCounter}>Decrement</button>
      <br />
      <br />
      <button onClick={() => sayWelcome("Welcome!")}>Say welcome</button>
      <br />
      <br />
      <button onClick={handleClick}>Click on me</button>
      <br />
      <br />
      <CurrencyConvertor />
    </div>
  );
}

export default App;
