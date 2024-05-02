import React, {useEffect, useState} from 'react';
import {Comments} from "./comments";


export const TopStories: React.FC = () => {
    const [stories, setStories] = useState([]);

    useEffect(() => {
        fetch('http://localhost:8080/top-stories')
            .then(resp => resp.json())
            .then(data => setStories(data));
    }, [])

    return (
        <div>
            {stories.map((story: any, idx) => {
                return (
                    <div>
                        <ul key={idx}>
                            <li>Type: {story.type}</li>
                            <li>Title: {story.title}</li>
                            <li>By: {story.by}</li>
                        </ul>
                        <Comments />
                    </div>)
            })}
        </div>
    )
}

