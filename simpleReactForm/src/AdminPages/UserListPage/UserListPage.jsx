import React from "react";
import axios from "axios";
import { useState, useEffect } from "react";

function UserListPage() {
  {
    /* On the top will have an ADD User Button, redirects to RegisterPage */
  }
  const URL = "http://localhost:8080";

  const [userData, setUserData] = useState([]);
  useEffect(() => {
    axios
      .get(URL + "/users/getAll", {
        auth: {
          username: "Barny",
          passoword: "password",
        },
      })
      .then((response) => {
        debugger
        setUserData(response.data);
      })
      .catch((e) => {
        console.log(e);
      });
  }, []);

  {
    /* table that shows all Users 
            each record will have a delete icon on the right 
            delete button will give a pop up for deletion
            
        */
  }
  <div className="container">
    <table className="responsive-table">
      <caption>All students</caption>
      <thead>
        <tr>
          <th scope="col">ID</th>
          <th scope="col">Username</th>
          <th scope="col">Role</th>
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
  </div>;
}

export default UserListPage;
