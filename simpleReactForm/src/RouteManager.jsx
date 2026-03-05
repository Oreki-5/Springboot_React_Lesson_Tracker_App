import { BrowserRouter as Router ,Routes,Route,redirect } from "react-router-dom";
import { StudentRegisterForm } from "./AdminPages/StudentRegisterForm";
import { AllLessonListingPage } from "./AdminPages/AllLessonListingPage";
import { AllAssignmentListingPage } from "./AdminPages/AllAssignmentListingPage";
export const RouteManager = () =>{
    return(
        <Router>
            <Routes>

                <Route path="/" exact element={<StudentRegisterForm/>}/>
                <Route path="/admin/lessons" exact element={<AllLessonListingPage/>}/>
                <Route path="/admin/assignment" exact element={<AllAssignmentListingPage/>}/>

            </Routes>
        </Router>
    );

}