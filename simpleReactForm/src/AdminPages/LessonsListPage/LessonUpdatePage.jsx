import React from "react";

// Need to pass the attribute of the lesson ID
function LessonUpdatePage(lessonID) {

// function to call api to get selected record


  // need function to handle submit form

  // useStates for lesson object , default value will be the database values
  const [values, setValues] = useState({
    username: "",
    password: "",
    role: "",
  });

  const [submitted, setSubmitted] = useState(false);
  const [valid, setValid] = useState(false);

  return (
    <>
      {/* Form with LessonTitle and LessonFile 
      
      (additional validation - uploader should only accept .jpg/.png files)
      submit button should be disabled until file is uploaded and title is provided
      */}
      <div className="form-container">
        <form className="register-form" onSubmit={handleSubmit}>
          <div class="formbold-form-title">
            <h2 class="">Add Lesson</h2>
            <p>Please Lesson Tite and URL to add lesson</p>
          </div>

          <div class="formbold-input-flex">
            <div>
              <label for="username" class="formbold-form-label">
                {" "}
                Title{" "}
              </label>
              <input
                type="text"
                name="username"
                id="username"
                class="formbold-form-input"
                value={values.username}
                onChange={handleInputChange}
              />
            </div>
            <div>
              <label for="password" class="formbold-form-label">
                {" "}
                Lesson URL{" "}
              </label>
              <input
                type="text"
                name="lessonURL"
                id="lessonURL"
                class="formbold-form-input"
                value={values.password}
                onChange={handleInputChange}
              />
            </div>
          </div>
          <div class="form-group">
            <label for="purpose" class="form-label">
              Select Student
            </label>
            <select
              name="role"
              id="role"
              class="form-select"
              onChange={handleInputChange}
            >
              <option value="">-- Select --</option>
              <option value="admin">Admin</option>
              <option value="student">Student</option>
            </select>
          </div>

          <button class="formbold-btn" type="button" onClick={handleSubmit}>
            Register Now
          </button>
        </form>
      </div>
    </>
  );
}

export default LessonUpdatePage;
