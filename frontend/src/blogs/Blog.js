import axios from "axios";
import React from "react";
import Card from "./Card";

function Blog(props) {
  const [post, setPost] = React.useState(null);
  const [isLoaded, setIsLoaded] = React.useState(null);

  React.useState(() => {
    async function getPosts() {
      try {
        const respone = await axios.get(
          "http://localhost:8080/miniblogs/backend/v1/blogs"
        );
        console.log(respone.data);
        setPost(respone.data);
        setIsLoaded(true);
      } catch (error) {
        console.log(error);
      }
    }
    getPosts();
  }, []);

  return (
    <div>
      {isLoaded &&
        post.map((item, index) => {
          return (
            <Card
              key={index}
              blogId={item.blogId}
              authorId={item.authorId}
              blogName={item.blogName}
              blogIntroduction={item.blogIntroduction}
              blogContent={item.blogContent}
              blogPicture={item.blogPicture}
              blogType={item.blogType}
              blogDate={item.blogDate}
              link={`/details/${item.blogId}`}
            />
          );
        })}
    </div>
  );
}

export default Blog;
