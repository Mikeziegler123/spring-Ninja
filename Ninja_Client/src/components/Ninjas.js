import React from 'react';
import axios from 'axios';
import 'bootstrap/dist/css/bootstrap.min.css';

class Ninjas extends React.Component {
        constructor() {
            super()
            this.state = {
                ninjas: []
            }
        }
        componentDidMount() {
            this.setState({ isLoading: true });
            axios.get('http://localhost:8080/api/ninjas')
            .then(result => 
                this.setState({
                    ninjas: result.data,
                    isLoading: false
                })
            )
            .catch(error => 
                this.setState({
                    error,
                    isLoading: false
                })
            );
        }
        render() {
                if(this.state.isLoading) {
                    return "Loading..."
                }
                if(this.state.error) {
                    return <p>{this.state.error.message}</p>
                }
        return ( 
                <React.Fragment>
                        <div className='container-fluid m-3 p-3 justify-content-center pt-4 pb-2'>
                                <div className="row card col-md-12 border border-2 border-dark shadow-2-strong card-body p-0 border-info bg-dark text-light">
                                        <div className='col-lg-12 border border-5 border-info bg-dark text-light'>
                                        <h6 className='pt-1 text-light'>Registered Ninjas</h6>
                                                <div className="table-responsive  text-center table-scroll" data-mdb-perfect-scrollbar="true" style={{position: 'relative', eight: '700px'}}>
                                                        <table className='table table-dark mb-0 ' >
                                                                <thead style={{backgroundColor: '#393939'}}>
                                                                        <tr className='text-uppercase TableHead'>
                                                                                <th scope='col'>ID</th>
                                                                                <th scope='col'>Name</th>
                                                                                <th scope='col'>Designation</th>
                                                                        </tr>
                                                                </thead>
                                                                <tbody>
                                                                        {this.state.ninjas.map(ninja => {
                                                                        return (
                                                                        <tr>
                                                                                <td>{ninja.id}</td>
                                                                                <td>{ninja.name}</td>
                                                                                <td>{ninja.designation}</td>
                                                                        </tr>
                                                                                )
                                                                        })
                                                                        }
                                                                </tbody>
                                                        </table><br/><br/>

                                                </div>
                                        </div>
                                </div>
                        </div>
                </React.Fragment>
                )
        }
}
export default Ninjas;