// src/components/CourseDetails.js

export default function CourseDetails(props) {
  const courses = props.courses;

  if (!courses || courses.length === 0) {
    return <p>No courses available</p>; // standard `if` condition
  }

  return (
    <div style={{ margin: "20px", borderLeft: "3px solid green", paddingLeft: "20px" }}>
      <h1>Course Details</h1>
      {courses.map((course) => (
        <div key={course.id}>
          <h3>{course.name}</h3>
          <p>{course.date}</p>
        </div>
      ))}
    </div>
  );
}
