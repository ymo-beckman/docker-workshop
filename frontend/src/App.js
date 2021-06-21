import logo from './logo.svg';

import react, { Component } from 'react';
import './App.css';

class App extends Component {
  calculate = () => {
    const num = this.refs.ifd_num.value;
    const base_url = `/backend/calculate?number=${num}`;

    this.setState({
      result: '--'
    })

    fetch(base_url, {
      method: 'get',
      headers: new Headers({
        'Content-Type': 'application/json'
      })
    }).then(res => res.text())
    .then(res => this.setState({
      result: res,
    }));
  }

  checkNumber = () => {
    if (this.refs) {
      const num = this.refs.ifd_num.value;
      if (parseInt(num) >= 1_000_000_000) {
        this.refs.ifd_num.value = 1_000_000_000;
      }
    }
  }

  render() {
    return (
      <div className="App">
        <header className="App-header">
          <input ref="ifd_num" type="number" maxLength="10" onChange={this.checkNumber} />
          <button onClick={this.calculate}>平方</button>
          <label>{this.state ? this.state.result : "--"}</label>
        </header>
      </div>
    );
  }
}

export default App;
