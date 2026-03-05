import { Link } from "react-router-dom";

function Navbar(){

    return <div>
        <Link to="/">Home</Link>
        <Link to="/admin/lessons">Lessons</Link>
        <Link to="/admin/assignment">Assignment</Link>
    </div>

}

export default Navbar;