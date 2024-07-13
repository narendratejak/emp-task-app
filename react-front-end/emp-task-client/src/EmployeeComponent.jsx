import React, { useState } from 'react'
import { createOrUpdateEmp, getEmpById } from './services/EmployeeService';
import { useNavigate } from 'react-router-dom';


const EmployeeComponent = () => {
  const [employeeId, setEmployeeId] = useState('');
  const [employeeDetails, setEmployeeDetails] = useState(null);
  const [errorMessage, setErrorMessage] = useState('');
  const navigate = useNavigate();

  const handleSearch = async () => {
    setErrorMessage('');

    getEmpById(employeeId)
      .then((res) => {
        if (res.data === '') {
          setErrorMessage('Data not found');
          setEmployeeDetails(null);
        } else {
          setEmployeeDetails({
            id: res.data.id,
            name: res.data.name,
            deptName: res.data.dept.deptName,
            hireDate: new Date(res.data.hireDate).toISOString().split('T')[0],
            sal: res.data.sal,
            dept: {
              id: res.data.dept.id,
            },
          });
        }
      })
      .catch((error) => {
        console.log(error);
      });
  };

  const handleUpdate = async () => {
    createOrUpdateEmp(employeeDetails)
      .then(() => {
        setEmployeeDetails(null);
        alert('Employee Updated Successfully');
        navigate('/');
      })
      .catch(() => {
        setEmployeeDetails(null);
        setErrorMessage('Something went wrong');
      });
  };

  const handleInputChange = (field, value) => {
    setEmployeeDetails({ ...employeeDetails, [field]: value });
  };

  return (
    <div className="container mt-5">
      <div className="card shadow-sm mb-4">
        <div className="card-body">
          <h5 className="card-title">Employee Search</h5>
          <div className="form-group">
            <label htmlFor="employeeId">Employee ID</label>
            <input
              type="text"
              className="form-control"
              id="employeeId"
              value={employeeId}
              onChange={(e) => setEmployeeId(e.target.value)}
            />
            <button className="btn btn-primary mt-3" onClick={handleSearch}>
              Search
            </button>
          </div>
          {errorMessage && <p className="text-danger mt-2">{errorMessage}</p>}
        </div>
      </div>

      {employeeDetails && (
        <div className="card shadow-sm">
          <div className="card-body">
            <h5 className="card-title">Employee Details</h5>
            <div className="form-group mb-3">
              <label htmlFor="employeeName">Employee Name</label>
              <input
                type="text"
                className="form-control"
                id="employeeName"
                value={employeeDetails.name}
                readOnly
              />
            </div>
            <div className="form-group mb-3">
              <label htmlFor="department">Department</label>
              <input
                type="text"
                className="form-control"
                id="department"
                value={employeeDetails.deptName}
                readOnly
              />
            </div>
            <div className="form-group mb-3">
              <label htmlFor="hireDate">Hire Date</label>
              <input
                type="date"
                className="form-control"
                id="hireDate"
                value={employeeDetails.hireDate}
                onChange={(e) => handleInputChange('hireDate', e.target.value)}
              />
            </div>
            <div className="form-group mb-3">
              <label htmlFor="salary">Salary</label>
              <input
                type="text"
                className="form-control"
                id="salary"
                value={employeeDetails.sal}
                onChange={(e) => handleInputChange('sal', e.target.value)}
              />
            </div>
            <button className="btn btn-primary mt-3" onClick={handleUpdate}>
              Update
            </button>
          </div>
        </div>
      )}
    </div>
  );
}

export default EmployeeComponent