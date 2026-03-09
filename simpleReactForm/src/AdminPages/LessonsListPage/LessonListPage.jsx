import React from "react";

function LessonListPage() {
  // need function to fetch records via backend api

  // useStates for lesson records

  // function to delete record with provided ID

  return (
    <>
      {/* On the top will have an ADD LESSON Button, redirects to LessonAddPage */}

      {/* table that shows all lessons 
            each record will have a delete icon on the right 
            delete button will give a pop up for deletion
            lesson title will
            have a link to the lessonUpdatePage
        */}

      <div className="container">
        <table className="responsive-table">
          <caption>All Lessons</caption>
          <thead>
            <tr>
              <th scope="col">ID</th>
              <th scope="col">Title</th>
              <th scope="col">Url</th>
              <th scope="col">Action</th>
            </tr>
          </thead>
          <tbody id="records">
            {userData.map((user) => (
              <tr>
                <td>{user.id}</td>
                <td>{user.username}</td>
                <td>{user.password}</td>
                <td>{user.role}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </>
  );
}

export default LessonListPage;
