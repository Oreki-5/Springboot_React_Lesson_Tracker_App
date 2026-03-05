import React, { useEffect, useState } from "react";
import axios from "axios";
import "./listingPage.css";

export default function ListingPage() {
  const URL = "http://localhost:8080";

  const TEST = axios.get(URL + "/users/getAll");
  const [userData, setUserData] = useState([]);
  useEffect(() => {
    axios
      .get(URL + "/users/getAll")
      .then((response) => {
        setUserData(response.data);
      })
      .catch((e) => {
        console.log(e);
      });
  }, []);
  ;

  return (
    <div className="container">
      <table className="responsive-table">
        <caption>All students</caption>
        <thead>
          <tr>
            <th scope="col">ID</th>
            <th scope="col">Username</th>
            <th scope="col">Password</th>
            <th scope="col">Role</th>
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
  );
}
