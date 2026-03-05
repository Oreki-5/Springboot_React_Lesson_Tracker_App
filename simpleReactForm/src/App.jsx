import "./App.css";
import { RouteManager } from "./RouteManager";
import Navbar from "./Components/Navbar";
import { Route, Routes } from "react-router-dom";
import { StudentRegisterForm } from "./AdminPages/StudentRegisterForm";
import { AllLessonListingPage } from "./AdminPages/AllLessonListingPage";
import { AllAssignmentListingPage } from "./AdminPages/AllAssignmentListingPage";

function App() {
  return (
    <>
      <Navbar />
      <Routes>
        <Route path="/" element={<StudentRegisterForm />} />
        <Route path="/admin/lessons" element={<AllLessonListingPage />} />
        <Route
          path="/admin/assignment"
          element={<AllAssignmentListingPage />}
        />
      </Routes>
    </>
  );
}

export default App;
