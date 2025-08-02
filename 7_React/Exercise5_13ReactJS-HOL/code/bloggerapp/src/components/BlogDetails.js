// src/components/BlogDetails.js

export default function BlogDetails(props) {
  const blogs = props.blogs;

  return (
    <div style={{ margin: "20px", borderLeft: "3px solid green", paddingLeft: "20px" }}>
      <h1>Blog Details</h1>
      {blogs && blogs.length > 0 && (
        blogs.map((blog) => (
          <div key={blog.id}>
            <h3>{blog.title}</h3>
            <h4>{blog.author}</h4>
            <p>{blog.desc}</p>
          </div>
        ))
      )}
    </div>
  );
}
