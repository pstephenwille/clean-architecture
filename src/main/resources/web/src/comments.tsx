import React, {useEffect, useState} from 'react';

interface CommentsProps {
    storyId: number
}

export const Comments = ({storyId}: CommentsProps) => {
    const [comments, setComments] = useState([]);

    const CommentsList = () => {
        return (<div>woot</div>)
    }
    useEffect(() => {
        fetch(`http://localhost:8080/comments/${storyId}`)
            .then(resp => resp.json())
            .then(data => setComments(data));
    }, [])

    return (
        <div>{(comments.length)
            ? <CommentsList/>
            : ''}
        </div>)
}
