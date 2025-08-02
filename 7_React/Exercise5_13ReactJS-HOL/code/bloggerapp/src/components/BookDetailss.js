// src/components/BookDetails.js

export default function BookDetails(props) {
  const books = props.books;

  return (
    <div style={{ margin: "20px" }}>
      <h1>Book Details</h1>
      <ul>
        {books.length > 0 ? (
          books.map((book) => (
            <div key={book.id}>
              <h3>{book.bname}</h3>
              <h4>{book.price}</h4>
            </div>
          ))
        ) : (
          <p>No books available</p>
        )}
      </ul>
    </div>
  );
}
