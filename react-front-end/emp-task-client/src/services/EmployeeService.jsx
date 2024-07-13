import axios from 'axios'

const REST_API_URL = "http://localhost:8080/api/emp";

export const getEmpById = (id) =>{

    return axios.get(REST_API_URL+"/"+id);

}

export const createOrUpdateEmp = (emp) =>{

    return axios.post(REST_API_URL+"/create",emp);
}