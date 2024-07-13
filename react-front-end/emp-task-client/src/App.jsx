import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import EmployeeComponent from './EmployeeComponent'

import { BrowserRouter,Routes,Route } from 'react-router-dom'

function App() {
  

  return (
    <>

    <BrowserRouter>

      <Routes>
        <Route path="/" element={<EmployeeComponent/>}/>
        <Route path="/emp" element={<EmployeeComponent/>}/>
        </Routes>
    </BrowserRouter>
     
    
    </>
  )
}

export default App
