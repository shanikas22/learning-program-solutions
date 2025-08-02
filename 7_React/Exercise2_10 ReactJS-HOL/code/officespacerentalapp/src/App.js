// src/App.js
import './App.css';

function App() {

  const heading = "Office Space";

  const imgsrc = "https://plus.unsplash.com/premium_photo-1661931749081-23d69ddb62d1?q=80&w=1283&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D";
 // you can use any office image
  const offices = [
    { Name: "DBS", Rent: 50000, Address: "Chennai" },
    { Name: "WeWork", Rent: 75000, Address: "Bangalore" },
    { Name: "CoWrks", Rent: 55000, Address: "Hyderabad" }
  ];

  return (
    <div style={{ textAlign: "center" }}>
      <h1>{heading} , at Affordable Range</h1>
      <img src={imgsrc} width="25%" height="25%" alt="Office Space" />

      {offices.map((item, index) => {
        const colorClass = item.Rent <= 60000 ? "textRed" : "textGreen";
        return (
          <div key={index} style={{ margin: "20px" }}>
            <h2>Name: {item.Name}</h2>
            <h3 className={colorClass}>Rent: Rs. {item.Rent}</h3>
            <h3>Address: {item.Address}</h3>
          </div>
        );
      })}
    </div>
  );
}

export default App;
