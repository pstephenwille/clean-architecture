import React, {useEffect, useState} from 'react';
import {Comments} from "./comments";

interface TopStoriesProps {
    stories: any[]
    title: string
}

export const TopStories: React.FC<TopStoriesProps> = ({stories, title}, deprecatedLegacyContext) => {

    useEffect(() => {
        console.log('%c...top-stories', 'color:gold')
    }, [])

    return (
        <div>
            <h4>{title}</h4>
            {stories.map((story: any, idx) => {
                return (
                    <div key={idx}>
                        <ul>
                            <li><span className={'label'}>Type:</span> {story.type}</li>
                            <li><span className={'label'}>Title:</span> {story.title}</li>
                            <li><span className={'label'}>By:</span> {story.by}</li>
                        </ul>
                        <Comments parentId={story.id} kids={story.kids}/>
                    </div>)
            })}
        </div>
    )
}

