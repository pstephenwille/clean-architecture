import React, {useEffect, useState} from 'react';

interface CommentsProps{
    parentId: number
    kids: number[]
}
export const Comments:React.FC<CommentsProps> = ({parentId, kids}) =>{
    const [comments, setComments] = useState([]);

    useEffect(() => {
        console.log('%c...kids', 'color:gold', kids)
    }, [])

    return (<div>Comments thread goes here</div>)
}
