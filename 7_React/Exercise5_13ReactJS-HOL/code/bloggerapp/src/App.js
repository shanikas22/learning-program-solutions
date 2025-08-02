import BookDetailss from "./components/BookDetailss";
import BlogDetails from "./components/BlogDetails";
import CourseDetails from "./components/CourseDetails";

// function App() {
//   const books = [
//     { id: 101, bname: "Master React", price: 670 },
//     { id: 102, bname: "Deep Dive into Angular 11", price: 800 },
//     { id: 103, bname: "Mongo Essentials", price: 450 },
//   ];

//   const blogs = [
//     { id: 1, title: "React Learning", author: "Stephen Biz", desc: "Welcome to learning React!" },
//     { id: 2, title: "Installation", author: "Schwezdneier", desc: "You can install React from npm." },
//   ];

//   const courses = [
//     { id: 1, name: "Angular", date: "4/5/2021" },
//     { id: 2, name: "React", date: "6/3/2021" },
//   ];

//   return (
//     <div style={{ display: "flex", justifyContent: "space-around", margin: "30px" }}>
//       <CourseDetails courses={courses} />
//       <BookDetailss books={books} />
//       <BlogDetails blogs={blogs} />
//     </div>
//   );
// }

function App() {
  const books = [
    { id: 101, bname: "Master React", price: 670 },
    { id: 102, bname: "Deep Dive into Angular 11", price: 800 },
    { id: 103, bname: "Mongo Essentials", price: 450 },
  ];

  const blogs = [
    { id: 1, title: "React Learning", author: "Stephen Biz", desc: "Welcome to learning React!" },
    { id: 2, title: "Installation", author: "Schwezdneier", desc: "You can install React from npm." },
  ];

  const courses = [
    { id: 1, name: "Angular", date: "4/5/2021" },
    { id: 2, name: "React", date: "6/3/2021" },
  ];

  return (
    <div style={{ display: "flex", justifyContent: "space-around", margin: "30px" }}>
      
      <div style={{ paddingRight: "30px" }}>
        <CourseDetails courses={courses} />
      </div>

      <div style={{ borderLeft: "3px solid green", paddingLeft: "30px", paddingRight: "30px" }}>
        <BookDetailss books={books} />
      </div>

      <div style={{  paddingLeft: "30px" }}>
        <BlogDetails blogs={blogs} />
      </div>
      
    </div>
  );
}


export default App;
