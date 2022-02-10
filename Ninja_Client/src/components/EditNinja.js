import React from "react";
import axios from "axios";
import { Link } from 'react-router-dom'; 

class EditNinja extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      id: this.props.id,
      name: this.props.name,
      designation: this.props.designation,
      formErrors: {
        ninjaErr: ""
      },
      fieldValidity: {
        name: false,
      },
      formValid: false,
      successMessage: ""
    };
  }

   //ValidateId()
   validateId = e => {
    let id = e.target.value;
    this.setState({ id: id });
    var formErrors = this.state.formErrors;
    var fieldValidity = this.state.fieldValidity;
    this.setState({ id: e.target.value });
    console.log(id.length);
    if (id < 1 || id > 9999) {
      formErrors.idErr = "Ninja ID must be between 1 and 9999";
      fieldValidity.id = false;
    } else {
      formErrors.idErr = "";
      fieldValidity.id = true;
    }  
     this.setState({ formErrors: formErrors });
     this.setState({ formValid: fieldValidity.name && fieldValidity.id });
  };

  //ValidateName()
  validateName = e => {
    const name = e.target.value;
    var formErrors = this.state.formErrors;
    var fieldValidity = this.state.fieldValidity;
    this.setState({ name: e.target.value });
    console.log(name.length);
    if (name.length < 6) {
      formErrors.ninjaNameErr = "A Ninja name must be at least 6 chars";
      fieldValidity.name = false;
    } else {
      formErrors.ninjaNameErr = "";
      fieldValidity.name = true;
    }
    this.setState({ fieldValidity: fieldValidity });
    this.setState({ formValid: fieldValidity.name && fieldValidity.id });
  };

  validateDesignation = e => {
    let designation = e.target.value;
    this.setState({ designation: designation });
  };

  updateNinja= () => {

    var formJSON = {
      id: this.state.id,
      name: this.state.name,
      designation: this.state.designation,
    };
    
    axios
      .put( "http://localhost:8080/api/edit/", formJSON )
      .then(response => {
        this.setState({ successMessage: response.data.message, error: "" });
        console.log(response.data);
      })
      .catch(error => {
        if (error.response) {
          this.setState({ error: error.response.data.message, success: "" });
        } else {
          this.setState({ error: error.message, success: "" });
        }
      });
  };

  render() {
    return (
      <div style={{ width: 500, margin: "0px auto" }}>
        <h3 className="text-center text-dark pt-4">
          The selected ID is {}
        </h3>
        <form>
      {/*    <div className="form-group">
            <label>Ninja Id: </label>
            <input
              className="form-control"
              onChange={this.validateId}
              value={this.props.match.params.id}
            />
    </div>*/}
          <div className="form-group">
            <label>Name:</label>
            <input 
              className="form-control"
              onChange={this.validateName}
              value={this.state.name}
            />
          </div>
          <span className="text-danger">
            {this.state.formErrors.ninjaErr}
          </span>

          <div className="form-group">
            <label>Designation:</label>
            <input
              className="form-control"
              onChange={this.validateDesignation}
              value={this.state.designation}
            />
          </div>
          {<span className="text-danger">{this.state.formErrors.ninjaDesignationErr}</span>}

          <Link to="/card"
            type="button"
            onClick={this.updateNinja}
            className="btn btn-success"
            disabled={!this.state.formValid}
          >
           Update
          </Link>
          <span className="text-success border border-dark">{this.state.successMessage}</span>
        </form>
      </div>
    );
  }
}

export default EditNinja;
