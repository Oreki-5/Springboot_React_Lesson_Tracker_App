import axios from "axios";
import { useEffect, useState } from "react";

export const LoginPage = () => {
  // useState for User object
  const [user, setUser] = useState({
    username: "",
    password: "",
  });

  const handleInputChange = (event) => {
    /* event.persist(); NO LONGER USED IN v.17*/
    event.preventDefault();

    const { name, value } = event.target;

    setUser((user) => ({
      ...user,
      [name]: value,
    }));
  };
  // function to handle submit
  const URL = "http://localhost:8080";

  const handleSubmit = () => {
    axios
      .post(URL + "/users/verify", user)
      .then(function (response) {
        console.log(response);
        if(response.status==200) alert("Login Successful!")
        else alert("Error!");
      })
      .catch(function (error) {
        console.log(error);
      });
  };
  // const handleSubmit = () => {
  //   axios
  //     .get(URL + "/users/verify", {
  //       auth: {
  //         Username: user.username,
  //         Passoword: user.password,
  //       },
  //     })
  //     .then(function (response) {
  //       debugger
  //       console.log(response);
  //       if (response.status == 200) {
  //         alert("Success!");
  //       } else {
  //         alert("Wrong Credentials!");
  //       }
  //     })
  //     .catch(function (error) {
  //       console.log(error);
  //     });
  // };
  const [submitted, setSubmitted] = useState(false);
  const [valid, setValid] = useState(false);

  return (
    <div className="form-container">
      <form className="register-form" onSubmit={handleSubmit}>
        <div class="formbold-form-title">
          <h2 class="">Login now</h2>
          <p>Please enter your username and password to Login</p>
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
              value={user.username}
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
              value={user.password}
              onChange={handleInputChange}
            />
          </div>
        </div>

        <button class="formbold-btn" type="button" onClick={handleSubmit}>
          Submit
        </button>
      </form>
    </div>
  );
};
