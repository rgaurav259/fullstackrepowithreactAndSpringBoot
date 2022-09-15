import axios from 'axios';
import React, { useState } from 'react'
import { Link, useNavigate } from 'react-router-dom';

export default function AddUser() {

    let navigate = useNavigate()

    const [user,setUser]=useState({
        name:"",
        userName:"",
        email:""
    })

    const{name,userName,email}=user

    const onInputChange = (e)=>{

        setUser({...user,[e.target.name]:e.target.value})

    };

    const onSubmit = async (e) => {
        e.preventDefault();

        await axios.post("http://localhost:8080/user",user)
        navigate("/")
    };


  return (
    <div className='container'>

        <div className='row'>
            <div className='col-md-6 offset-md-3 border rounded p-4 mt-2 shadow'>
                <h3 className='text-center m-4'> Register User</h3>

            <form onSubmit={(e)=> onSubmit(e)}>
                <div className='mb-3'>
                    <label htmlFor='name' className='form-label'> Name</label>
                    <input type={"text"} className="form-control" 
                    placeholder='Enter your Name'name='name'
                     value={name} onChange={(e)=>onInputChange(e)}/>

                </div>
                <div className='mb-3'>
                    <label htmlFor='userName' className='form-label'> UserName</label>
                    <input type={"text"} className="form-control" 
                    placeholder='Enter your userName'name='userName' 
                    value={userName} onChange={(e)=>onInputChange(e)}/>

                </div>
                <div className='mb-3'>
                    <label htmlFor='Enail' className='form-label'> Email</label>
                    <input type={"email"} className="form-control" 
                    placeholder='Enter your Email-Address'name='email'
                     value={email}  onChange={(e)=>onInputChange(e)}/>

                </div>

                <button type='submit' className=' btn btn-outline-primary'>Submit</button>

                <Link type='submit' className=' btn btn-outline-danger mx-2' to="/">Cancel</Link>
                


                </form>
            </div>

        </div>

    </div>
  )
}
