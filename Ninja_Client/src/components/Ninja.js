import React from "react";
import Redirect from "../../node_modules/react-router-dom/Redirect";
import './Ninja.css';
import EditNinja from './EditNinja';

class Ninja extends React.Component {
  constructor() {
    super();
    this.state = {
      edit: null
    };
  }

  edit = () => {
    this.setState({ edit: true });
    console.log(this.state.edit);
  };

  render() {
    var note = null;
    var redirect = null;

    if (this.state.edit) {
      <EditNinja id={this.props.ninja.id} />
      redirect = <Redirect to={"/edit/" + this.props.ninja.id} />;
      console.log("TEST FOR ID - NINJA: " + this.props.id);
    }

    return (
      <div className="card" style={{ width: 220 }}>
        <img
          className="card-img-top"
          src={require("../assets/emp1.PNG")}
          height="200"
          alt="profile pic"
        />
        <div className="card-body">
          <h5 className="card-title text-center">{this.props.ninja.name}</h5>
          <p className="card-text">
            <span><strong>ID: </strong>{this.props.ninja.id}</span>
            <br />
            <span><strong>Name: </strong>{this.props.ninja.name}</span> {note}
            <br />
            <span><strong>Title: </strong>{this.props.ninja.designation}</span>
            <br />
          </p>
          <button type="button" className="a rounded btn-primary border-primary" onClick={this.edit}>
            Edit
          </button>{" "}
          {redirect}
        </div>
      </div>
    );
  }
}

export default Ninja;
