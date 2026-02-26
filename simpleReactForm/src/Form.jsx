import "./styles.css";
import React, { useState } from "react";
import axios from "axios";

export default function Form() {
  const [values, setValues] = useState({
    username: "",
    password: "",
    role: "",
  });

  const handleInputChange = (event) => {
    /* event.persist(); NO LONGER USED IN v.17*/
    event.preventDefault();

    const { name, value } = event.target;
    debugger;
    setValues((values) => ({
      ...values,
      [name]: value,
    }));
  };

  const [submitted, setSubmitted] = useState(false);
  const [valid, setValid] = useState(false);

  const URL="http://localhost:8080";
  const handleSubmit = () => {
    axios
      .post(URL+"/users/save", values)
      .then(function (response) {
        console.log(response);
      })
      .catch(function (error) {
        console.log(error);
      });
  };


  return (
    <div className="form-container">
      <form className="register-form" onSubmit={handleSubmit}>
        <div class="formbold-form-title">
          <h2 class="">Register now</h2>
          <p>Please enter your username and password to register</p>
        </div>

        <div class="formbold-input-flex">
          <div>
            <label for="username" class="formbold-form-label">
              {" "}
              Username{" "}
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
              Password{" "}
            </label>
            <input
              type="password"
              name="password"
              id="password"
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
  );
}
