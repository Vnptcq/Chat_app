import React, { useState, useEffect } from "react";
import * as Yup from "yup";
import axios from "axios";
import { signupFailed,signupStart,signupSuccess } from "../redux/authSlice";
import { useFormik } from "formik";
import { useSelector } from "react-redux";
import { Link, useNavigate } from "react-router-dom";
import "../assets/css/SignUp.css";
import "../assets/bootstrap/css/bootstrap.min.css";
import "../assets/fonts/font-awesome.min.css";
import "../assets/fonts/themify-icons.css";
import "../assets/owlcarousel/css/owl.carousel.css";
import "../assets/owlcarousel/css/owl.theme.css";
import { useDispatch } from "react-redux";
import { signupUser } from "../redux/apiRequest";




const SignUp = () => {
  
  const dispatch = useDispatch();
  const navigate = useNavigate();
  const { isFetching, error, errorMessage } = useSelector((state) => state.auth.signup);

  const formik = useFormik({
    initialValues: {
      username: "",
      email: "",
      password: "",
      confirmedPassword:""
    },
    validationSchema: Yup.object({
      username: Yup.string()
        .required("Required")
        .min(4, "Must be 4 characters or more"),
      email: Yup.string()
        .required("Required")
        .matches(
          /^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/,
          "Please enter a valid email address"
        ),
      password: Yup.string()
        .required("Required")
        .matches(
          /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[!@#$%^&*()_+])[A-Za-z\d][A-Za-z\d!@#$%^&*()_+]{7,19}$/,
          "Password must be 7-19 characters and contain at least one letter, one number and a special character"
        ),
      confirmedPassword: Yup.string()
        .required("Required")
        .oneOf([Yup.ref("password"), null], "Password must match"),
    }),
    onSubmit: (values)=>{      
      const { confirmedPassword, ...newUser} = values;
      
      signupUser(newUser,dispatch,navigate);
    }
    });

  return (
    <div>
      {/* Section Top */}
      <section className="section-top">
        <div className="container">
          <div className="col-lg-10 offset-lg-1 text-center">
            <div
              className="section-top-title wow fadeInRight"
              data-wow-duration="1s"
              data-wow-delay="0.3s"
            >
              <h1>Register Page</h1>
              <ul>
                <li>
                  <a href="/">Home</a>
                </li>
                <li> / Register</li>
              </ul>
            </div>
          </div>
        </div>
      </section>

      {/* Register Form */}
      <section className="login_register section-padding">
        <div className="container">
          <div className="row">
            <div className="col-lg-6 offset-lg-3 col-xs-12">
              <div className="register">
                <h4 className="login_register_title">Create a new account:</h4>
                <form onSubmit={formik.handleSubmit}>
                  <div className="form-group">
                    <label>Username</label>
                    <input
                      type="text"
                      className="form-control"
                      name="username"
                      placeholder="Enter your username"
                      value={formik.values.username}
                      onChange={formik.handleChange}
                    />
                    {formik.errors.username && (
                      <h1 className="errorMsg"> {formik.errors.username} </h1>
                    )}
                  </div>
                  <div className="form-group">
                    <label>Email Address</label>
                    <input
                      type="email"
                      className="form-control"
                      name="email"
                      placeholder="Enter your email"
                      value={formik.values.email}
                      onChange={formik.handleChange}
                    />
                    {formik.errors.email && (
                      <h1 className="errorMsg"> {formik.errors.email} </h1>
                    )}
                  </div>
                  <div className="form-group">
                    <label>Password</label>
                    <input
                      type="password"
                      className="form-control"
                      name="password"
                      placeholder="Enter your password"
                      value={formik.values.password}
                      onChange={formik.handleChange}
                    />
                    {formik.errors.password && (
                      <h1 className="errorMsg"> {formik.errors.password} </h1>
                    )}
                  </div>
                  <div className="form-group">
                    <label>Confirm Password</label>
                    <input
                      type="password"
                      className="form-control"
                      name="confirmedPassword"
                      placeholder="Enter your password"
                      value={formik.values.confirmedPassword}
                      onChange={formik.handleChange}
                    />
                    {formik.errors.confirmedPassword && (
                      <h1 className="errorMsg">
                        {" "}
                        {formik.errors.confirmedPassword}{" "}
                      </h1>
                    )}
                  </div>
                  <div className="form-group col-lg-12">

                    <button className="btn_one" type="submit" disabled={isFetching}>
                      {isFetching ? "Registering..." : "Register now"}
                    </button>

                    {error && <p className="errorMsg">{errorMessage || "Signup failed. Please try another email again."}</p>}
                  </div>
                  
                </form>

                <p>
                  Already have an account? <Link to="/login">Login</Link>
                </p>
              </div>
            </div>
          </div>
        </div>
      </section>
    </div>
  );
};

export default SignUp;
