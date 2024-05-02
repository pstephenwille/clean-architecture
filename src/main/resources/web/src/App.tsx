import React, {useEffect, useState} from 'react';
import logo from './logo.svg';
import './App.css';
import "./top-stories";
import {TopStories} from "./top-stories";

function App() {
  const [stories, setStories] = useState([]);

  useEffect(() => {
    fetch('http://localhost:8080/top-stories')
        .then(resp => resp.json())
        .then(data => setStories(data));
  }, [])


    return (
        <div className="App">
            <header className="App-header">
                <img src={logo} className="App-logo" alt="logo"/>
                <TopStories stories={stories} title={'Hacker News Top Stories'} />
                <a
                    className="App-link"
                    href="https://reactjs.org"
                    target="_blank"
                    rel="noopener noreferrer"
                >
                    Learn React
                </a>
            </header>
        </div>
    );
}

export default App;
