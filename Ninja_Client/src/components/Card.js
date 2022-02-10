import React from "react";
import Ninja from "./Ninja";
import axios from "axios";

export default class Card extends React.Component {
  constructor() {
    super();
    this.state = {
      result: "",
      errorMessage: ""
    };

    this.fetchNinjas = this.fetchNinjas.bind(this);
  }

  componentDidMount() {
    this.fetchNinjas();
  }

  fetchNinjas() {
    axios
      .get("http://localhost:8080/api/ninjas")
      .then(response => {
        this.setState({
          result: response.data,
          errorMessage: ""
        });
        console.log(this.state.result);
      })
      .catch(error => {
        if (error.response) {
          this.setState({
            errorMessage: error.response.data.message,
            result: ""
          });
        } else {
          this.setState({ errorMessage: error.message, result: "" });
        }
      });
  }

  render() {
    return (
      <div className="pt-4">
        <h3 className="text-center text-dark pb-2">Ninja <span className="text-dark">Details</span></h3>
        {this.state.result
          ? this.state.result.map(ninja => <Ninja key={ninja.id} ninja={ninja} />)
          : null}
        {this.state.errorMessage ? (
          <h4 className="text-danger text-center">{this.state.errorMessage}</h4>
        ) : null}
      </div>
    );
  }
}
